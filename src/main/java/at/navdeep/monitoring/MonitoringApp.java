package at.navdeep.monitoring;

public class MonitoringApp {
    public static void main(String[] args) {
        System.out.println("==== Monitoring Tool gestartet ====");

        String service = "ssh"; // z. B. nginx, apache2, ssh
        System.out.println("Service '" + service + "' aktiv: " + ServiceChecker.isServiceRunning(service));

        System.out.println("\n--- Speicherverbrauch ---");
        ResourceMonitor.printResourceUsage();

        System.out.println("\n--- PostgreSQL erreichbar ---");
        System.out.println(DatabaseChecker.isPostgreSQLAvailable("localhost", 5432));

        System.out.println("\n--- Letzte Fehler aus Log ---");
        LogAnalyzer.printLastErrors("testlog.txt", 10); // Alternativ: "/var/log/syslog"

        String[] dummyErrors = { "ERROR 1", "ERROR 2", "ERROR 3" };
        JsonExporter.exportToJson("report.json", false, false, dummyErrors);
    }
}
