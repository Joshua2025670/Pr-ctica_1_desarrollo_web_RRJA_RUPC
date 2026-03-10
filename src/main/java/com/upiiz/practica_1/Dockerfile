FROM eclipse-temurin:17-jdk-alpine
# Creamos un directorio para la app
WORKDIR /app
# Copiamos el archivo .jar que genera Maven a la imagen
COPY target/*.jar app.jar
# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]