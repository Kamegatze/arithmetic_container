package com.shirayev.arithmetic_container.controllers;

import com.shirayev.arithmetic_container.dto.Request;
import com.shirayev.arithmetic_container.dto.Response;
import com.shirayev.arithmetic_container.servisies.TanService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/pmi-120")
public class TanController {

    private final TanService tanService;

    @PostMapping("/tan")
    public ResponseEntity<Response> handlerGetTanResult(@RequestBody Request request) {

        Double result = tanService.tan(request);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(Response.builder()
                        .response(String.valueOf(result))
                        .build());
    }

}
