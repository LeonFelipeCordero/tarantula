package com.ph.tarantula.service.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {

    @GetMapping(value = "/test/{variable}")
    public ModelAndView test(@PathVariable String variable, ModelAndView modelAndView) throws InterruptedException {
        modelAndView.addObject("variable", variable);
        modelAndView.setViewName("index");
        return modelAndView;
    }
}
