
package cinema;

import java.time.LocalDateTime;

public class Seat {
  boolean isBooked;
  LocalDateTime bookedAt;

  public void book() {
    this.isBooked = true;
    this.bookedAt = LocalDateTime.now();
  }

  public void cancel() {
    this.isBooked = false;
    this.bookedAt = null;
  }
}
