package com.wtb.controller;

import com.wtb.domain.color.Color;
import com.wtb.domain.color.ColorRepository;
import com.wtb.domain.color.ColorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

@Controller
@RequestMapping("color")
@RequiredArgsConstructor
public class ColorController {

    private final ColorRepository colorRepository;
    private final ColorService colorService;

    @ResponseBody
    @PostMapping("/add")
    public ResponseEntity<Color> add(@RequestBody Color color) throws URISyntaxException {
        Color colorSaved = colorRepository.save(color);
        return ResponseEntity.created(new URI("color/" + color.getId())).body(colorSaved);
    }

    @ResponseBody
    @GetMapping("/{id}")
    public ResponseEntity<Color> findById(@PathVariable("id") String id) {
        return ResponseEntity.ok(colorService.findById(id));
    }
}
