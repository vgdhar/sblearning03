pipeline
{
    agent any
    stages
    {
        stage('SCM Checkout')
        {
            steps
            {
              git 'https://github.com/vgdhar/sblearning03'  
            }
        }
        stage('compile-package')
        {
            steps
            {
                sh '/opt/maven/bin/mvn package'
            }
        }
	    stage('Build-Docker-Image')
        {
            steps
            {
		    script
		    {
			  app= docker.build("vgang/sblearning03")
		
		    }
			    
            }
        }
	    stage('Push-Docker-Image')
        {
            steps
            {
		    script
		    {
			  withDockerRegistry(credentialsId: 'dockerhub_login', url: "") 
			    {
				    
   				 app.push("latest")
			    }
		
		    }
			    
            }
        }
	    stage('Deploy To Production')
	    {
		 withCredentials([usernamePassword(credentialsId: 'prod_server_login', passwordVariable: 'PASSWD', usernameVariable: 'USERNAME')])
			    {
				    script
				    {
					sh "sshpass -p '$PASSWD' -v ssh -o StrictHostKeyChecking=no $USERNAME@prod_ip \"docker pull vgang/sblearning03:latest\""
					 try
					 {
						 sh "sshpass -p '$PASSWD' -v ssh -o StrictHostKeyChecking=no $USERNAME@prod_ip \"docker stop sblearning03\" "
						 sh "sshpass =p '$PASSWD' -v ssh -o StrictHostKeyChecking=no $USERNAME@prod_ip \"docker rm sblearning03\""

					 }
					 catch(err)
					 {
						    echo: 'caught error: $err'
					 }
					 sh "sshpass -p '$PASSWD' -v ssh -o StrictHostKeyChecking=no $USERNAME@prod_ip \"docker run --restart always --name sblearning03 8080:8080 vgang/sblearning03:latest\" "
				    }
				    
			    }    
		    
	    }
        
	}
}
