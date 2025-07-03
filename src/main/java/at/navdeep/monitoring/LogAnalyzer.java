package at.navdeep.monitoring;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.List;

public class LogAnalyzer {
    public static String[] readLastErrors(String logPath, int numLines) {
        List<String> lines = new LinkedList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(logPath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.toLowerCase().contains("error")) {
                    lines.add(line);
                    if (lines.size() > numLines) {
                        lines.remove(0);
                    }
                }
            }
        } catch (Exception e) {
            lines.add("❌ Fehler beim Lesen des Logs: " + e.getMessage());
        }
        return lines.toArray(new String[0]);
    }
}
