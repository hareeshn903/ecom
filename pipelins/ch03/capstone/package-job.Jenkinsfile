pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git url: 'https://github.com/hareeshn903/ecom.git',
                branch: 'main'
            }
        }

        stage('Package') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Artifacts') {
            steps {
                sh 'ls -l target'
            }
        }
    }
}
