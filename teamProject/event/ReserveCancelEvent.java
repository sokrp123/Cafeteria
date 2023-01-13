//package event;
package teamProject.event;
import teamProject.model.Reservation;

public interface ReserveCancelEvent {
    void cancelReserveId(Reservation reservation);
}
