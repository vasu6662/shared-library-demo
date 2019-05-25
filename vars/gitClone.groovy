def call(def url, def branch){
checkout([$class: ‘GitSCM’, branches: [[name: "$branch"]], userRemoteConfigs: [[url: "${url}"]]])

}
