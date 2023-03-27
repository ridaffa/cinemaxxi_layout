package cinema;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import helper.Response;

public class CinemaTest {
  @Test
  public void testBookedSeat() {
    Cinema cinema = new Cinema('A', 10);
    Response res = cinema.bookSeat("A1");
    assertEquals("kursi berhasil dipesan", res.message);
  }

  @Test
  public void testBookInvalidSeat() {
    Cinema cinema = new Cinema('A', 10);
    Response res = cinema.bookSeat("A11");
    assertEquals("kursi tidak ditemukan", res.message);
  }

  @Test
  public void testBookBookedSeat() {
    Cinema cinema = new Cinema('A', 10);
    Response res = cinema.bookSeat("A1");

    res = cinema.bookSeat("A1");
    assertEquals("kursi telah dipesan, pilih kursi lain", res.message);
  }

  @Test
  public void testCancelBookedSeat() {
    Cinema cinema = new Cinema('A', 10);
    Response res = cinema.bookSeat("A1");

    res = cinema.cancelSeat("A1");
    assertEquals("kursi berhasil dibatalkan", res.message);
  }

  @Test
  public void testCancelInvalidSeat() {
    Cinema cinema = new Cinema('A', 10);
    Response res = cinema.cancelSeat("A11");
    assertEquals("kursi tidak ditemukan", res.message);
  }

  @Test
  public void testCancelFreeSeat() {
    Cinema cinema = new Cinema('A', 10);
    Response res = cinema.cancelSeat("A1");
    assertEquals("kursi belum dipesan", res.message);
  }
}
