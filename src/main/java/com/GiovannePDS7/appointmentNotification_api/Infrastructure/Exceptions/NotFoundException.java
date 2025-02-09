package com.GiovannePDS7.appointmentNotification_api.Infrastructure.Exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super(message);
    }
}
