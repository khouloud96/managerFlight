/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flight.managerFlight.service;

import com.flight.managerFlight.dto.BookingDto;
import com.flight.managerFlight.dto.PassengerDtO;
import com.flight.managerFlight.entities.Booking;
import com.flight.managerFlight.entities.Flight;
import com.flight.managerFlight.entities.Passenger;
import com.flight.managerFlight.repository.BookingRepository;
import com.flight.managerFlight.repository.PassengerRepository;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author DELL
 */
@Service
public class BookingService {
    @Autowired
    private BookingRepository bookingRepository;
    
    @Autowired
    private PassengerRepository passengerRepository;
    
    public static BookingDto mapToDto(Booking booking) {
        if (booking != null) {
            return new BookingDto(
                    booking.getId(),
                    booking.getPassenger(),
                    booking.getFlight(),
                    booking.getSeats(),
                    booking.getTotPrice()
            );
        }
        return null;
    }
    
    public List<BookingDto> getBookings() {
        return this.bookingRepository.findAll()
                .stream()
                .map(BookingService::mapToDto)
                .collect(Collectors.toList());
    }

    public BookingDto getBookingById(Long id) {
        return bookingRepository.findById(id).map(BookingService::mapToDto).orElse(null);
    }
    
    public Booking getBookingByPassenger(String idPassenger) {
        return bookingRepository.findByPassenger(passengerRepository.findById(idPassenger).get());
    }
    
    public BigDecimal calculTotPrice(Booking booking){
        Flight flight= booking.getFlight();
        BigDecimal unitPrice = flight.getLine().getUnitPrice();
        BigDecimal totPrice = BigDecimal.valueOf(booking.getSeats()).multiply(unitPrice);
        return totPrice;
    }
    
    public BookingDto addBooking(BookingDto bookingDto){
        Booking b = new Booking(
                        bookingDto.getId(),
                        bookingDto.getPassenger(),
                        bookingDto.getFlight(),
                        bookingDto.getSeats()
                );
        b.setTotPrice(calculTotPrice(b));
        return mapToDto(
                bookingRepository.save(b)
        );
    }
    
     public void cancelBooking(Long id) {
        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Cannot find Booking with id " + id));

        bookingRepository.delete(booking);
    }
}
