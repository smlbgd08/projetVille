pipeline {
    agent any

    stages {
        stage('get source code') {
            steps {
                git credentialsId: 'git', url: 'https://github.com/smlbgd08/projetVille.git'
            }
        }
        
          stage('package') {
            steps {
                bat 'mvn package'
            }
        }
    }
    
      
}
