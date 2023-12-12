package com.shirayev.arithmetic_container.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shirayev.arithmetic_container.dto.EMeasurementType;
import com.shirayev.arithmetic_container.dto.Request;
import com.shirayev.arithmetic_container.dto.Response;
import com.shirayev.arithmetic_container.servisies.TanService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.nio.charset.StandardCharsets;


@WebMvcTest(TanController.class)
public class TestTanController {

    @MockBean
    private TanService tanService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void handlerGetTanResult_IsOk_ReturnTanDegrees() throws Exception {
        /*
         * given
         * */
        Request request = new Request(EMeasurementType.DEGREES.name(), 0.5);

        Response response = new Response(String.valueOf(0.546D));

        /*
         * when
         * */
        Mockito.when(tanService.tan(request)).thenReturn(0.546D);

        /*
         * then
         * */
        MvcResult resultActions = mockMvc.perform(MockMvcRequestBuilders.post("/api/pmi-120/tan")
                        .content(objectMapper.writeValueAsString(request))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.response").value(response.getResponse()))
                .andReturn();
        Mockito.verify(tanService, Mockito.times(1)).tan(request);
        String body = resultActions.getResponse().getContentAsString(StandardCharsets.UTF_8);
        Assertions.assertEquals(body, objectMapper.writeValueAsString(response));
    }

    @Test
    void handlerGetTanResult_IsOk_ReturnTanRadian() throws Exception {
        /*
         * given
         * */
        Request request = new Request(EMeasurementType.RADIAN.name(), 0.5);

        Response response = new Response(String.valueOf(0.546D));

        /*
         * when
         * */
        Mockito.when(tanService.tan(request)).thenReturn(0.546D);

        /*
         * then
         * */
        MvcResult resultActions = mockMvc.perform(MockMvcRequestBuilders.post("/api/pmi-120/tan")
                        .content(objectMapper.writeValueAsString(request))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.response").value(response.getResponse()))
                .andReturn();
        Mockito.verify(tanService, Mockito.times(1)).tan(request);
        String body = resultActions.getResponse().getContentAsString(StandardCharsets.UTF_8);
        Assertions.assertEquals(body, objectMapper.writeValueAsString(response));
    }
}
