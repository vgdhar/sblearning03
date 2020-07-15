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
			   docker.build("vgang/sblearning03")
		    }
			    
            }
        }
	    
        
	}
}
