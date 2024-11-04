package org.zerock.springex.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.springex.dto.TodoDTO;

import java.time.LocalDate;

@Log4j2
@Controller
public class SampleController {

    @GetMapping({"/hello", "/hello2"})
    public void getHello() {
        log.info("hello get method....................");

    }

    @PostMapping("/hello")
    public void postHello() {
        log.info("hello post method.....................");
    }

    @GetMapping("/ex1")
    public void ex1(String name, int age) {
        log.info("ex1 get method...................");
        log.info("name : " + name);
        log.info("age : " + age);
    }

    @GetMapping("/ex2")
    public void ex2(@RequestParam(name = "name", defaultValue = "AAA") String name,
                    @RequestParam(name = "age", defaultValue = "222") int age) {
        log.info("ex2 get method...................");
        log.info("name : " + name);
        log.info("age : " + age);
    }

    @GetMapping("/ex3")
    public void ex3(LocalDate dueDate) {
        log.info("ex3...............");
        log.info("dueDate : " + dueDate);
    }

    @GetMapping("/ex4")
    public void ex4(Model model) {
        log.info("ex4........");
        model.addAttribute("message", "Hello world");
    }

    @GetMapping("/ex4-1")
    public void ex41(TodoDTO todoDTO, Model model) {
        log.info("ex4-1.........");
        todoDTO.setWriter("ex41Writer");
        log.info("todoDTO : " + todoDTO);
    }

    @GetMapping("/ex5")
    public String ex5(RedirectAttributes redirectAttributes) {
        redirectAttributes.addAttribute("name","ABC");
        redirectAttributes.addFlashAttribute("result", "success");
        return "redirect:/ex6";
    }

    @GetMapping("/ex6")
    public void ex6(String name, Model model) {
        log.info(name);
        model.addAttribute("name", name);
    }

    @GetMapping("/ex7")
    public void ex7(String  p1, int p2) {
        log.info("p1 = " + p1);
        log.info("p2 = " + p2);
    }
}
