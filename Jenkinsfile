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
                defaultValue: '148.0',
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

        string(
                name: 'REMOTE_URL',
                defaultValue: 'https://user1:1234@selenoid.qa.guru/wd/hub',
                description: 'Selenoid URL'
        )

        booleanParam(
                name: 'HEADLESS',
                defaultValue: false,
                description: 'Run browser in headless mode'
        )
    }

    stages {

        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Check Selenoid') {
            steps {
                sh """
                    echo "Checking Selenoid..."
                    curl -s ${params.REMOTE_URL}/status || true
                """
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
                        -DremoteUrl=${params.REMOTE_URL} \
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