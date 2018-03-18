pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        sh './gradlew build'
      }
    }
    stage('Test') {
      steps {
        junit(testResults: 'build/test-results/test/*.xml', healthScaleFactor: 1)
      }
    }
  }
}