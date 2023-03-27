package cinema;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import helper.Response;

public class BioskopTest {
  @Test
  public void testBookedSeat() {
    Bioskop cinema = new Bioskop('A', 10);
    Response res = cinema.bookSeat("A1");
    assertEquals("kursi berhasil dipesan", res.message);
  }

  @Test
  public void testBookInvalidSeat() {
    Bioskop cinema = new Bioskop('A', 10);
    Response res = cinema.bookSeat("A11");
    assertEquals("kursi tidak ditemukan", res.message);
  }

  @Test
  public void testBookBookedSeat() {
    Bioskop cinema = new Bioskop('A', 10);
    Response res = cinema.bookSeat("A1");

    res = cinema.bookSeat("A1");
    assertEquals("kursi telah dipesan, pilih kursi lain", res.message);
  }

  @Test
  public void testCancelBookedSeat() {
    Bioskop cinema = new Bioskop('A', 10);
    Response res = cinema.bookSeat("A1");

    res = cinema.cancelSeat("A1");
    assertEquals("kursi berhasil dibatalkan", res.message);
  }

  @Test
  public void testCancelInvalidSeat() {
    Bioskop cinema = new Bioskop('A', 10);
    Response res = cinema.cancelSeat("A11");
    assertEquals("kursi tidak ditemukan", res.message);
  }

  @Test
  public void testCancelFreeSeat() {
    Bioskop cinema = new Bioskop('A', 10);
    Response res = cinema.cancelSeat("A1");
    assertEquals("kursi belum dipesan", res.message);
  }
}
