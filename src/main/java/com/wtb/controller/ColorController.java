package com.wtb.controller;

import com.wtb.domain.color.Color;
import com.wtb.domain.color.ColorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("color")
@RequiredArgsConstructor
public class ColorController {

    private final ColorRepository colorRepository;

    @ResponseBody
    @PostMapping("/add")
    public Color add(@RequestBody Color color) {
        return colorRepository.save(color);
    }

    @ResponseBody
    @GetMapping()
    public ResponseEntity<Color> findById(@RequestParam("id") String id) {
        Color color;
        try {
            color = colorRepository.findBy(Long.parseLong(id));
        } catch (NumberFormatException nfe) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(color);
    }
}
