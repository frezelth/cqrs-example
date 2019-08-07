package eu.europa.ec.agri.beerbar.api.event;

import java.util.UUID;
import lombok.Builder;
import lombok.Value;
import org.axonframework.serialization.Revision;

/**
 * @author <a href="thomas.frezel@ext.ec.europa.eu">Thomas Frezel</a>
 * @version $
 */
@Builder
@Value
@Revision("0.1")
public class TabOpened {

  private UUID tabId;
  private String waiter;
  private int tableNumber;

}
