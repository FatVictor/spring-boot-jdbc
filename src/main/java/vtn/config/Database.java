package vtn.config;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import static java.lang.String.join;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;
import static java.util.stream.Collectors.joining;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class Database {

    private static final Logger logger = Logger.getLogger(Database.class.getName());
    @Autowired
    @Value("${mysqldb.url}")
    private String mysqlLocation;
    @Autowired
    @Value("${mysqldb.username}")
    private String mysqlUserName;
    @Autowired
    @Value("${mysqldb.password}")
    private String mysqlPass;

    @Bean
    public JdbcTemplate getJdbcTemplate() {
        DriverManagerDataSource driver = new DriverManagerDataSource(mysqlLocation, mysqlUserName, mysqlPass);
        driver.setDriverClassName(MysqlDataSource.class.getName());
        return new JdbcTemplate(driver) {

            @Override
            public int update(String sql, Object... args) throws DataAccessException {
                try {
                    return super.update(sql, args);
                } catch (DataAccessException ex) {
                    if (ex.getMessage().contains("Data truncated")) {
                        Database.logger.warning(join("\n", ex.getMessage(), sql, Arrays.toString(args)));
                    }
                    throw ex;
                }
            }

            @Override
            public int[] batchUpdate(String sql, List<Object[]> batchArgs) throws DataAccessException {
                try {
                    return super.batchUpdate(sql, batchArgs);
                } catch (DataAccessException ex) {
                    if (ex.getMessage().contains("Data truncated")) {
                        Database.logger.warning(join("\n", ex.getMessage(), sql,
                                batchArgs.stream().map(args -> Arrays.toString(args)).collect(joining("\n"))));
                    }
                    throw ex;
                }
            }
        };
    }

    @Bean
    public DataSource dataSource() {
        return getJdbcTemplate().getDataSource();
    }

    @Bean
    public PlatformTransactionManager txManager() {
        return new DataSourceTransactionManager(getJdbcTemplate().getDataSource());
    }
}
