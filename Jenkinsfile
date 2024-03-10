pipeline {
    agent { docker { image 'mcr.microsoft.com/playwright:v1.42.1-jammy' } }

    stages {
        stage('Test') {
            steps {
                echo 'Running tests...'
                sh 'cd src'
                script {
                        sh '''
                                echo "Running tests.."
                                cd kartoza_test
                                npm install
                                npx playwright test
                            fi
                        done'''
                }
            }
        }
    }
}
