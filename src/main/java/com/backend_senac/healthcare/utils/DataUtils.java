package com.backend_senac.healthcare.utils;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

public class DataUtils {

    public static String offsetDateTimeToString(OffsetDateTime data) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return data.format(formatter);
    }
}
