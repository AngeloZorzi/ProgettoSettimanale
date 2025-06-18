package it.epicode.ProgettoSettimanale.repository;

import it.epicode.ProgettoSettimanale.model.Trip;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TripRepository extends JpaRepository<Trip, Long> {
}
