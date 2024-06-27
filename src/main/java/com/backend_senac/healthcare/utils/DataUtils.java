package com.backend_senac.healthcare.utils;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public class DataUtils {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    public static String offsetDateTimeToString(OffsetDateTime data) {
        return data.format(formatter);
    }

    public static OffsetDateTime stringToOffsetDateTime(String data) {
        LocalDateTime localDateTime = LocalDateTime.parse(data, formatter);
        return localDateTime.atOffset(ZoneOffset.systemDefault().getRules().getOffset(localDateTime));
    }
}
