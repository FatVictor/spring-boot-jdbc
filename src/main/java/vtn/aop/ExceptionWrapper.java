package vtn.aop;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionWrapper {

    private static final Logger logger = Logger.getLogger(ExceptionWrapper.class.getName());

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public String handleException(Exception e, HttpServletResponse response) {
        logger.log(Level.SEVERE, "Unexpected exception occurred!", e);
        return "Well, something wrong happened. Pls check log for more details!";
    }
}
