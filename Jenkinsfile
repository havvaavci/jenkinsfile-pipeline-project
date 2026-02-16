pipeline {
  agent any

  tools {
    maven 'Maven3'
  }

  parameters {
    choice(name: 'TEST_SUITE', choices: ['SMOKE', 'REGRESSION', 'ALL'], description: 'Hangi test seti kosulsun?')
  }

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

    stage('Smoke Tests') {
      when {
        anyOf {
          expression { params.TEST_SUITE == 'SMOKE' }
          expression { params.TEST_SUITE == 'ALL' }
        }
      }
      steps {
        // Şimdilik aynı testleri koşuyoruz.
        // İleride smoke tag / group ekleyip sadece smoke çalıştıracağız.
        sh 'mvn -B test'
      }
    }

    stage('Regression Tests') {
      when {
        anyOf {
          expression { params.TEST_SUITE == 'REGRESSION' }
          expression { params.TEST_SUITE == 'ALL' }
        }
      }
      steps {
        // Şimdilik aynı testleri koşuyoruz.
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



