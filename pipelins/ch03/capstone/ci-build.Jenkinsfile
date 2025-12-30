pipeline {
    agent any

    triggers {
        githubPush()
        cron('H 1 * * *')   // nightly build at ~1 AM
    }

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/hareeshn903/ecom.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean compile'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test || true'
            }
        }

        stage('Approval Gate') {
            steps {
                input message: 'Approve packaging stage?', ok: 'Approve'
            }
        }

        stage('Trigger Packaging Job') {
            steps {
                build job: 'ecom-package-job', wait: false
            }
        }
    }
}
