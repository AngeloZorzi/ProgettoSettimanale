package it.epicode.ProgettoSettimanale.service;

import it.epicode.ProgettoSettimanale.dto.BookingDto;
import it.epicode.ProgettoSettimanale.exception.BookingConflictException;
import it.epicode.ProgettoSettimanale.exception.ResourceNotFoundException;
import it.epicode.ProgettoSettimanale.model.Booking;
import it.epicode.ProgettoSettimanale.model.Employee;
import it.epicode.ProgettoSettimanale.model.Trip;
import it.epicode.ProgettoSettimanale.repository.BookingRepository;
import it.epicode.ProgettoSettimanale.repository.EmployeeRepository;
import it.epicode.ProgettoSettimanale.repository.TripRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookingService {

    private final BookingRepository bookingRepository;
    private final EmployeeService employeeService;
    private final TripService tripService;
    private final EmployeeRepository employeeRepository;
    private final TripRepository tripRepository;

    public Booking create(BookingDto dto) {
        Employee employee = employeeRepository.findById(dto.getEmployeeId())
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found"));
        Trip trip = tripRepository.findById(dto.getTripId())
                .orElseThrow(() -> new ResourceNotFoundException("Trip not found"));

        boolean alreadyBooked = bookingRepository.existsByEmployeeAndRequestDate(employee, dto.getRequestDate());
        if (alreadyBooked) {
            throw new BookingConflictException("Employee already has a booking on " + dto.getRequestDate());
        }

        Booking booking = Booking.builder()
                .employee(employee)
                .trip(trip)
                .requestDate(dto.getRequestDate())
                .notes(dto.getNotes())
                .preferences(dto.getPreferences())
                .build();

        return bookingRepository.save(booking);
    }
}