def call(def vmPort, def containerPort, def imageName, def tag){
  sh " docker run -d -p ${vmPort}:${containerPort} ${imageName}:${tag}"
}
