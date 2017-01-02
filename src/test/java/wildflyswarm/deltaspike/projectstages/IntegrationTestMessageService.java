package wildflyswarm.deltaspike.projectstages;

import org.apache.deltaspike.core.api.exclude.Exclude;
import org.apache.deltaspike.core.api.projectstage.ProjectStage;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
@Exclude(exceptIfProjectStage = ProjectStage.IntegrationTest.class)
public class IntegrationTestMessageService implements MessageService {

  @Override
  public String get() {
    return "IntegrationTest";
  }

}
