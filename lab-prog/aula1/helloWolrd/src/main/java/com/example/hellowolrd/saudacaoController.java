package com.example.hellowolrd;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class saudacaoController{
    private final AtomicLong contador = new AtomicLong();
    private static final String template = "Hello, %s";

    @GetMapping("/saudacao")
    public saudacao saudacao(
            @RequestParam(value = "name", defaultValue = "World")String name){
                return new saudacao(contador.incrementAndGet(),
                        String.format(template, name));

    }


}
