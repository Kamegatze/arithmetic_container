package com.shirayev.arithmetic_container.controllers;

import com.shirayev.arithmetic_container.dto.EMeasurementType;
import com.shirayev.arithmetic_container.dto.Request;
import com.shirayev.arithmetic_container.dto.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pmi-120")
public class CotController {

    @PostMapping("/cot")
    public ResponseEntity<Response> handlerGetCotResult(@RequestBody Request request) {

        EMeasurementType type = EMeasurementType.valueOf(request.getMeasurementType());

        Double result = type.equals(EMeasurementType.RADIAN) ?
               1 / Math.tan(request.getValue()) : 1 / Math.tan(request.getValue() * (Math.PI / 180));

        Response response = Response.builder()
                .response(String.valueOf(result))
                .build();

        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }

}
