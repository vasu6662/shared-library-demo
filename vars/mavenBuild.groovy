def call (def artifactoryServer, def mvnHome,def pom, def goal){
  rtMavenDeployer (
      id: 'deployer-unique-id',
      serverId: "${artifactoryServer}",
      releaseRepo: "generic-local/${BUILD_NUMBER}",
      snapshotRepo: "generic-snapshot/${BUILD_NUMBER}"
  )

  rtMavenRun (
      tool: "${mvnHome}",
      pom: "${pom}",
      goals: "${goal}",
      opts: '-Xms1024m -Xmx4096m',
      deployerId: 'deployer-unique-id',
  )
}
