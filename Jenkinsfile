pipeline {
    parameters {
        choice(name: 'navigator', choices: ['chrome', 'edge', 'firefox'], description: 'Select the navigator that you want to run tests.')
    }
    agent any
    tools {
        jdk 'jdk16'
        maven 'mvn3-6-3'
        gradle 'gradle6-5-1'
    }
    options {
        timeout(time: 1, unit: 'HOURS')
    }
    stages {
        stage('Create Selenium Grid Server') {
            steps {
                sh 'docker network create grid'
                sh 'docker run -d -p 4442-4444:4442-4444 --net grid --name selenium-hub selenium/hub:latest'
            }
        }
        stage('Clone Repository') {
            steps {
                checkout([$class: 'GitSCM', branches: [[name: '*/main']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[url: 'https://github.com/edwincneira/web-driver-grid.git']]])
            }
        }
        stage('Run Test') {
            steps {
                script {
                  def navigator = params.navigator
                  if (navigator.contain('chrome')) {
                    sh 'docker run -d --net grid -e SE_EVENT_BUS_HOST=selenium-hub --shm-size="2g" -e SE_EVENT_BUS_PUBLISH_PORT=4442 -e SE_EVENT_BUS_SUBSCRIBE_PORT=4443 selenium/node-chrome:latest'
                    sh 'mvn clean verify -Denvironment=chrome -Dcucumber.filter.tags=@chrome'
                  } else if (navigator.contains('edge')) {
                    sh 'docker run -d --net grid -e SE_EVENT_BUS_HOST=selenium-hub --shm-size="2g" -e SE_EVENT_BUS_PUBLISH_PORT=4442 -e SE_EVENT_BUS_SUBSCRIBE_PORT=4443 selenium/node-edge:latest'
                    sh 'mvn verify -Denvironment=edge -Dcucumber.filter.tags=@edge'
                  } else if (navigator.contains('firefox')) {
                    sh 'docker run -d --net grid -e SE_EVENT_BUS_HOST=selenium-hub --shm-size="2g" -e SE_EVENT_BUS_PUBLISH_PORT=4442 -e SE_EVENT_BUS_SUBSCRIBE_PORT=4443 selenium/node-firefox:latest'
                    sh 'mvn clean verify -Denvironment=firefox -Dcucumber.filter.tags=@fireFox'
                  }
                }
            }
        }
    }
    post {
        always {
            sh 'echo Delete selenium grid server'
            sh 'docker stop $(docker ps -aq)'
            sh 'docker rm $(docker ps -aq)'
            sh 'docker network rm grid'
            publishHTML(target: [
                allowMissing: false,
                alwaysLinkToLastBuild: false,
                keepAll: true,
                reportDir: 'target/site/serenity',
                reportFiles: 'index.html',
                reportName: 'SerenityReportFireFox'
            ])
        }
    }
}
