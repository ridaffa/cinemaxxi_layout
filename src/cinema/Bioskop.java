package cinema;

import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;

import helper.Response;

public class Bioskop {
  LinkedHashMap<String, Seat> seats = new LinkedHashMap<String, Seat>();

  public Bioskop(char seatCode, int seatNumber) {
    for (int i = 1; i <= seatNumber; i++) {
      String seatName = seatCode + String.valueOf(i);
      Seat seat = new Seat();
      seats.put(seatName, seat);
    }
  }

  public Response report() {
    try {
      String res = "";
      for (String seatName : seats.keySet()) {
        Seat seat = seats.get(seatName);
        res += seatName + " - " + (seat.isBooked ? "SOLD" : "FREE") + "\n";
      }
      return new Response(res, false);
    } catch (Exception e) {
      return new Response(e.getMessage(), true);
    }
  }

  public Response bookSeat(String seat) {
    try {
      if (seats.containsKey(seat)) {
        Seat seatObj = seats.get(seat);
        if (seatObj.isBooked) {
          return new Response("kursi telah dipesan, pilih kursi lain", true);
        } else {
          seatObj.book();
          return new Response("kursi berhasil dipesan", false);
        }
      } else {
        return new Response("kursi tidak ditemukan", true);
      }
    } catch (Exception e) {
      return new Response("bad request", true);
    }
  }

  public Response cancelSeat(String seat) {
    try {
      if (seats.containsKey(seat)) {
        Seat seatObj = seats.get(seat);
        if (seatObj.isBooked) {
          seatObj.cancel();
          return new Response("kursi berhasil dibatalkan", false);
        } else {
          return new Response("kursi belum dipesan", true);
        }
      } else {
        return new Response("kursi tidak ditemukan", true);
      }
    } catch (Exception e) {
      return new Response("bad request", true);
    }
  }

  public Response transactionReport() {
    try {
      String res = "";
      int totalSold = 0;
      int totalFree = 0;
      String content = "";
      for (String seatName : seats.keySet()) {
        Seat seat = seats.get(seatName);
        if (seat.isBooked) {
          totalSold++;
          content += seatName + ", " + seat.bookedAt.format(DateTimeFormatter.ofPattern("dd-MMMM-yyyy HH:mm:ss"))
              + "\n";
        } else {
          totalFree++;
        }
      }
      res += "Total " + totalFree + " Free, " + totalSold + " Sold" + "\n\n";
      res += content;
      return new Response(res, false);
    } catch (Exception e) {
      return new Response(e.getMessage(), true);
    }
  }
}
