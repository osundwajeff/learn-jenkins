pipeline {
    agent { docker { image 'mcr.microsoft.com/playwright:v1.42.1-jammy' } }

    stages {
        stage('Test') {
            steps {
                echo 'Running tests...'
                sh 'cd src'
                script {
                        def errorOccurred = false
                        sh '''
                        for dir in $(find "$(pwd)" -type d -name '*_test'); do
                            if [ -f "$dir/package.json" ]; then
                                echo "Running tests in $dir"
                                cd $dir
                                npm install
                                npx playwright test || {
                                    echo "Test execution failed in $dir"
                                    errorOccurred = true
                                }
                                cd -
                            fi
                        done'''
                    if (errorOccurred) {
                        echo 'Test execution failed: Some tests encountered errors'
                    }
                }
            }
        }
    }
}
