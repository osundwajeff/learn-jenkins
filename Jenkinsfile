pipeline {
    agent { docker { image 'mcr.microsoft.com/playwright:v1.42.1-jammy' } }

    stages {
        stage('Git Clone') {
                //when {
                  //  expression { action == 'closed' && isMerged == 'true' && targetBranch == 'main' }
                //}
                steps('Clone Repository') {
                    git branch: 'main',
                    //credentialsId: "$gitcredentials",
                    url: 'git@github.com:kartoza/GeoHosting.git'
                }
        }
        stage('Test') {
            steps {
                echo 'Running Tests ...'
                sh '''cd playwright/production-tests
                npm install
                npm ci
                npx playwright test'''
            }
        }
    }
}
