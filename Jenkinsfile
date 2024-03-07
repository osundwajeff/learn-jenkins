pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Building the project...'
            }
        }

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
                        npx playwright install chromium
                        npx playwright test
                    fi
                done
                '''
            }
        }
    }

}
