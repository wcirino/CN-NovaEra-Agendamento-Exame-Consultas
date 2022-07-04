pipeline{
    agent   any
    stages  {
        stage('Início'){
            steps{
                bat 'echo inicio'
            }
        }
        stage('Meio'){
            steps{
                sleep(5)
                bat 'echo meio'
                bat 'echo meio novamente'
            }
        }
        stage('Fim'){
            steps{
                sleep(5)
                bat 'echo meio'
                bat 'echo meio novamente'
                bat 'echo final'
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