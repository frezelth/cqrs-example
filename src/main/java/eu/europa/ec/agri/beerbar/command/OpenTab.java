package eu.europa.ec.agri.beerbar.command;

import java.util.UUID;
import lombok.Builder;
import lombok.Value;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

/**
 * @author <a href="thomas.frezel@ext.ec.europa.eu">Thomas Frezel</a>
 * @version $
 */
@Value
@Builder
public class OpenTab {

  @TargetAggregateIdentifier
  private UUID tabId = UUID.randomUUID();

  private int tableNumber;
  private String waiter;

}
