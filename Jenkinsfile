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
    }
}