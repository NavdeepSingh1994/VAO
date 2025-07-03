package at.navdeep.monitoring;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class JsonExporter {
    public static void exportToJson(String fileName, boolean sshStatus, boolean dbStatus, String[] errors) {
        Map<String, Object> data = new HashMap<>();
        data.put("service_ssh", sshStatus);
        data.put("postgresql_reachable", dbStatus);
        data.put("last_errors", errors);

        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File(fileName), data);
            System.out.println("✅ JSON exportiert: " + fileName);
        } catch (Exception e) {
            System.out.println("❌ Fehler beim Exportieren: " + e.getMessage());
        }
    }
}
