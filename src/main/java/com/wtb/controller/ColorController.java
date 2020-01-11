package com.wtb.controller;

import com.wtb.domain.color.Color;
import com.wtb.domain.color.ColorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("color")
@RequiredArgsConstructor
public class ColorController {

    private final ColorRepository colorRepository;

    @ResponseBody
    @PostMapping("/add")
    Color add(@RequestBody Color color){
        return  colorRepository.save(color);
    }

    @ResponseBody
    @GetMapping()
    public Color getById(@RequestParam ("id") Long id){
        return colorRepository.getById(id);
    }
}
