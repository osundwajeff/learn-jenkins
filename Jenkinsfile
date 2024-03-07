pipeline {
    agent { docker { image 'mcr.microsoft.com/playwright:v1.42.1-jammy' } }

    stages {
        stage('Test') {
            steps {
                echo 'Running tests...'
                sh 'cd src'
                def rootDirectory = '.'

                def testDirectories = findFiles(glob: "${rootDirectory}/*_test").collect { it.directory }

                for (dir in testDirectories) {
                    echo "Running tests in ${dir}"
                    sh 'cd ${dir}'
                    sh 'npm install'
                    sh 'npm ci'
                    sh 'npx playwright test'
            }
        }
    }

}
