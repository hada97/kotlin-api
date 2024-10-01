# Use uma imagem base com o JDK
FROM openjdk:17-jdk-slim

# Defina o diretório de trabalho
WORKDIR /app

# Copie o arquivo de build (JAR) para o contêiner
COPY target/forum-0.0.1-SNAPSHOT.jar /app/myapp.jar

# Exponha a porta em que sua API estará rodando
EXPOSE 8080

# Comando para rodar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]
