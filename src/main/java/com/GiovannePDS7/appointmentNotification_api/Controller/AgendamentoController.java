package com.GiovannePDS7.appointmentNotification_api.Controller;

import com.GiovannePDS7.appointmentNotification_api.Business.Services.AgendamentoService;
import com.GiovannePDS7.appointmentNotification_api.Controller.dtos.In.AgendamentoRecordIn;
import com.GiovannePDS7.appointmentNotification_api.Controller.dtos.Out.AgendamentoRecordOut;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/agendamento")
public class AgendamentoController {
    private final AgendamentoService agendamentoService;

    @PostMapping
    public ResponseEntity<AgendamentoRecordOut> gravarAgendamentos(@RequestBody AgendamentoRecordIn agendamento){
        return ResponseEntity.ok(agendamentoService.gravarAgendamento(agendamento));
    }
}
