package at.navdeep.monitoring;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ServiceChecker {
    public static boolean isServiceRunning(String serviceName) {
        try {
            Process process = new ProcessBuilder("systemctl", "is-active", serviceName).start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String status = reader.readLine();
            return "active".equals(status);
        } catch (Exception e) {
            return false;
        }
    }
}
