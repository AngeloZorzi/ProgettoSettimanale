package it.epicode.ProgettoSettimanale.dto;

import it.epicode.ProgettoSettimanale.enumerating.TripStatus;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class TripDto {
    @NotBlank
    private String destination;

    @NotNull
    @FutureOrPresent
    private LocalDate date;

    @NotNull
    private TripStatus status;
}