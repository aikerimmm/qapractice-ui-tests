pipeline {
    agent any

    parameters {
        choice(
                name: 'BROWSER',
                choices: ['chrome'],
                description: 'Browser'
        )

        string(
                name: 'BROWSER_VERSION',
                defaultValue: '',
                description: 'Browser version'
        )

        string(
                name: 'BROWSER_SIZE',
                defaultValue: '1920x1080',
                description: 'Browser size'
        )

        string(
                name: 'BASE_URL',
                defaultValue: 'https://www.qapractice.com',
                description: 'Base URL'
        )

        booleanParam(
                name: 'HEADLESS',
                defaultValue: true,
                description: 'Run browser in headless mode'
        )
    }

    stages {

        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Check Browser') {
            steps {
                sh '''
                    echo "Checking installed browsers..."

                    which google-chrome || true
                    which google-chrome-stable || true
                    which chromium || true
                    which chromium-browser || true

                    google-chrome --version || true
                    google-chrome-stable --version || true
                    chromium --version || true
                    chromium-browser --version || true
                '''
            }
        }

        stage('Run Tests') {
            steps {
                sh 'chmod +x gradlew'

                sh """
                    ./gradlew clean test \
                        -Dbrowser=${params.BROWSER} \
                        -DbrowserVersion=${params.BROWSER_VERSION} \
                        -DbrowserSize=${params.BROWSER_SIZE} \
                        -DbaseUrl=${params.BASE_URL} \
                        -Dheadless=${params.HEADLESS}
                """
            }
        }
    }

    post {
        always {
            allure([
                    includeProperties: false,
                    jdk: '',
                    results: [[path: 'build/allure-results']]
            ])
        }
    }
}