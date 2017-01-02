package wildflyswarm.deltaspike.projectstages;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;

@ApplicationScoped
@Path("/")
public class MyController {

  @Inject
  private MessageService messageService;

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public String get() throws SQLException {
    return String.format("{\"message\": \"%s\"}", messageService.get());
  }

}
