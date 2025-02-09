package com.GiovannePDS7.appointmentNotification_api.Business.Services;

import com.GiovannePDS7.appointmentNotification_api.Infrastructure.Repositories.AgendamentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AgendamentoService {
    private final AgendamentoRepository repository;

}
