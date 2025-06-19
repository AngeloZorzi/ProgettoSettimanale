package it.epicode.ProgettoSettimanale.controller;

import it.epicode.ProgettoSettimanale.dto.TripDto;
import it.epicode.ProgettoSettimanale.dto.TripStatusUpdateDto;
import it.epicode.ProgettoSettimanale.model.Trip;
import it.epicode.ProgettoSettimanale.service.TripService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trips")
@RequiredArgsConstructor
public class TripController {

    private final TripService tripService;

    @PostMapping
    public ResponseEntity<Trip> create(@RequestBody @Valid TripDto dto) {
        Trip saved = tripService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @GetMapping
    public ResponseEntity<List<Trip>> getAll() {
        List<Trip> trips = tripService.getAll();
        return ResponseEntity.ok(trips);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Trip> getById(@PathVariable Long id) {
        Trip trip = tripService.getById(id);
        return ResponseEntity.ok(trip);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Trip> update(@PathVariable Long id, @RequestBody @Valid TripDto dto) {
        Trip updated = tripService.update(id, dto);
        return ResponseEntity.ok(updated);
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<Trip> updateStatus(@PathVariable Long id, @RequestBody @Valid TripStatusUpdateDto dto) {
        Trip updated = tripService.updateStatus(id, dto);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        tripService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
