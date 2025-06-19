package it.epicode.ProgettoSettimanale.dto;

import it.epicode.ProgettoSettimanale.enumerating.TripStatus;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TripStatusUpdateDto {
    @NotNull
    private TripStatus status;
}
