String wildcard = 'my-predev4';

for(item in Jenkins.instance.items) {
  if(item.name.contains(wildcard))
  {  
     AbstractProject project = item
     println("disabling " + item.name)
     println("--was disabled = " + item.isDisabled())
     project.makeDisabled(true)
     println("---is disabled = " + item.isDisabled())
     
  }
}

