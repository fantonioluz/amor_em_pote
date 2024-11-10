# Fase de Builder
FROM maven:3.9.5-eclipse-temurin-17 AS builder

# Define o diretório de trabalho
WORKDIR /amor_em_pote

# Copia o Maven Wrapper, a pasta .mvn e o pom.xml
COPY mvnw .
# Copia o mvnw para /amor_em_pote
COPY .mvn .mvn
# Copia a pasta .mvn para /amor_em_pote
COPY pom.xml .
# Copia o pom.xml para /amor_em_pote

# Concede permissão de execução ao Maven Wrapper
RUN chmod +x mvnw

# Resolve dependências do Maven
RUN ./mvnw dependency:resolve

# Copia o código-fonte do projeto
COPY src ./src

# Compila o projeto (gera o JAR)
RUN ./mvnw package -DskipTests

# Fase Final: criar a imagem para execução
FROM eclipse-temurin:17-jdk-alpine

# Define o diretório de trabalho
WORKDIR /amor_em_pote

# Copia o JAR gerado para a imagem final
COPY --from=builder /amor_em_pote/target/*.jar app.jar

# Expõe a porta padrão do Spring Boot
EXPOSE 8080

# Comando para executar o JAR
CMD ["java", "-jar", "app.jar"]
