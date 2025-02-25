package com.GiovannePDS7.appointmentNotification_api.controller;

import com.GiovannePDS7.appointmentNotification_api.Controller.AgendamentoController;
import com.GiovannePDS7.appointmentNotification_api.Controller.dtos.In.AgendamentoRecordIn;
import com.GiovannePDS7.appointmentNotification_api.Controller.dtos.Out.AgendamentoRecordOut;
import com.GiovannePDS7.appointmentNotification_api.Infrastructure.Enums.StatusNotificacaoEnum;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.GiovannePDS7.appointmentNotification_api.Business.Services.AgendamentoService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;

import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.mockito.Mock;

import java.time.LocalDateTime;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class AgendamentoControllerTest {

    @Mock
    private AgendamentoService agendamentoService;

    @InjectMocks
    private AgendamentoController agendamentoController;

    private MockMvc mockMvc;

    private ObjectMapper objectMapper = new ObjectMapper();

    private AgendamentoRecordIn agendamentoRecord;
    private AgendamentoRecordOut agendamentoRecordOut;

    @BeforeEach
    void setUp() {

        mockMvc = MockMvcBuilders.standaloneSetup(agendamentoController).build();

        objectMapper.registerModule(new JavaTimeModule());

        agendamentoRecord = new AgendamentoRecordIn("email@email.com", "55887996578",
                "Favor retornar a loja com urgência", LocalDateTime.of(2025, 1, 2, 11, 1, 1));

        agendamentoRecordOut = new AgendamentoRecordOut(1L, "email@email.com", "55887996578",
                "Favor retornar a loja com urgência", LocalDateTime.of(2025, 1, 2, 11, 1, 1),
                StatusNotificacaoEnum.AGENDADO);
    }

    @Test
    void deveCriarAgendamentoComSucesso() throws Exception {
        when(agendamentoService.gravarAgendamento(agendamentoRecord)).thenReturn(agendamentoRecordOut);

        mockMvc.perform(post("/agendamento")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsBytes(agendamentoRecord)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.emailDestinatario").value("email@email.com"))
                .andExpect(jsonPath("$.telefoneDestinatario").value(agendamentoRecordOut.telefoneDestinatario()))
                .andExpect(jsonPath("$.mensagem").value(agendamentoRecordOut.mensagem()))
                .andExpect(jsonPath("$.dataHoraEnvio").value("02-01-2025 11:01:01"))
                .andExpect(jsonPath("$.statusNotificacao").value("AGENDADO"));

        verify(agendamentoService, times(1)).gravarAgendamento(agendamentoRecord);


    }

}