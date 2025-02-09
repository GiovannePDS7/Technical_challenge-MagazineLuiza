package com.GiovannePDS7.appointmentNotification_api.Infrastructure.Repositories;

import com.GiovannePDS7.appointmentNotification_api.Infrastructure.Entities.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {

}
