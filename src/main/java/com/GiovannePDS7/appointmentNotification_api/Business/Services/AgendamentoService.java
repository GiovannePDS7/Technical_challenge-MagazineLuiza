package com.GiovannePDS7.appointmentNotification_api.Business.Services;

import com.GiovannePDS7.appointmentNotification_api.Business.Mappers.IAgendamentoMapper;
import com.GiovannePDS7.appointmentNotification_api.Controller.dtos.In.AgendamentoRecordIn;
import com.GiovannePDS7.appointmentNotification_api.Controller.dtos.Out.AgendamentoRecordOut;
import com.GiovannePDS7.appointmentNotification_api.Infrastructure.Repositories.AgendamentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AgendamentoService {
    private final AgendamentoRepository repository;
    private final IAgendamentoMapper agendamentoMapper;

    public AgendamentoRecordOut gravarAgendamento(AgendamentoRecordIn agendamento){
        return agendamentoMapper.paraOut(repository.save(agendamentoMapper.paraEntitty(agendamento)));
    }
}
