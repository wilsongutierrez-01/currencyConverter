package alura.courses.com.logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {

    private static final Path LOG_DIR = Path.of("logs");
    private static final Path LOG_FILE = LOG_DIR.resolve("conversion_history.txt");
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public Logger() {
        try {
            Files.createDirectories(LOG_DIR);
            if (!Files.exists(LOG_FILE)) {
                Files.createFile(LOG_FILE);
            }
        } catch (IOException e) {
            throw new RuntimeException("Couldn't start logger...", e);
        }
    }

    public void log(String base, String target, double amount, double result, double rate) {
        String timestamp = LocalDateTime.now().format(FORMATTER);
        String line = String.format("%s | %.2f %s -> %.2f %s | rate=%.6f%n",
                timestamp, amount, base, result, target, rate);

        try {
            Files.writeString(LOG_FILE, line,
                    StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RuntimeException("Error while writing file...", e);
        }
    }
}