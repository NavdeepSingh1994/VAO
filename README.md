# Monitoring Tool (Java)

🛠Kleines Monitoring-Tool in Java zur Systemprüfung – ideal für Linux/CI/CD-Umgebungen.

## Features

- Service Check via `systemctl`
- RAM-Ausgabe via `free -m`
- PostgreSQL-Port-Check
- Logfile-Analyse (Fehlermeldungen)
- Export der Ergebnisse als JSON

## Quickstart

```bash
mvn clean install
java -cp target/monitoring-tool-1.0-SNAPSHOT.jar at.navdeep.monitoring.MonitoringApp
