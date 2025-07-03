package at.navdeep.monitoring;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.List;

public class LogAnalyzer {
    public static void printLastErrors(String logPath, int numLines) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(logPath));
            List<String> lines = new LinkedList<String>();
            String line;

            while ((line = reader.readLine()) != null) {
                if (line.toLowerCase().contains("error")) {
                    lines.add(line);
                    if (lines.size() > numLines) {
                        lines.remove(0);
                    }
                }
            }

            for (String l : lines) {
                System.out.println(l);
            }

            reader.close();
        } catch (Exception e) {
            System.out.println("Fehler beim Lesen des Logs: " + e.getMessage());
        }
    }
}
