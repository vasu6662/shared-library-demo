def call(def vmPort, def containerPort, def imageName, def tag,def lastSuccessfullBuild){
  sh " docker rm -f ${imageName}-${lastSuccessfullBuild}"
  sh " docker run -d -p --name ${imageName}-${tag} ${vmPort}:${containerPort} ${imageName}:${tag}"
}

