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
	    
        
	}
}
