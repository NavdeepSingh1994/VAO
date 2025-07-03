package at.navdeep.monitoring;

import java.net.Socket;

public class DatabaseChecker {
    public static boolean isPostgreSQLAvailable(String host, int port) {
        try (Socket socket = new Socket(host, port)) {
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
