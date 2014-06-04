//Starting point: https://wiki.jenkins-ci.org/display/JENKINS/Clone+all+projects+in+a+View

import hudson.model.*

def str_view = "my-predev4"
def str_search = "my-predev4"
def str_replace = "my-predev"
def list_migrated = [];
def bool_dryRun = false;

def view = Hudson.instance.getView(str_view)
 
//copy all projects of a view
for(item in view.getItems())
{

  def already_migrated = false;
  for(migrated in list_migrated) {
   if(migrated.equals(item.getName())) {
     already_migrated = true;
     println("Ran into duplicate entry, skipping " + migrated);
     break;
   }
  }
  if(already_migrated) {
    continue;
  }
  //create the new project name
  newName = item.getName().replace(str_search, str_replace)

  if(!bool_dryRun) {
    // copy the job, disable and save it
    def job = Hudson.instance.copy(item, newName)
    job.disabled = true
    job.save()
    
    // update the workspace to avoid having two projects point to the same location
    AbstractProject project = job
    if(project.getCustomWorkspace() != null ) {
      def new_workspace = project.getCustomWorkspace().replace(str_search, str_replace)
      project.setCustomWorkspace(new_workspace)
    }
    
    //change the assigned label
    if(project.getAssignedLabel() != null) {
     def new_label = project.getAssignedLabelString().replace(str_search, str_replace);
     project.setAssignedLabel((Label)(new hudson.model.labels.LabelAtom(new_label)));
    }
    
    project.save()
  }
  
  println(" $item.name copied as $newName")
  migrated.add(item.getName());

}
