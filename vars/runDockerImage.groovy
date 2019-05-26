def call(def vmPort, def containerPort, def imageName, def tag){
  def oldContainerTag = "${tag}-1"
  echo "${oldContainerTag}"
  sh "docker rm -f ${imageName}:${oldContainerTag}"
  sh " docker run -d -p ${vmPort}:${containerPort} ${imageName}:${tag}"
}

