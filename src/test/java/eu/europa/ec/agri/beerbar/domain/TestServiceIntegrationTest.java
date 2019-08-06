package eu.europa.ec.agri.beerbar.domain;

import eu.europa.ec.agri.beerbar.command.OpenTab;
import eu.europa.ec.agri.beerbar.command.PlaceOrder;
import eu.europa.ec.agri.beerbar.eventhandler.TabReadModel;
import eu.europa.ec.agri.beerbar.infrastructure.TabRepository;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;

@SpringBootTest
@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles({"integrationtests"})
public class TestServiceIntegrationTest {

    @Autowired
    private CommandGateway commandGateway;

    @Autowired
    private TabRepository repository;

    @Autowired
    private ElasticsearchRestTemplate elasticsearchTemplate;

    @Before
    public void setUp() throws Exception {
        elasticsearchTemplate.deleteIndex(TabReadModel.class);
        elasticsearchTemplate.createIndex(TabReadModel.class);
        elasticsearchTemplate.putMapping(TabReadModel.class);
        elasticsearchTemplate.refresh(TabReadModel.class);
    }

    @Test
    public void testFullScenario() {

        OpenTab tab = OpenTab.builder()
                .tableNumber(1)
                .waiter("Bruce Willis")
                .build();

        UUID id = commandGateway.sendAndWait(tab);

        Optional<TabReadModel> byId = repository.findById(id.toString());
        if (!byId.isPresent()) {
            Assert.fail("Item not found");
        }

        Assert.assertEquals(id.toString(), byId.get().getTabId());
        Assert.assertEquals((Integer) 1, byId.get().getTableNumber());
        Assert.assertEquals("Bruce Willis", byId.get().getWaiter());
        Assert.assertEquals(true, byId.get().getOpened());

        PlaceOrder orderCommand = PlaceOrder.builder()
                .tabId(id)
                .item(OrderedItemVO.builder()
                        .item(1)
                        .drink(true)
                        .description("Big beer")
                        .price(new BigDecimal("5"))
                        .build())
                .item(OrderedItemVO.builder()
                        .item(10)
                        .drink(false)
                        .description("Big burger")
                        .price(new BigDecimal("20"))
                        .build())
                .build();

        commandGateway.sendAndWait(orderCommand);

        byId = repository.findById(id.toString());
        if (!byId.isPresent()) {
            Assert.fail("Item not found");
        }

        Assert.assertEquals(id.toString(), byId.get().getTabId());
        Assert.assertEquals(2, byId.get().getOutstanding().size());



    }
}
