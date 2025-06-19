package it.epicode.ProgettoSettimanale.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;

@Data
public class BookingDto {
    @NotNull
    private Long employeeId;

    @NotNull
    private Long tripId;

    @NotNull
    private LocalDate requestDate;

    @Size(max = 500)
    private String notes;

    @Size(max = 500)
    private String preferences;
}
