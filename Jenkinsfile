pipeline {
    agent { docker { image 'mcr.microsoft.com/playwright:v1.42.1-jammy' } }

    stages {
        stage('Test') {
            steps {
                echo 'Running Tests ...'
                sh '''cd src/production-tests
                npm install
                npm ci
                npx playwright test'''
            }
        }
    }
}
