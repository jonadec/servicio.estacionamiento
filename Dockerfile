# Usa una imagen base de OpenJDK
FROM openjdk:17-jdk-slim

# Establece el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copia el archivo JAR generado por Maven al contenedor
COPY target/mi-aplicacion-0.0.1-SNAPSHOT.jar app.jar

# Expone el puerto 8080 para que la aplicación sea accesible
EXPOSE 8080

# Ejecuta el archivo JAR cuando se inicie el contenedor
CMD ["java", "-jar", "app.jar"]
