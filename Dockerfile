FROM openjdk:17-jdk-slim

# Copia el archivo WAR
COPY target/servicio.estacionamiento-0.0.1-SNAPSHOT.war /app.war

# Expone el puerto 8081
EXPOSE 8081

# Ejecuta el archivo WAR usando Java
CMD ["java", "-jar", "/app.war"]
