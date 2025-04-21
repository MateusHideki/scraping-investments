# Usar imagem do Java
FROM openjdk:17-jdk-slim

# Criar diretório da aplicação
WORKDIR /app

# Copiar o JAR construído para dentro do container
COPY target/scraping-investments-0.0.1-SNAPSHOT.jar /app/scraping-investments-0.0.1-SNAPSHOT.jar

# Comando para rodar o app
ENTRYPOINT ["java", "-jar", "/app/scraping-investments-0.0.1-SNAPSHOT.jar"]
