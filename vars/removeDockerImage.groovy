def call(def dockerImageRemove ,def dockerImageName){
  sh "docker rmi -f ${dockerImageRemove}/${dockerImageName}:${BUILD_NUMBER}"
}
