pipeline {
    agent any

    stages {
        stage('Clonar Repositório') {
            steps {
                echo 'Clonando o repositório...'
            }
        }

        stage('Build do Projeto') {
            steps {
                echo 'Realizando o build do projeto...'
            }
        }

        stage('Testes JUnit') {
            steps {
                echo 'Executando os testes JUnit...'
            }
        }

        stage('Análise Estática de Código') {
            steps {
                echo 'Realizando análise estática de código...'
            }
        }

        stage('Implantação') {
            steps {
                echo 'Realizando a implantação...'
            }
        }
    }

    post {
        always {
            echo 'Ações a serem executadas sempre, independentemente do resultado da construção.'
        }
        success {
            echo 'Ações a serem executadas apenas se a construção for bem-sucedida.'
        }
        failure {
            echo 'Ações a serem executadas apenas se a construção falhar.'
        }
    }
}
