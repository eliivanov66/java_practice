package com.example.hometask2_1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class MyController {
    @GetMapping("/")
    public String home() {
        return MyView.draw();
    }

    @GetMapping("/delete")
    public String delete() {
        return MyView.delete();
    }

    @GetMapping("/add")
    public String add() {
        return MyView.add();
    }

//    @PutMapping
//    public void addNew(){}


}
