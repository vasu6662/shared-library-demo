def call(def artifactoryServer, def releaseRepo, def snapshotRepo){
   rtMavenDeployer (
        id: 'deployer-unique-id',
        serverId: "${artifactoryServer}",
        releaseRepo: "${releaseRepo}/${BUILD_NUMBER}",
        snapshotRepo: "${snapshotRepo}/${BUILD_NUMBER}"
    )
}
