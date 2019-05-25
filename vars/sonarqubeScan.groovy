def call(def mvnHome, def sonarqubeServer){
  withSonarQubeEnv("${sonarqubeServer}") {
  sh "'${mvnHome}/bin/mvn' clean package sonar:sonar"
  }
}
