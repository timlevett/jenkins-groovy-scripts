//TODO: Something is off with doing this. When you click on the new link it throws an error

import jenkins.model.*

def str_search = "my-predev4"
def str_replace = "my-predev"

for(item in Jenkins.instance.items) {
  if(item.name.contains(str_search))
  {  
     item.name = item.name.replaceAll(str_search, str_replace);
     println("job $item.name")
     item.save();
  }
}
