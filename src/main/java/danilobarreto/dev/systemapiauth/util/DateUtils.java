package danilobarreto.dev.systemapiauth.util;

import lombok.NoArgsConstructor;
import org.apache.commons.lang3.ObjectUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;

@NoArgsConstructor(access = lombok.AccessLevel.PRIVATE)
public class DateUtils {

    public static String format(LocalDate date, String pattern) {
        return DateTimeFormatter.ofPattern(pattern).format(date);
    }

    public static String format(LocalDateTime date, String pattern) {
        return DateTimeFormatter.ofPattern(pattern).format(date);
    }

    public static int age(LocalDate birthday) {
        if (!ObjectUtils.isEmpty(birthday)) {
            return Period.between(birthday, LocalDate.now()).getYears();
        } else {
            return 0;
        }
    }
}
