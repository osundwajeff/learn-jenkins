    pipeline {
    agent { docker { image 'mcr.microsoft.com/playwright:v1.42.1-jammy' } }

    stages {
        stage('Test') {
            steps {
                try {
                    echo 'Running tests...'
                    sh 'cd src'
                    sh '''
                    for dir in $(find "$(pwd)" -type d -name '*_test'); do
                        if [ -f "$dir/package.json" ]; then
                            echo "Running tests in $dir"
                            cd $dir
                            npm install
                            npx playwright test
                        fi
                    done'''
                }
                catch (Exception e){
                    echo "Test execution failed: ${e.message}"
                }
            }
        }
    }
}
