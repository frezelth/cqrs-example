package eu.europa.ec.agri.beerbar.domain;

import java.util.Collection;
import java.util.UUID;

public class Tab {

    private UUID id;

    private Collection<OrderedItem> outstandingDrinks;
    private Collection<OrderedItem> outstandingFoods;
    private Collection<OrderedItem> preparedFood;

    private int tableNumber;

    private String waiter;


    public Tab(int tableNumber, String waiter){
        this.id = UUID.randomUUID();
        this.tableNumber = tableNumber;
        this.waiter = waiter;

    }

    public void placeOrder(){

    }

    public void serveDrink(){

    }

    public void prepareFood(){

    }

    public void serveFood(){

    }

}
