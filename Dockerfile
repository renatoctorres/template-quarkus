# Fase de compilação usando a imagem oficial do OpenJDK 21
FROM openjdk:21-jdk-slim AS build

# Define o diretório de trabalho dentro do container
WORKDIR /build

# Copia os arquivos de configuração do Gradle
COPY gradlew /build/
COPY gradle /build/gradle
COPY build.gradle settings.gradle /build/

# Instala as dependências do Gradle
RUN ./gradlew --no-daemon dependencies

# Copia o código fonte do projeto
COPY src /build/src

# Compila a aplicação Quarkus
RUN ./gradlew --no-daemon build -x test

# Fase de execução usando a mesma imagem OpenJDK para manter a consistência
FROM openjdk:21-jdk-slim

# Define o diretório de trabalho para a execução da aplicação
WORKDIR /app

# Copia o JAR compilado para o diretório /app
COPY --from=build /build/build/libs/*.jar /app/application.jar

# Expõe a porta que o Quarkus usa por padrão
EXPOSE 8080

# Define o comando para executar a aplicação
CMD ["java", "-jar", "/app/application.jar"]
