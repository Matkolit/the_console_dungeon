FROM eclipse-temurin:21-jdk

WORKDIR /app
COPY src/ /app/src/

CMD ["sh", "-c", "javac src/Main.java && java -cp /app src.Main"]
