package com.shirayev.arithmetic_container.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shirayev.arithmetic_container.dto.EMeasurementType;
import com.shirayev.arithmetic_container.dto.Request;
import com.shirayev.arithmetic_container.dto.Response;
import com.shirayev.arithmetic_container.servisies.CotService;
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

@WebMvcTest(CotController.class)
public class TestCotController {

    @MockBean
    private CotService cotService;
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void handlerGetCotResult_IsOk_ReturnCotRadian() throws Exception {
        /*
        * given
        * */
        Request request = new Request(EMeasurementType.RADIAN.name(), 0.5);

        Response response = new Response(String.valueOf(1.830D));

        /*
        * when
        * */
        Mockito.when(cotService.cot(request)).thenReturn(1.830D);

        /*
        * then
        * */
        MvcResult resultActions = mockMvc.perform(MockMvcRequestBuilders.post("/api/pmi-120/cot")
                        .content(objectMapper.writeValueAsString(request))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.response").value(response.getResponse()))
                .andReturn();
        Mockito.verify(cotService, Mockito.times(1)).cot(request);
        String body = resultActions.getResponse().getContentAsString(StandardCharsets.UTF_8);
        Assertions.assertEquals(body, objectMapper.writeValueAsString(response));

    }

    @Test
    void handlerGetCotResult_IsOk_ReturnCotDegrees() throws Exception {
        /*
         * given
         * */
        Request request = new Request(EMeasurementType.DEGREES.name(), 90D);

        Response response = new Response(String.valueOf(0D));

        /*
         * when
         * */
        Mockito.when(cotService.cot(request)).thenReturn(0D);

        /*
         * then
         * */
        MvcResult resultActions = mockMvc.perform(MockMvcRequestBuilders.post("/api/pmi-120/cot")
                        .content(objectMapper.writeValueAsString(request))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.response").value(response.getResponse()))
                .andReturn();
        Mockito.verify(cotService, Mockito.times(1)).cot(request);
        String body = resultActions.getResponse().getContentAsString(StandardCharsets.UTF_8);
        Assertions.assertEquals(body, objectMapper.writeValueAsString(response));
    }
}
