	pipeline {
    agent any

    environment {
        DEPLOY_HOST = "3.227.235.33"
        DEPLOY_USER = "ubuntu"
        DEPLOY_PATH = "/home/ubuntu/deploy/react-spring"
        SSH_KEY = "/var/lib/jenkins/.ssh/devops.pem"
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'git 'https://github.com/naseeff-7/react-spring-ec2.git''
            }
        }

        stage('Copy files to Deployment Server') {
            steps {
                sh '''
                    ssh -i ${SSH_KEY} -o StrictHostKeyChecking=no ${DEPLOY_USER}@${DEPLOY_HOST} "mkdir -p ${DEPLOY_PATH}"
                    rsync -avz -e "ssh -i ${SSH_KEY} -o StrictHostKeyChecking=no" ./ ${DEPLOY_USER}@${DEPLOY_HOST}:${DEPLOY_PATH}/
                '''
            }
        }

        stage('Deploy on Deployment Server') {
            steps {
                sh '''
                    ssh -i ${SSH_KEY} -o StrictHostKeyChecking=no ${DEPLOY_USER}@${DEPLOY_HOST} "
                        cd ${DEPLOY_PATH} &&
                        sudo docker compose down || true &&
                        sudo docker compose up -d --build
                    "
                '''
            }
        }
    }
}
