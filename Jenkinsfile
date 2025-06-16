pipeline {
    
	agent any
    tools {
	    maven "maven3"
	    jdk "java17"
	}
	
    stages{
        
        stage('fetch code') {
            steps {
                git branch: 'main', url: 'https://github.com/flawlez18/sonarqube-jenkins.git'
            }
        }

        stage('build-app'){
            steps {
                sh 'mvn clean install -DskipTests'
            }
        }

        stage('app-compile'){
            steps {
                sh 'mvn clean compile -DskipTests'
            }
        }

        stage('code analysis with sonarqube') {
          
		  environment {
             scannerHome = tool 'sonar-jenkins-project'
          }
          steps {
            withSonarQubeEnv('sonar-server') {
               sh '''${scannerHome}/bin/sonar-scanner \
                   -Dsonar.projectKey=sonar-jenkins-project \
                   -Dsonar.projectName=sonar-jenkins-project \
                   -Dsonar.projectVersion=1.0 \
                   -Dsonar.sources=src/main/java \
                   -Dsonar.java.binaries=target/classes \
                   -Dsonar.organization=sonar-jenkins-project'''
            }
          }
        }
    }
}
