package wildflyswarm.deltaspike.projectstages;

import org.apache.deltaspike.core.api.exclude.Exclude;
import org.apache.deltaspike.core.api.projectstage.ProjectStage;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
@Exclude(exceptIfProjectStage = ProjectStage.Production.class)
public class MessageServiceImpl implements MessageService {

  @Override
  public String get() {
    return "Hello";
  }

}
