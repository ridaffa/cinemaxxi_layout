import java.util.Scanner;

import cinema.*;
import handler.*;

public class App {
    public static void main(String[] args) throws Exception {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("=".repeat(20)
                    + " Selamat Datang (Cinema XXI), Silahkan masukkan konfigurasi denah studio " + "=".repeat(20));
            char seatCode = Handler.getSeatCode(scanner);
            int seatNumber = Handler.getSeatNumber(scanner);
            System.out.println("=".repeat(20) + " Aplikasi Cinema XXI Layout (kursi tersedia " + seatCode + "-"
                    + seatNumber + ") " + "=".repeat(20));
            Bioskop cinema = new Bioskop(seatCode, seatNumber);
            while (true) {
                String menu = Handler.showMenu(scanner);
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
}
