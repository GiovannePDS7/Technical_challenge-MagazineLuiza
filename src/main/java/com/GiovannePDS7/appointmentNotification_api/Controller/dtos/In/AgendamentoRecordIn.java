package com.GiovannePDS7.appointmentNotification_api.Controller.dtos.In;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;

public record AgendamentoRecordIn(String emailDestinatario, String telefoneDestinatario, String mensagem,
                                  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
                                LocalDateTime dataHoraEnvio) {
}