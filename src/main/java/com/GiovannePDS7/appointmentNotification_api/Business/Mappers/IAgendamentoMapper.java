package com.GiovannePDS7.appointmentNotification_api.Business.Mappers;

import com.GiovannePDS7.appointmentNotification_api.Controller.dtos.In.AgendamentoRecordIn;
import com.GiovannePDS7.appointmentNotification_api.Controller.dtos.Out.AgendamentoRecordOut;
import com.GiovannePDS7.appointmentNotification_api.Infrastructure.Entities.Agendamento;
import org.mapstruct.Mapper;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface IAgendamentoMapper {
    Agendamento paraEntitty(AgendamentoRecordIn repository);

    AgendamentoRecordOut paraOut(Agendamento agendamento);
}
