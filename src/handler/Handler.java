
package handler;

import java.util.Scanner;

import cinema.*;
import helper.*;

public class Handler {
  final static int MAX_SEAT = 20;

  public static String showMenu(Scanner scanner) {
    System.out.println("=".repeat(20) + " Menu " + "=".repeat(20));
    System.out.println("A) Pemesanan Kursi");
    System.out.println("B) Batalkan Kursi");
    System.out.println("C) Laporan Denah");
    System.out.println("D) Laporan Transaksi");
    System.out.println();
    System.out.println("Masukkan `exit` untuk keluar");

    System.out.print("Pilih menu: ");
    return scanner.next();
  }

  public static char getSeatCode(Scanner scanner) {
    String seatCode;
    do {
      System.out.print("Masukkan Kode Kursi: ");
      seatCode = scanner.next();
      if (seatCode.length() > 1) {
        System.out.println("Kode kursi hanya boleh 1 karakter");
      }
    } while (seatCode.length() > 1);
    return seatCode.charAt(0);
  }

  public static int getSeatNumber(Scanner scanner) {
    int seatNumber = 0;
    do {
      System.out.print("Masukkan Jumlah Kursi: ");
      seatNumber = scanner.nextInt();
      if (seatNumber < 1 || seatNumber > MAX_SEAT) {
        System.out.println("Jumlah kursi minimal 1 dan maksimal 20");
      }
    } while (seatNumber < 1 || seatNumber > 20 || !Helper.isInteger(String.valueOf(seatNumber)));
    return seatNumber;
  }

  public static void handleReport(Bioskop cinema) {
    System.out.println("=".repeat(20) + " Laporan Denah Studio " + "=".repeat(20));
    System.out.println(cinema.report().message);
  }

  public static void handleBookSeat(Scanner scanner, Bioskop cinema) {
    try {
      boolean success = false;
      do {
        System.out.print("Masukkan Kode Kursi: ");
        String seat = scanner.next();
        Response res = cinema.bookSeat(seat);
        if (res.error) {
          System.out.println(res.message);
        } else {
          System.out.println(res.message);
          success = true;
        }
      } while (!success);

    } catch (RuntimeException e) {
      System.out.println(e.getMessage());
    }
  }

  public static void handleCancelSeat(Scanner scanner, Bioskop cinema) {
    try {
      boolean success = false;
      do {
        System.out.print("Masukkan Kode Kursi: ");
        String seat = scanner.next();
        Response res = cinema.cancelSeat(seat);
        if (res.error) {
          System.out.println(res.message);
        } else {
          System.out.println(res.message);
          success = true;
        }
      } while (!success);

    } catch (RuntimeException e) {
      System.out.println(e.getMessage());
    }
  }

  public static void handleTransactionReport(Bioskop cinema) {
    System.out.println("=".repeat(20) + " Laporan Transaksi " + "=".repeat(20));
    System.out.println(cinema.transactionReport().message);
  }

  public static boolean handleMenu(Scanner scanner, String menu, Bioskop cinema) {
    switch (menu) {
      case "A":
        handleBookSeat(scanner, cinema);
        break;
      case "B":
        handleCancelSeat(scanner, cinema);
        break;
      case "C":
        handleReport(cinema);
        break;
      case "D":
        handleTransactionReport(cinema);
        break;
      case "exit":
        return true;
      default:
        System.out.println("Menu tidak ditemukan");
        break;
    }
    return false;
  }

}
