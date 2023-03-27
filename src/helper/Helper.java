package helper;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Helper {
  public static String convertDate(LocalDateTime date) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-yyyy HH:mm:ss")
        .withLocale(Locale.of("id", "ID"));
    return date.format(formatter).toLowerCase();
  }
}
