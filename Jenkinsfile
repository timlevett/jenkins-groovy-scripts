pipeline {
  agent  {
    label 'docker-builder'
  }
  environment {
    TAG='latest'
  }
  stages {
    stage('set tag to tag name if tag') {
      when {
        not {
          branch 'master'
        }
      }
      steps {
        script {
          env.TAG = sh"echo `git describe --all --exact-match 2>/dev/null | sed 's=.*/=='`"
        }
        echo "${env.TAG}"
      }
    }
  }
  post {
    always {
      echo "always"
    }
  }
  options {
    buildDiscarder(logRotator(numToKeepStr:'10'))
    timeout(time: 60, unit: 'MINUTES')
  }
}
