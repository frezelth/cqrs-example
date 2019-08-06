package eu.europa.ec.agri.beerbar.domain;

import eu.europa.ec.agri.beerbar.command.OpenTab;
import eu.europa.ec.agri.beerbar.event.TabOpened;
import java.util.UUID;
import org.axonframework.test.aggregate.AggregateTestFixture;
import org.axonframework.test.aggregate.FixtureConfiguration;
import org.junit.Before;
import org.junit.Test;

/**
 * @author <a href="thomas.frezel@ext.ec.europa.eu">Thomas Frezel</a>
 * @version $
 */
public class TabARTest {

  private FixtureConfiguration<TabAR> fixture;

  @Before
  public void setUp() throws Exception {
    fixture = new AggregateTestFixture<>(TabAR.class);
  }

  @Test
  public void testOpenTab() {
    OpenTab command = OpenTab.builder()
        .tableNumber(1)
        .waiter("Bruce Willis")
        .build();

    UUID id = command.getTabId();

    fixture.givenNoPriorActivity()
        .when(command)
        .expectSuccessfulHandlerExecution()
        .expectEvents(TabOpened.builder()
            .tabId(id)
            .tableNumber(1)
            .waiter("Bruce Willis")
            .build());
  }

  @Test
  public void testCloseTab() {

  }
}
