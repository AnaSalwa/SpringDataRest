# Utiliser une image de base avec JDK 17
FROM openjdk:17-alpine

# Ajouter le fichier JAR à l'image
ADD target/*.jar app.jar

# Définir le point d'entrée de l'application
ENTRYPOINT ["java", "-jar", "app.jar"]
