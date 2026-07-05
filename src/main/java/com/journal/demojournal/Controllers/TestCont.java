package com.journal.demojournal.Controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;

@Controller

public class TestCont 
{

    @GetMapping("/as")
    public String as()
    {
        return "views/as";
    }
    
}
