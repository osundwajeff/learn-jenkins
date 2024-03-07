pipeline {
    agent { docker { image 'mcr.microsoft.com/playwright:v1.42.1-jammy' } }

    stages {
        stage('Test') {
            steps {
                echo 'Running tests...'
                sh '''
                cd src
                for dir in $(find "$(pwd)" -type d -name '*_test'); do
	                if [ -f "$dir/package.json" ]; then
    	                echo "Running tests in $dir"
                        cd $dir
                        npm install
                        npm ci
                        npx playwright test
                    fi
                done
                '''
            }
        }
    }

}
