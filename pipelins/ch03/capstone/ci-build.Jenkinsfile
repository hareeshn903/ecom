pipeline {
    agent any

    triggers {
        //githubPush()
        pollSCM('H/2 * * * *')
        cron('H 1 * * *')   // nightly build at ~1 AM mbb
    }

    stages {
        stage('Checkout') {
            steps {
                git url: 'https://github.com/hareeshn903/ecom.git',
                branch: 'main'
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
