pipeline {
    agent { docker { image 'mcr.microsoft.com/playwright:v1.42.1-jammy' } }

    stages {
        stage('Test') {
            steps {
                echo 'Running tests...'
                sh 'cd src'
                script {
                    def rootDirectory = '.'
                    def testDirectories = sh(script: "find ${rootDirectory} -type d -name '*_test'", returnStatus: true, returnStdout: true)

                    for (dir in testDirectories) {
                        echo "Running tests in ${dir}"
                        sh "cd ${dir}"
                        sh 'npm install'
                        sh 'npm ci'
                        sh 'npx playwright test'
                    }
                }
            }
        }
    }
}
