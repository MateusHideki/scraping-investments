# Usar imagem do Java
FROM openjdk:17-jdk-slim

# Criar diretório da aplicação
WORKDIR /esalq

# Copiar o JAR construído para dentro do container
COPY target/esalq-0.0.1-SNAPSHOT.jar /app/esalq-0.0.1-SNAPSHOT.jar

# Comando para rodar o app
ENTRYPOINT ["java", "-jar", "/app/esalq-0.0.1-SNAPSHOT.jar"]
