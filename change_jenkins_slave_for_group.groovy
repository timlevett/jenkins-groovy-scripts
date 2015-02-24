String wildcard = 'my-predev';
String newNodeLabel = "calypsotest";

for(item in Jenkins.instance.items) {
  if(item.name.contains(wildcard))
  {  
     AbstractProject project = item
     
     println("before: " + project.getAssignedLabel())
     println(project.getDisplayName())
     project.setAssignedLabel(new Label())
     println("after: " + project.getAssignedLabel())
     
  }
}
