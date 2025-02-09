package com.GiovannePDS7.appointmentNotification_api.Controller.dtos.Out;

import com.GiovannePDS7.appointmentNotification_api.Infrastructure.Enums.StatusNotificacaoEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;

public record AgendamentoRecordOut(Long id, String emailDestinatario, String telefoneDestinatario, String mensagem,
                                   @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
                                  LocalDateTime dataHoraEnvio,
                                   StatusNotificacaoEnum statusNotificacao) {
}