/*
 * Chapter 02 – Foundations
 * Scripted Pipeline example
 * Project: https://github.com/hareeshn903/ecom
 */

node {

    /* ----------------------------------------
     * Stage 1: Workspace & Checkout
     * ---------------------------------------- */
    stage('Checkout Source') {
        echo "Checking out source code..."
        git url: 'https://github.com/hareeshn903/ecom.git'
    }

    /* ----------------------------------------
     * Stage 2: Environment Info
     * ---------------------------------------- */
    stage('Environment Info') {
        echo "Node Name       : ${env.NODE_NAME}"
        echo "Workspace       : ${env.WORKSPACE}"
        echo "Build Number    : ${env.BUILD_NUMBER}"

        sh 'java -version'
        sh 'mvn -version'
    }

    /* ----------------------------------------
     * Stage 3: Compile (Maven)
     * ---------------------------------------- */
    stage('Compile') {
        echo "Compiling the project using Maven"
        sh 'mvn clean compile'
    }

    /* ----------------------------------------
     * Stage 4: Unit Tests
     * ---------------------------------------- */
    stage('Test') {
        echo "Running unit tests"
        sh 'mvn test || true'
    }

    /* ----------------------------------------
     * Stage 5: Package
     * ---------------------------------------- */
    stage('Package') {
        echo "Packaging the application"
        sh 'mvn package'
    }

    /* ----------------------------------------
     * Stage 6: List Artifacts
     * ---------------------------------------- */
    stage('Artifacts') {
        echo "Listing generated artifacts"
        sh 'ls -l target || true'
    }
}
