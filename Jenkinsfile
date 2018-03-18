pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        sh './gradlew'
      }
    }
    stage('Test') {
      steps {
      	sh './gradlew build -x test'
        junit(testResults: 'build/test-results/test/*.xml', healthScaleFactor: 1)
      }
    }
	stage('Notify') {
      steps {
      	sh './gradlew test'
        junit(testResults: 'build/test-results/test/*.xml', healthScaleFactor: 1)
      }
    }
  }
}