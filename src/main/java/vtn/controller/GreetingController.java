package vtn.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import vtn.model.User;

@Controller
public class GreetingController {

    private static final Logger logger = Logger.getLogger(GreetingController.class.getName());
    @Autowired
    private JdbcTemplate db;

    @RequestMapping(value = {"/", "/hello"})
    public String index() {
        return "hello";
    }

    @RequestMapping("users")
    public String list(Model model) {
        model.addAttribute("users", db.query("SELECT * FROM users", (rs, i) -> new User(rs)));
        return "users";
    }

    @ModelAttribute(value = "author")
    public String getAuthor() {
        return "Victor Nguyen";
    }

    @RequestMapping("err")
    public String error(Model model) {
        throw new RuntimeException("Sample for error!");
    }
}
