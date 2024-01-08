pipeline {
  agent any
 environment {
    DOCKERHUB_CREDENTIALS = credentials('dh_cred')
    }

  stages {
   
         stage('login') 
        {
            steps {  
                sh 'echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin '
                echo 'login done'
            }
        }

   stage('frontend') {
      steps {
          sh 'docker build -t oumaymaboukadida/frontend -f GestionProduit/Dockerfile ./GestionProduit'
          echo 'build docker image frontend done'
          sh 'docker image push oumaymaboukadida/frontend'
          echo 'push frontend done'
      }
      }
     stage('backend') {
      steps {
          sh 'docker build -t oumaymaboukadida/backend -f GestionProduits/Dockerfile ./GestionProduits'
          echo 'build docker image backend done'
          sh 'docker image push oumaymaboukadida/backend'
          echo 'push backend done'
      }
    }  
    stage('cleanUp') 
        {
            steps{
                sh 'docker logout localhost:8080'
                sh 'docker image rmi oumaymaboukadida/frontend oumaymaboukadida/backend'
                echo 'clean done'
            }
        }

  
    }
  }
