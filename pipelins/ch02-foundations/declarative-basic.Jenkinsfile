/*
 * Chapter 02 – Foundations
 * Declarative Pipeline example
 * Project: https://github.com/hareeshn903/ecom
 */

pipeline {

    /* ----------------------------------------
     * Agent
     * ---------------------------------------- */
    

    /* ----------------------------------------
     * Stages
     * ---------------------------------------- */
    stages {

        stage('Checkout Source') {
            steps {
                echo 'Checking out source code'
                git url: 'https://github.com/hareeshn903/ecom.git',
                    branch: 'main'
            }
        }

        stage('Environment Info') {
            steps {
                echo "Node Name    : ${env.NODE_NAME}"
                echo "Workspace    : ${env.WORKSPACE}"
                echo "Build Number : ${env.BUILD_NUMBER}"

                sh 'java -version'
                sh 'mvn -version'
            }
        }

        stage('Compile') {
            steps {
                echo 'Compiling the project'
                sh 'mvn clean compile'
            }
        }

        stage('Test') {
            steps {
                echo 'Running unit tests'
                sh 'mvn test || true'
            }
        }

        stage('Package') {
            steps {
                echo 'Packaging the application'
                sh 'mvn package'
            }
        }

        stage('Artifacts') {
            steps {
                echo 'Listing generated artifacts'
                sh 'ls -l target || true'
            }
        }
    }
}
