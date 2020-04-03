pipeline{
    agent any
    options {
        disableConcurrentBuilds()
        timeout(time: 1, unit: "HOURS")
    }
    environment {
        MVN_SETTING_PROVIDER = "3ec57b41-efe6-4628-a6c7-8be5f1c26d77"
    }
    stages {
        stage('Checkout') {
            steps {
                checkout(
                  [$class: 'GitSCM',
                  branches: [[name: '**']],
                  doGenerateSubmoduleConfigurations: false,
                  extensions: [
                    [$class: 'SubmoduleOption',
                    disableSubmodules: false,
                    parentCredentials: true,
                    recursiveSubmodules: true,
                    reference: '',
                    trackingSubmodules: false],
                    [$class: 'CleanCheckout'],
                    [$class: 'CleanBeforeCheckout']],
                  submoduleCfg: [],
                  userRemoteConfigs: [[credentialsId:'a61b2227-5075-400c-8e17-77350f89db0b',
                  url:'git@github.com:pns-isa-devops/projet-isa-devops-20-team-b-20-client.git']]
                ])
            }
        }
        stage("Compile") {
            steps {
                configFileProvider([configFile(fileId: MVN_SETTING_PROVIDER, variable: "MAVEN_SETTINGS")]) {
					dir('./projet-isa-devops-20-team-b-20-client-office') {
						echo "Compile module"
						sh "mvn -s $MAVEN_SETTINGS clean compile"
					}
                }
            }
        }
    }
    post{
        success {
            echo "======== pipeline executed successfully ========"
        }
        failure {
            echo "======== pipeline execution failed========"
        }
    }
}
