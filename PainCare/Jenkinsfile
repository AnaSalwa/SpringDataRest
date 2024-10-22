pipeline {
    agent any 

    stages {
        stage('Clone Repository') {
            steps {
                git 'https://github.com/AnaSalwa/PainCare.git'
            }
        }
        stage('Build Docker Image') {
            steps {
                script {
                    // Construction de l'image Docker
                    docker.build('anasalwa/paincare_image_builder:v1.2')
                }
            }
        }
        stage('Push to Docker Hub') {
            steps {
                script {
                    // Connexion à Docker Hub avec les identifiants
                    docker.withRegistry('https://index.docker.io/v1/', 'dockerhubCredentialsId') {
                        // Pousser l'image vers Docker Hub
                        sh 'docker push anasalwa/paincare_image_builder:v1.2'
                    }
                }
            }
        }
        stage('Deployement') {
            steps {
                script {
                    // Arrêter et supprimer l'ancien conteneur
                    sh 'docker stop adoring_nobel || true'
                    sh 'docker rm adoring_nobel || true'

                    // Démarrer un nouveau conteneur avec l'image mise à jour
                    sh 'docker run -d --name adoring_nobel -p 8080:8080 anasalwa/paincare_image_builder:v1.2'
                }
            }
        }
    }
}
