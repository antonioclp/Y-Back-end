package com.y.back.controllers.dtos;

import java.time.LocalDate;
import java.time.LocalTime;

public record PersonDto(String username, String email, String password, 
    LocalDate createdDate, LocalTime createdTime, String role) {
}
