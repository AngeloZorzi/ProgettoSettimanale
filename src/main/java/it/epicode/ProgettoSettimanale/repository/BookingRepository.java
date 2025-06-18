package it.epicode.ProgettoSettimanale.repository;

import it.epicode.ProgettoSettimanale.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    boolean existsByEmployeeIdAndRequestDate(Long employeeId, LocalDate requestDate);
}