package eu.europa.ec.agri.beerbar.event;

import java.util.List;
import java.util.UUID;
import lombok.Builder;
import lombok.Value;
import org.axonframework.serialization.Revision;

/**
 * @author <a href="thomas.frezel@ext.ec.europa.eu">Thomas Frezel</a>
 * @version $
 */
@Value
@Builder
@Revision("0.1")
public class DrinksServed {

  private UUID tabId;

  private List<Integer> items;

}
