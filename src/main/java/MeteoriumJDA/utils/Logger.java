package MeteoriumJDA.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class Logger {
    // Class public fields
    String logname;
    File logfile;

    // Initializer function
    public Logger(String name) throws IOException {
        logname = name;
        logfile = new File(name + ".txt");

        // Delete any existing file with the same name and recreate it
        if (logfile.exists() && !logfile.isDirectory()) {
            System.out.printf(ANSITerminalColors.YELLOW + "%s [Logger (INIT STAGE - %S)] [WARN]: An existing file with the name \"%s\" already exists! Deleting.", getTimestampString(), logname, logname + ".txt");
            logfile.delete();
        }
        logfile.createNewFile();
    }

    public boolean writeToFile(String content) {
        boolean success = true;
        try {
            logfile.createNewFile();
            Files.write(Paths.get(logname + ".txt"), content.getBytes(), StandardOpenOption.APPEND);
        } catch(IOException exception) {
            success = false;
            System.out.printf(ANSITerminalColors.RED + "[%s][ERROR][%s]: Could not create log file:\n%s" + ANSITerminalColors.RESET, getTimestampString(), logname, Arrays.toString(exception.getStackTrace()));
        }
        return success;
    }

    public void log(String message) {
        String fmsg = "[" + getTimestampString() + "][LOG][" + logname + "]: " + message;
        System.out.printf(ANSITerminalColors.WHITE + fmsg + ANSITerminalColors.RESET);
        writeToFile(fmsg);
    }

    public void warn(String message) {
        String fmsg = "[" + getTimestampString() + "][WARN][" + logname + "]: " + message;
        System.out.printf(ANSITerminalColors.YELLOW + fmsg + ANSITerminalColors.RESET);
        writeToFile(fmsg);
    }

    public void error(String message) {
        String fmsg = "[" + getTimestampString() + "][ERROR][" + logname + "]: " + message;
        System.out.printf(ANSITerminalColors.RED + fmsg + ANSITerminalColors.RESET);
        writeToFile(fmsg);
    }

    public void info(String message) {
        String fmsg = "[" + getTimestampString() + "][INFO][" + logname + "]: " + message;
        System.out.printf(ANSITerminalColors.CYAN + fmsg + ANSITerminalColors.RESET);
        writeToFile(fmsg);
    }

    // Function for providing a string timestamp of the current local time
    public static String getTimestampString() {
        return "[" + DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss").format(LocalDateTime.now()) + "]";
    }
}
