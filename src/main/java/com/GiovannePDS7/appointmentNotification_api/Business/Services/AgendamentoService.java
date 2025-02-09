package com.GiovannePDS7.appointmentNotification_api.Business.Services;

import com.GiovannePDS7.appointmentNotification_api.Business.Mappers.IAgendamentoMapper;
import com.GiovannePDS7.appointmentNotification_api.Controller.dtos.In.AgendamentoRecordIn;
import com.GiovannePDS7.appointmentNotification_api.Controller.dtos.Out.AgendamentoRecordOut;
import com.GiovannePDS7.appointmentNotification_api.Infrastructure.Entities.Agendamento;
import com.GiovannePDS7.appointmentNotification_api.Infrastructure.Enums.StatusNotificacaoEnum;
import com.GiovannePDS7.appointmentNotification_api.Infrastructure.Exceptions.NotFoundException;
import com.GiovannePDS7.appointmentNotification_api.Infrastructure.Repositories.AgendamentoRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.NotFound;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AgendamentoService {
    private final AgendamentoRepository repository;
    private final IAgendamentoMapper agendamentoMapper;

    public AgendamentoRecordOut gravarAgendamento(AgendamentoRecordIn agendamento){
        return agendamentoMapper.paraOut(repository.save(agendamentoMapper.paraEntity(agendamento)));
    }

    public AgendamentoRecordOut buscarAgendamentosPorId(Long id){
        return agendamentoMapper.paraOut(repository.findById(id).orElseThrow(() -> new NotFoundException("Id não encontrado")));
    }

    public void cancelarAgendamento(Long id){
        Agendamento agendamento = repository.findById(id).orElseThrow(() -> new NotFoundException("Id não encontrado"));
        repository.save(agendamentoMapper.paraEntityCancelamento(agendamento));

    }
}
