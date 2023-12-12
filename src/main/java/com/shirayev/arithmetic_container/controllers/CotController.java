package com.shirayev.arithmetic_container.controllers;

import com.shirayev.arithmetic_container.dto.Request;
import com.shirayev.arithmetic_container.dto.Response;
import com.shirayev.arithmetic_container.servisies.CotService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/pmi-120")
public class CotController {

    private final CotService cotService;

    @PostMapping("/cot")
    public ResponseEntity<Response> handlerGetCotResult(@RequestBody Request request) {

        Double result = cotService.cot(request);
        Response response = Response.builder()
                .response(String.valueOf(result))
                .build();
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }

}
