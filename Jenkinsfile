pipeline {
    agent { docker { image 'mcr.microsoft.com/playwright:v1.42.1-jammy' } }

    stages {
        stage('Test') {
            steps {
                echo 'Tests...'
                sh 'cd src/kartoza_test'

                echo 'Install depencies'
                sh 'npm install'
                sh 'npm ci'
                
                echo 'Running Tests ...'
                sh 'npx playwright test'
            }
        }
    }
}
