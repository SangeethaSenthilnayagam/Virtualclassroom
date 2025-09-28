package com.virtualclassroom.system;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LoggerUtil {
    public static void log(String message) {
        String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println("[" + time + "] " + message);
    }
}
