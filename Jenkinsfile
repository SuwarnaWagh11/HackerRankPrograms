pipeline {
    agent any

    environment {
        PATH = "C:/Maven/apache-maven-3.9.1/bin/mvn:$PATH"
        ALLURE_RESULTS = "target/allure-results"
    }

    stages {
        stage('git clone') {
            steps {
                git url: 'https://github.com/SuwarnaWagh11/HackerRankPrograms.git', branch: 'main'
            }
        }

        stage('Build & Run Tests') {
            steps {
                sh 'mvn clean test'
            }
        }

        stage('Generate Allure Report') {
            steps {
                allure includeProperties: false, jdk: '', results: [[path: "${ALLURE_RESULTS}"]]
            }
        }
    }

    post {
        always {
            archiveArtifacts artifacts: 'target/allure-results/**', fingerprint: true
        }
    }
}
