# Usa una imagen base de OpenJDK
FROM openjdk:17-jdk-slim

# Asumiendo que el archivo WAR está en el directorio local 'target/'
COPY target/servicio.estacionamiento-0.0.1-SNAPSHOT.war /app.war


# Expone el puerto 8081 para que la aplicación sea accesible
EXPOSE 8081

CMD ["catalina.sh", "run"]