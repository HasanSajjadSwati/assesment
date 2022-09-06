package com.example.demo.utils;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class DateTimeUtil {

    public static Date currentTimestamp() {
        Date currentDate = Date.from(Instant.now());
        return currentDate;
    }


    public static Date expiryTimestamp(int seconds) {
        Date expiryDate = Date.from(Instant.now().plusSeconds(seconds));
        return expiryDate;
    }
    
    
    public static Date convertToDateViaInstant(LocalDateTime dateToConvert, ZoneId timezone) {
    return java.util.Date
      .from(dateToConvert.atZone(timezone)
      .toInstant());
    }
    
    
    public static LocalDateTime convertToLocalDateTimeViaInstant(Date dateToConvert, ZoneId timezone) {
        return dateToConvert.toInstant()
          .atZone(timezone)
          .toLocalDateTime();
    }
    
    
    public static Date ConvertDateToTimeZone(Date dateToConvert, ZoneId timezone) {
       LocalDateTime ldt = LocalDateTime.ofInstant(dateToConvert.toInstant(), timezone);
       Date out = Date.from(ldt.atZone(timezone).toInstant());
       return out;
    }
}
