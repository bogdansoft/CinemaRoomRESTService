package cinema.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Collection;

@Getter
@Setter
public class CinemaRoom {
    int totalRows;
    int totalColumns;
    Collection<Seat> availableSeats;
}
