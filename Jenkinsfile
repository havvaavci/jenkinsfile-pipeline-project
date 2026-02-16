pipeline {
  agent any

  stages {
    stage('Checkout') {
      steps {
        checkout scm
      }
    }

    stage('Build') {
      steps {
        sh 'mvn -B clean compile'
      }
    }

    stage('Test') {
      steps {
        sh 'mvn -B test'
      }
    }
  }

  post {
    always {
      junit 'target/surefire-reports/*.xml'
      archiveArtifacts artifacts: 'target/surefire-reports/**', fingerprint: true
    }
  }
}

