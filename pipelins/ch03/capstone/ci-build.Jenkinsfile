pipeline {
    agent any
    options {
        quietPeriod(5)
    }
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
                script {
                    timeout(time: 10, unit: 'MINUTES') {
                    def envChoice = input(
                        id: 'envChoice', message: 'Approve to proceed to Packaging?',
                        parameters: [
                            choice(name: 'ENV', choices: ['PROD', 'QA', 'DEV'], description: 'Select environment to deploy'),
                            booleanParam(name: 'HOTFIX', defaultValue: false),
                            string(name: 'VERSION', defaultValue: '1.0.0')
                        ]
                    )
                    echo "Selected environment: ${envChoice}"
                    echo "Version: ${envChoice['VERSION']}"
                    echo "Hotfix: ${envChoice['HOTFIX']}"
                }
                //input message: 'Approve packaging stage?', ok: 'Approve'

            }
        }
        }

        stage('Trigger Packaging Job') {
            steps {
                build job: 'ecom-package-job', wait: false
            }
        }
    }
}
