def call(def vmPort, def containerPort, def applicationName ,def imageName, def tag, def lastSuccessfullBuild){
  sh " docker rm -f ${applicationName}-${lastSuccessfullBuild}"
  sh " docker run -d -p --name=${applicationName}-${tag} ${vmPort}:${containerPort} ${imageName}:${tag}"
}

