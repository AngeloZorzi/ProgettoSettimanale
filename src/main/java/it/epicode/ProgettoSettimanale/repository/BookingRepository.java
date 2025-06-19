package it.epicode.ProgettoSettimanale.repository;

import it.epicode.ProgettoSettimanale.model.Booking;
import it.epicode.ProgettoSettimanale.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface BookingRepository extends JpaRepository<Booking, Long> {

    boolean existsByEmployeeAndRequestDate(Employee employee, LocalDate requestDate);
}