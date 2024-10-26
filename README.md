
# Backend SpringDataRest

Ceci est la partie backend de l'application Voiture Shop, construite avec Spring Boot, Java 17, et dockerisée pour un déploiement facile. Le projet intègre Spring Boot Actuator, Prometheus et Grafana pour la surveillance et la visualisation des performances. Ce guide fournit des étapes pour configurer, construire, exécuter et surveiller le service backend en utilisant Docker Compose.

## Prérequis

Assurez-vous d'avoir les éléments suivants installés :

- **JDK 17** 
- **Docker** 
- **Git** 

## Instructions de configuration et de construction


### 1. Cloner le dépôt

Tout d'abord, clonez le dépôt depuis GitHub et accédez au répertoire du projet :

```bash
git clone https://github.com/AnaSalwa/SpringDataRest.git
cd SpringDataRest
```

### 2. Ajouter des dépendances

Pour intégrer Prometheus, Spring Boot Actuator et Grafana pour la surveillance, vous devez ajouter les dépendances suivantes à votre `pom.xml` :

```xml
<dependency>
    <groupId>io.micrometer</groupId>
    <artifactId>micrometer-registry-prometheus</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
```


### 3. Construire le backend avec Maven

Avant de construire l'image Docker, assurez-vous que le projet est compilé en exécutant la commande Maven suivante :

```bash
mvn clean package -DskipTests
```

⚠️ **Remarque** : Les tests sont ignorés ici à l'aide du drapeau `-DskipTests` pour accélérer le processus de construction. Vous pouvez supprimer ce drapeau si vous souhaitez exécuter les tests.

### 4. Construire l'image Docker

Une fois le projet construit, créez l'image Docker pour le service backend en utilisant :

```bash
docker build -t backend-spring .
```

Cela générera une image Docker pour le backend en utilisant le Dockerfile.

### 5. Exécuter Docker Compose

Maintenant, vous pouvez exécuter tous les services (backend, frontend, PostgreSQL, Prometheus, Grafana) définis dans le fichier Docker Compose :

```bash
docker-compose up -d
```

Cette commande démarrera les services en mode détaché, y compris le backend avec PostgreSQL, le frontend React, Prometheus pour la collecte des métriques et Grafana pour la surveillance.




## Surveillance avec Spring Boot Actuator, Prometheus et Grafana

### 1. Spring Boot Actuator

Spring Boot Actuator est utilisé pour exposer des informations opérationnelles sur l'application en cours d'exécution. Des métriques telles que la santé du système, l'utilisation de la mémoire, et plus sont exposées à Prometheus. Il est activé dans le backend, et Prometheus collecte ces métriques pour les rendre disponibles pour la visualisation dans Grafana.

### 2. Accéder à Prometheus

Prometheus est utilisé pour collecter des métriques depuis le backend et les surveiller. Il sera disponible à l'adresse :

**URL de Prometheus** : [http://localhost:9091](http://localhost:9091)

Vous pouvez interroger diverses métriques telles que :

- `http_server_requests_seconds_count` : Comptes des requêtes HTTP.
- `jvm_memory_used_bytes` : Utilisation de la mémoire.
- `process_cpu_usage` : Utilisation du CPU.

### Vérifier l'état des cibles Prometheus

Pour consulter l'état de votre Prometheus, vous pouvez naviguer vers :

**Status → Targets**

Ici, vous verrez tous les points de terminaison surveillés. Si tout fonctionne correctement, le statut affichera `UP`, sinon, il affichera `DOWN`.

C'est un moyen facile de vérifier si vos services sont correctement collectés par Prometheus.

Voici un exemple d'image de mon projet montrant l'état des cibles Prometheus :

<img width="960" alt="image" src="https://github.com/user-attachments/assets/24e56abd-9ebf-471a-aa18-53de4d7538bf">


### 3. Accéder à Grafana

Grafana est disponible pour visualiser les métriques collectées par Prometheus. Pour accéder à Grafana, ouvrez :

**URL de Grafana** : [http://localhost:3001](http://localhost:3001)

### 4. Configurer des tableaux de bord dans Grafana

#### Connexion à Grafana

Les identifiants de connexion par défaut pour Grafana sont :

- **Nom d'utilisateur** : admin
- **Mot de passe** : admin (vous serez invité à le changer lors de la première connexion).

#### Ajouter Prometheus comme source de données

Naviguez vers **Configuration → Sources de données**.

Cliquez sur **Ajouter une source de données**, sélectionnez **Prometheus**, et définissez l'URL sur `http://prometheus:9090`.

#### Importer un tableau de bord

Naviguez vers **Créer → Importer**.

Vous pouvez utiliser un tableau de bord pré-construit depuis Grafana ou créer un tableau de bord personnalisé pour les métriques Spring Boot.

Pour un tableau de bord plus sophistiqué, vous pouvez télécharger un modèle JSON depuis **Actuator JSON Dashboard** et l'importer dans Grafana :

Naviguez vers **Créer → Importer**.

Téléchargez le fichier JSON et associez-le à votre source de données Prometheus.






