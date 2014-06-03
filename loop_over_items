for(item in Jenkins.instance.items) {
  if(item.name.contains('my-test'))
  {  
     AbstractProject project = item
     if(project.getScm() instanceof hudson.scm.SubversionSCM)
     	println(project.getScm().getLocations())
  }
}
