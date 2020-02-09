package com.wtb.controller.api;

import com.wtb.application.colorResponse.ColorService;
import com.wtb.domain.color.Color;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("api/color")
@RequiredArgsConstructor
public class ApiColorController {

    private final ColorService colorService;

    @PostMapping("/add")
    public ResponseEntity<Color> add(@Valid @RequestBody Color color) throws URISyntaxException {
        Color colorSaved = colorService.save(color);
        return ResponseEntity.created(new URI("color/" + colorSaved.getId())).body(colorSaved);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Color> findById(@PathVariable("id") String id) {
        return ResponseEntity.ok(colorService.findById(id));
    }
}
