package it.epicode.ProgettoSettimanale.service;

import it.epicode.ProgettoSettimanale.dto.TripDto;
import it.epicode.ProgettoSettimanale.dto.TripStatusUpdateDto;
import it.epicode.ProgettoSettimanale.enumerating.TripStatus;
import it.epicode.ProgettoSettimanale.model.Trip;
import it.epicode.ProgettoSettimanale.repository.TripRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TripService {

    private final TripRepository tripRepository;

    public Trip create(TripDto dto) {
        Trip trip = Trip.builder()
                .destination(dto.getDestination())
                .date(dto.getDate())
                .status(dto.getStatus())
                .build();
        return tripRepository.save(trip);
    }

    public List<Trip> getAll() {
        return tripRepository.findAll();
    }

    public Trip getById(Long id) {
        return tripRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Trip not found"));
    }

    public Trip update(Long id, TripDto dto) {
        Trip trip = getById(id);
        trip.setDestination(dto.getDestination());
        trip.setDate(dto.getDate());
        return tripRepository.save(trip);
    }

    public Trip updateStatus(Long id, TripStatusUpdateDto dto) {
        Trip trip = getById(id);
        trip.setStatus(dto.getStatus());
        return tripRepository.save(trip);
    }

    public void delete(Long id) {
        if (!tripRepository.existsById(id)) {
            throw new EntityNotFoundException("Trip not found");
        }
        tripRepository.deleteById(id);
    }
}