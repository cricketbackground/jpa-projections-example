package com.projections.example.utils;

import lombok.experimental.UtilityClass;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@UtilityClass
public class Utils {
    public LocalDateTime getCurrentSystemTimeConvertedToEST() {
        return ZonedDateTime.now().withZoneSameInstant(ZoneId.of("America/New_York")).toLocalDateTime();
    }
}
