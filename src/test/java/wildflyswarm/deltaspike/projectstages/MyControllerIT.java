package wildflyswarm.deltaspike.projectstages;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(Arquillian.class)
//@DefaultDeployment(testable = false, type = WAR)
public class MyControllerIT {

  @Deployment(testable = false)
  public static Archive createDeployment() throws Exception {
    return ShrinkWrap.create(WebArchive.class)
      .addPackage("wildflyswarm.deltaspike.projectstages")
      .addAsLibraries(Maven.resolver()
        .loadPomFromFile("pom.xml")
        .importRuntimeDependencies()
        .resolve()
        .withTransitivity()
        .asFile()
      );
  }

  @ArquillianResource
  private URI deploymentUri;

  @Test
  public void test() {
    Client client = ClientBuilder.newClient();
    WebTarget target = client.target(deploymentUri);

    Response response = target.request(MediaType.APPLICATION_JSON).get();

    assertThat(response.readEntity(String.class)).contains("IntegrationTest");

    client.close();
  }

}