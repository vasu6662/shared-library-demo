def call(def vmPort, def containerPort, def userName, def imageName, def tag){
  sh " docker run -d -p ${vmPort}:${containerPort} ${userName}/${imageName}:${tag}"
}
