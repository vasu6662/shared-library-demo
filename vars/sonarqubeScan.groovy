def call(def mvnHome, def sonarqubeServer){
  withSonarQubeEnv("${sonarqubeServer}") {
  sh "'${mvnHome}/bin/mvn' sonar:sonar"
  }
}
