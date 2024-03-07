pipeline {
    agent { docker { image 'mcr.microsoft.com/playwright:v1.42.1-jammy' } }

    stages {
        stage('Test') {
            steps {
                echo 'Running tests...'
                sh 'cd src'
                sh 'set +e'
                sh '''
                for dir in $(find "$(pwd)" -type d -name '*_test'); do
                    if [ -f "$dir/package.json" ]; then
                        echo "Running tests in $dir"
                        cd $dir
                        npm install
                        npx playwright test
                    fi
                    if [ $? -eq 0 ]; then
                        echo "Tests in $dir passed"
                    else
                        echo "Tests in $dir failed"
                    fi
                done'''
            }
        }
    }
}
