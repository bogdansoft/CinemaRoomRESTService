package cinema.controller;

import cinema.config.CinemaRoomProperties;
import cinema.exception.WrongPasswordException;
import cinema.model.*;
import cinema.service.CinemaRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
public class CinemaRoomController {
    @Autowired
    CinemaRoomService cinemaRoomService;
    @Autowired
    CinemaRoomProperties cinemaRoomProperties;

    @GetMapping("/seats")
    CinemaRoom getAvailableSeats() {
        return cinemaRoomService.getAvailableSeats();
    }

    @PostMapping("/purchase")
    SoldTicketResponse purchase(@RequestBody Seat seat) {
        return cinemaRoomService.purchase(seat);
    }

    @PostMapping("/return")
    Map<String, Object> returnTicket(@RequestBody ReturnRequest returnRequest) {
        Seat seat = cinemaRoomService.returnTicket(returnRequest.getToken());
        return Map.of("returned_ticket", seat);
    }

    @PostMapping("/stats")
    StatsResponse stats(@RequestParam Optional<String> password) {
        return password.filter(cinemaRoomProperties.getSecret()::equals)
                .map(p -> cinemaRoomService.getStats())
                .orElseThrow(WrongPasswordException::new);
    }
}
