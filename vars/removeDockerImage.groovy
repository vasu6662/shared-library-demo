def call(def dockerImageRemove ,def dockerImageName){
  sh "docker rmi -f ${dockerImageRemove}/${dockerImageName}:${BUILD_NUMBER}"
 // sh "docker rmi -f ${}/${}:${BUILD_NUMBER}"
}


def call(def dockerImageName){
  sh "docker rmi -f ${dockerImageName}:${BUILD_NUMBER}"
}
