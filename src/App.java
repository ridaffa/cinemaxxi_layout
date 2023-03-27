import java.util.Scanner;

import cinema.*;
import handler.*;

public class App {
    public static void main(String[] args) throws Exception {
        try {

            Scanner scanner = new Scanner(System.in);
            System.out.println("=".repeat(20)
                    + " Selamat Datang (Cinema XXI), Silahkan masukkan konfigurasi denah " + "=".repeat(20));
            char seatCode = Handler.getSeatCode(scanner);
            int seatNumber = Handler.getSeatNumber(scanner);
            System.out.println("=".repeat(20) + " Aplikasi Cinema XXI Layout (kursi tersedia " + seatCode + "-"
                    + seatNumber + ") " + "=".repeat(20));
            Cinema cinema = new Cinema(seatCode, seatNumber);
            while (true) {
                String menu = showMenu(scanner);
                boolean exit = Handler.handleMenu(scanner, menu, cinema);
                if (exit) {
                    break;
                }
            }
            scanner.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

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
}
