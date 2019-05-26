def call(def vmPort, def containerPort, def imageName, def tag,def lastSuccessfullBuild){
  sh " docker rm -f ${imageName}_${lastSuccessfullBuild}"
  sh " docker run -d -p --name ${imageName}_${tag} ${vmPort}:${containerPort} ${imageName}:${tag}"
}

