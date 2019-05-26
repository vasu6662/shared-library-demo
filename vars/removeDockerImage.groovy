def call(def dockerImageRemove ,def dockerImageName/*, def userName, def applicationName*/){
  sh "docker rmi -f ${dockerImageRemove}/${dockerImageName}:${BUILD_NUMBER}"
 // sh "docker rmi -f ${userName}/${applicationName}:${BUILD_NUMBER}"
}

