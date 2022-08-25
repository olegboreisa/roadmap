pipeline {
    agent any

    stages {
        stage('List Tasks') {
            steps {
                sh './gradlew tasks'
            }
        }
        stage('Clean') {
            steps {
                sh './gradlew clean'
            }
        }
        stage('Test') {
            steps {
                sh './gradlew test'
            }
        }
        stage('Build') {
            steps {
                sh './gradlew build'
            }
        }
        stage('Run SonarQube') {
            steps {
                sh './gradlew sonarqube'
            }
        }
    }
}