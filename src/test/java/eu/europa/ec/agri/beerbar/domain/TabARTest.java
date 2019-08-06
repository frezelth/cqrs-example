package eu.europa.ec.agri.beerbar.domain;

import eu.europa.ec.agri.beerbar.command.CloseTab;
import eu.europa.ec.agri.beerbar.command.OpenTab;
import eu.europa.ec.agri.beerbar.command.PlaceOrder;
import eu.europa.ec.agri.beerbar.domain.exception.BillNotPaidException;
import eu.europa.ec.agri.beerbar.event.DrinksOrdered;
import eu.europa.ec.agri.beerbar.event.DrinksServed;
import eu.europa.ec.agri.beerbar.event.FoodOrdered;
import eu.europa.ec.agri.beerbar.event.TabClosed;
import eu.europa.ec.agri.beerbar.event.TabOpened;
import java.math.BigDecimal;
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
  public void testPlaceFoodOrder() {
    UUID id = UUID.randomUUID();

    PlaceOrder command = PlaceOrder.builder()
        .tabId(id)
        .item(OrderedItemVO.builder()
            .item(1)
            .description("My big burger")
            .drink(false)
            .price(new BigDecimal("18"))
            .build())
        .build();

    TabOpened opened = TabOpened.builder()
        .tabId(id)
        .waiter("Bruce Willis")
        .tableNumber(1)
        .build();

    FoodOrdered event = FoodOrdered.builder()
        .tabId(id)
        .item(OrderedItemVO.builder()
            .item(1)
            .description("My big burger")
            .price(new BigDecimal("18"))
            .drink(false)
            .build())
        .build();

    fixture.given(opened)
        .when(command)
        .expectSuccessfulHandlerExecution()
        .expectEvents(event);
  }

  @Test
  public void testPlaceDrinkOrder() {
    UUID id = UUID.randomUUID();

    PlaceOrder command = PlaceOrder.builder()
        .tabId(id)
        .item(OrderedItemVO.builder()
            .item(10)
            .description("My big beer")
            .drink(true)
            .price(new BigDecimal("4"))
            .build())
        .build();

    TabOpened opened = TabOpened.builder()
        .tabId(id)
        .waiter("Bruce Willis")
        .tableNumber(1)
        .build();

    DrinksOrdered event = DrinksOrdered.builder()
        .tabId(id)
        .item(OrderedItemVO.builder()
            .item(10)
            .description("My big beer")
            .price(new BigDecimal("4"))
            .drink(true)
            .build())
        .build();

    fixture.given(opened)
        .when(command)
        .expectSuccessfulHandlerExecution()
        .expectEvents(event);
  }

  @Test
  public void testPlace2Orders() {
    UUID id = UUID.randomUUID();

    PlaceOrder command = PlaceOrder.builder()
        .tabId(id)
        .item(OrderedItemVO.builder()
            .item(10)
            .description("My big beer")
            .drink(true)
            .price(new BigDecimal("4"))
            .build())
        .item(OrderedItemVO.builder()
            .item(1)
            .description("My big burger")
            .drink(false)
            .price(new BigDecimal("18"))
            .build())
        .build();

    TabOpened opened = TabOpened.builder()
        .tabId(id)
        .waiter("Bruce Willis")
        .tableNumber(1)
        .build();

    DrinksOrdered event = DrinksOrdered.builder()
        .tabId(id)
        .item(OrderedItemVO.builder()
            .item(10)
            .description("My big beer")
            .price(new BigDecimal("4"))
            .drink(true)
            .build())
        .build();

    FoodOrdered event2 = FoodOrdered.builder()
        .tabId(id)
        .item(OrderedItemVO.builder()
            .item(1)
            .description("My big burger")
            .price(new BigDecimal("18"))
            .drink(false)
            .build())
        .build();

    fixture.given(opened)
        .when(command)
        .expectSuccessfulHandlerExecution()
        .expectEvents(event, event2);
  }

  @Test
  public void testCloseTab() {
    UUID id = UUID.randomUUID();

    CloseTab command = CloseTab.builder()
        .tabId(id)
        .amountPaid(new BigDecimal("4"))
        .build();

    TabOpened open = TabOpened.builder()
        .tabId(id)
        .tableNumber(1)
        .waiter("Bruce Willis")
        .build();

    DrinksOrdered event = DrinksOrdered.builder()
        .tabId(id)
        .item(OrderedItemVO.builder()
            .item(10)
            .description("My big beer")
            .price(new BigDecimal("4"))
            .drink(true)
            .build())
        .build();

    DrinksServed event2 = DrinksServed.builder()
        .tabId(id)
        .item(10)
        .build();

    fixture.given(open, event, event2)
        .when(command)
        .expectSuccessfulHandlerExecution()
        .expectEvents(TabClosed.builder()
            .tabId(id)
            .orderPrice(new BigDecimal("4"))
            .amountPaid(new BigDecimal("4"))
            .tipValue(new BigDecimal("0"))
            .build());
  }

  @Test
  public void testCloseTabWith2EuroTips() {
    UUID id = UUID.randomUUID();

    CloseTab command = CloseTab.builder()
        .tabId(id)
        .amountPaid(new BigDecimal("6"))
        .build();

    TabOpened open = TabOpened.builder()
        .tabId(id)
        .tableNumber(1)
        .waiter("Bruce Willis")
        .build();

    DrinksOrdered event = DrinksOrdered.builder()
        .tabId(id)
        .item(OrderedItemVO.builder()
            .item(10)
            .description("My big beer")
            .price(new BigDecimal("4"))
            .drink(true)
            .build())
        .build();

    DrinksServed event2 = DrinksServed.builder()
        .tabId(id)
        .item(10)
        .build();

    fixture.given(open, event, event2)
        .when(command)
        .expectSuccessfulHandlerExecution()
        .expectEvents(TabClosed.builder()
            .tabId(id)
            .orderPrice(new BigDecimal("4"))
            .amountPaid(new BigDecimal("6"))
            .tipValue(new BigDecimal("2"))
            .build());
  }

  @Test
  public void testCloseTabWithoutPaying() {
    UUID id = UUID.randomUUID();

    CloseTab command = CloseTab.builder()
        .tabId(id)
        .amountPaid(new BigDecimal("2"))
        .build();

    TabOpened open = TabOpened.builder()
        .tabId(id)
        .tableNumber(1)
        .waiter("Bruce Willis")
        .build();

    DrinksOrdered event = DrinksOrdered.builder()
        .tabId(id)
        .item(OrderedItemVO.builder()
            .item(10)
            .description("My big beer")
            .price(new BigDecimal("4"))
            .drink(true)
            .build())
        .build();

    DrinksServed event2 = DrinksServed.builder()
        .tabId(id)
        .item(10)
        .build();

    fixture.given(open, event, event2)
        .when(command)
        .expectException(BillNotPaidException.class);
  }
}
