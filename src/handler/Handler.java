
package handler;

import java.util.Scanner;

import cinema.*;
import helper.*;

public class Handler {
  final static int MAX_SEAT = 20;

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
      while (!scanner.hasNextInt()) {
        System.out.println("Jumlah kursi harus berupa angka");
        System.out.print("Masukkan Jumlah Kursi: ");
        scanner.next();
      }
      seatNumber = scanner.nextInt();
      if (seatNumber < 1 || seatNumber > MAX_SEAT) {
        System.out.println("Jumlah kursi minimal 1 dan maksimal 20");
      }
    } while (seatNumber < 1 || seatNumber > 20);
    return seatNumber;
  }

  public static void handleReport(Cinema cinema) {
    System.out.println("=".repeat(20) + " Laporan Denah Studio " + "=".repeat(20));
    System.out.println(cinema.report().message);
  }

  public static void handleBookSeat(Scanner scanner, Cinema cinema) {
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

  public static void handleCancelSeat(Scanner scanner, Cinema cinema) {
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

  public static void handleTransactionReport(Cinema cinema) {
    System.out.println("=".repeat(20) + " Laporan Transaksi " + "=".repeat(20));
    System.out.println(cinema.transactionReport().message);
  }

  public static boolean handleMenu(Scanner scanner, String menu, Cinema cinema) {
    menu = menu.toUpperCase();
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
      case "EXIT":
        return true;
      default:
        System.out.println("Menu tidak ditemukan");
        break;
    }
    return false;

  }

}
