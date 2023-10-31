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
public class TanController {

    @PostMapping("/tan")
    public ResponseEntity<Response> handlerGetTanResult(@RequestBody Request request) {

        EMeasurementType type = EMeasurementType.valueOf(request.getMeasurementType());

        Double result = type.equals(EMeasurementType.RADIAN) ?
                Math.tan(request.getValue()) : Math.tan(request.getValue() * (Math.PI / 180));

        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(Response.builder()
                        .response(String.valueOf(result))
                        .build());
    }

}
