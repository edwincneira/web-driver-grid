pipeline {
    agent any
    tools {
        jdk 'jdk16'
        maven 'mvn3-6-3'
        gradle 'gradle6-5-1'
    }
    stages {
        stage('Create Selenium Grid') {
            steps {
                sh 'docker network create grid'
                sh 'docker run -d -p 4442-4444:4442-4444 --net grid --name selenium-hub selenium/hub:latest'
                sh 'docker run -d --net grid -e SE_EVENT_BUS_HOST=selenium-hub --shm-size="2g" -e SE_EVENT_BUS_PUBLISH_PORT=4442 -e SE_EVENT_BUS_SUBSCRIBE_PORT=4443 selenium/node-chrome:latest'
                sh 'docker run -d --net grid -e SE_EVENT_BUS_HOST=selenium-hub --shm-size="2g" -e SE_EVENT_BUS_PUBLISH_PORT=4442 -e SE_EVENT_BUS_SUBSCRIBE_PORT=4443 selenium/node-edge:latest'
                sh 'docker run -d --net grid -e SE_EVENT_BUS_HOST=selenium-hub --shm-size="2g" -e SE_EVENT_BUS_PUBLISH_PORT=4442 -e SE_EVENT_BUS_SUBSCRIBE_PORT=4443 selenium/node-firefox:latest'
            }
        }
        stage('clone-repo') {
            steps {
                checkout([$class: 'GitSCM', branches: [[name: '*/main']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[url: 'https://github.com/edwincneira/web-driver-grid.git']]])
            }
        }
        stage('Run Maven Test') {
            steps {
                sh 'mvn test -Dtest=SeleniumGridTest'
            }
        }
        stage('Delete docker') {
            steps {
                sh 'docker network rm grid'
            }
        }
    }
}
