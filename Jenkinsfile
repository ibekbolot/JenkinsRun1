pipeline {
    agent any

    stages {

        stage('Checkout') {
            steps {
                git branch: 'main',
                url: 'https://github.com/ibekbolot/JenkinsRun1.git'
            }
        }

        stage('Build') {
            steps {
                bat 'gradlew clean build'
            }
        }

        stage('Test') {
            steps {
                bat 'gradlew test'
            }
        }
    }

    post {
        always {
            junit 'build/test-results/test/*.xml'

            allure([
                includeProperties: false,
                jdk: '',
                results: [[path: 'build/allure-results']]
            ])
        }
    }

}