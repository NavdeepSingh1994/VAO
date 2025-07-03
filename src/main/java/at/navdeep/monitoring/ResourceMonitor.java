package at.navdeep.monitoring;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ResourceMonitor {
    public static void printResourceUsage() {
        try {
            Process process = new ProcessBuilder("free", "-m").start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception e) {
            System.out.println("Fehler beim Abrufen der Speicherinformationen: " + e.getMessage());
        }
    }
}
