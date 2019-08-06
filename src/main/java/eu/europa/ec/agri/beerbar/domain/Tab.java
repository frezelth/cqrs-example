package eu.europa.ec.agri.beerbar.domain;

import eu.europa.ec.agri.beerbar.command.MarkDrinkServed;
import eu.europa.ec.agri.beerbar.domain.exception.TabNotOpenException;
import java.util.Collection;
import java.util.UUID;

public class Tab {

    private UUID id;

    private Collection<OrderedItem> outstandingDrinks;
    private Collection<OrderedItem> outstandingFoods;
    private Collection<OrderedItem> preparedFood;

    private int tableNumber;

    private String waiter;

    private boolean open;


    public Tab(int tableNumber, String waiter){
        this.id = UUID.randomUUID();
        this.tableNumber = tableNumber;
        this.waiter = waiter;

    }

    public boolean isTabOpen(){
        return open;
    }

    public void placeOrder(OrderedItem item){
        if (!isTabOpen()){
            throw new TabNotOpenException();
        }
    }

    public void markDrinkServed(MarkDrinkServed command){

    }

    public void prepareFood(OrderedItem item){

    }

    public void serveFood(OrderedItem item){

    }

}
