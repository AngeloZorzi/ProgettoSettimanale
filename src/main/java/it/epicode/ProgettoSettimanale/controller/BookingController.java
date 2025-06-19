package it.epicode.ProgettoSettimanale.controller;

import it.epicode.ProgettoSettimanale.dto.BookingDto;
import it.epicode.ProgettoSettimanale.model.Booking;
import it.epicode.ProgettoSettimanale.service.BookingService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bookings")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;

    @PostMapping
    public ResponseEntity<Booking> create(@RequestBody @Valid BookingDto dto) {
        Booking saved = bookingService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }
}