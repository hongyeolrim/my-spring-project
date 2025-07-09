package com.yedam.app.common.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


/*
    route = Endpoint(URL + Http Method) = HandlerMapping
            + Service
            + 응답형태 (View or Data)
 */
@Controller
public class HomeController {
//    @RequestMapping("/") // => 경로를 지정해주는 메핑
    public String mainPage // Model = Request + Response
                (String message, Model model) {
        model.addAttribute("msg", message);
        return "home";
        // classpath:/template/home.html
    }
    
    @GetMapping("/")
    public String mainPage() {
    	return "home";
    }
    @PostMapping("/")
    public String mainMsgPage(String message, Model model) {
    	model.addAttribute("msg", message);
    	return "home";
    }
}