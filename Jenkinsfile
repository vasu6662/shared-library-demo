@Library('shared-library') _
node(label: 'master'){
    //Variables
    def gitURL = "https://github.com/anoop600/MVC.git"
    def repoBranch = "master"
    def ApplicationName = "mvc"
    def sonarqubeServer = "sonar"
    def sonarqubeGoal = "clean verify sonar:sonar"
    def mvnHome = "MAVEN_HOME"
    def pom = "pom.xml"
    def goal = "clean install"
    def artifactoryServer = "Artifactory"
    def releaseRepo = "generic-local"
    def snapshotRepo = "generic-snapshot"
    def dockerRegistry = "https://registry.hub.docker.com"
    def dockerImageRemove = "registry.hub.docker.com"
    def dockerRegistryUserName = "anoop600"
    def dockerCredentialID = "dockerID" 
    def dockerImageName = "${dockerRegistryUserName}/${ApplicationName}"
    def vmPort = 9999
    def containerPort = 8080
    
    //Git Stage
    stage('Git-Checkout'){
        gitClone "${gitURL}","${repoBranch}"    
    }
    
    //Sonarqube Analysis
    stage('Sonarqube-scan'){
        sonarqubeScan "${mvnHome}","${sonarqubeGoal}","${pom}", "${sonarqubeServer}"
    }
    
    //Quality-gate
    stage('Quality-Gate'){
        qualityGate "${sonarqubeServer}"
    }
    
    //MVN Build
    stage('Maven Build and Push to Artifactory'){
        mavenBuild "${artifactoryServer}","${mvnHome}","${pom}", "${goal}", "${releaseRepo}", "${snapshotRepo}"
    }
    
    //docker-image-build
    stage('Build Docker image'){
        dockerBuildAndPush "${dockerRegistry}","${dockerCredentialID}","${dockerImageName}"
    }
    
    //Remove extra image
    stage('Remove image'){
        removeDockerImage "${dockerImageRemove}","${dockerImageName}"
    }
    
    //Delete Old running Container and run new built
    stage('Run Docker Image'){
        runDockerImage "${vmPort}","${containerPort}", "${dockerImageName}", "${BUILD_NUMBER}"
    }
    
}
