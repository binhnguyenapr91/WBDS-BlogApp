package controller;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
public class SecurityController {

    @RequestMapping("/")
    public String getIndex(){
        return "index";
    }

    @GetMapping("/userPage")
    public String getUserPage(Principal principal){
        System.out.println(principal.getName());
        return "userPage";
    }

    @GetMapping("/adminPage")
    public String getAdminPage(){
        SecurityContext context = SecurityContextHolder.getContext();
        System.out.println(context.getAuthentication().getName());
        return "adminPage";
    }
}
