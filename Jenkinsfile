pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Run tests') {
            steps {
                sh './gradlew clean test'
            }
        }
    }

    post {
        always {
            allure([
                    results: [[path: 'build/allure-results']]
            ])
        }
    }
}