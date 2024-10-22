# Étape 1 : Utiliser une image de base Tomcat
FROM tomcat:9.0

# Étape 2 : Supprimer l'application par défaut de Tomcat
RUN rm -rf /usr/local/tomcat/webapps/ROOT

# Étape 3 : Copier le fichier WAR dans le dossier webapps de Tomcat
COPY PainCare.war /usr/local/tomcat/webapps/ROOT.war

# Étape 4 : Exposer le port 8080
EXPOSE 8080

# Étape 5 : Démarrer Tomcat
CMD ["catalina.sh", "run"]
