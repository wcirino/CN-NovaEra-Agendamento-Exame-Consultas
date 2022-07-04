pipeline{
    agent   any
    stages  {
        stage('Build backend'){
            steps{
                bat 'mvn clean package -DskipTests=true'
            }
        }
        stage('Junit Test'){
           steps{
                bat 'mvn test'
            }
        }
       stage('Sonar analysis'){
		   environment{
                scannerHome = tool 'SONAR_SCANNER'
            }
		   steps{
				withsonarQubeEnv('SONAR_LOCAL'){
					bat "${scannerHome}/bin/sonar-scanner -e -Dsonar.projectKey=DeployBack -Dsonar.host.url=http://localhost:9000 -Dsonar.login=9df79ae97ca7935d37e1e4dae863dbd80915aa6a -Dsonar.sources=src/main/java,src/main/resources -Dsonar.tests=src/test/java  -Dsonar.exclusions=**/**/Main.java,src/main/resources/**.properties,src/main/java/com/clinica/config/**.java,src/main/java/com/clinica/dto/**.java,src/main/java/com/clinica/entity/**.java,src/main/java/com/clinica/repository/**.java -Dsonar.java.binaries=target/classes -Dsonar.coverage.exclusions= -Dsonar.dynamicAnalysis=reuseReports -Dsonar.java.coveragePlugin=jacoco -Dsonar.java.test.binaries=target/test-classes"  
				}
			}
        }
		 stage('Concluido'){
            steps{
                sleep(5)
                bat 'echo arquivo concluido'
            }
        }
    }
}