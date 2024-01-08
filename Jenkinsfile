pipeline {
  agent any
 environment {
    dockerhubCredentials = 'rh_cred'
    }

  stages {
   
         stage('login') 
        {
            steps {  
                  // Use Docker Hub credentials to log in
                    withCredentials([usernamePassword(credentialsId: dockerhubCredentials, passwordVariable: 'DOCKERHUB_PASSWORD', usernameVariable: 'DOCKERHUB_USERNAME')]) {
                        // Log in to Docker Hub
                          sh "docker login -u ${env.DOCKERHUB_USERNAME} -p ${env.DOCKERHUB_PASSWORD}"
                    }
                    
                echo 'login done'
            }
        }

   stage('frontend') {
      steps {
          sh 'docker build -t oumayma140/frontend -f GestionProduit/Dockerfile ./GestionProduit'
          echo 'build docker image frontend done'
          sh 'docker image push oumayma140/frontend'
          echo 'push frontend done'
      }
      }
     stage('backend') {
      steps {
          sh 'docker build -t oumayma140/backend -f GestionProduits/Dockerfile ./GestionProduits'
          echo 'build docker image backend done'
          sh 'docker image push oumayma140/backend'
          echo 'push backend done'
      }
    }  
    stage('cleanUp') 
        {
            steps{
                sh 'docker logout localhost:8080'
                sh 'docker image rmi oumayma140/frontend oumayma140/backend'
                echo 'clean done'
            }
        }

  
    }
  }
