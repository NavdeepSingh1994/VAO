FROM openjdk:17
COPY out/artifacts/monitoring_tool_jar/monitoring-tool.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
