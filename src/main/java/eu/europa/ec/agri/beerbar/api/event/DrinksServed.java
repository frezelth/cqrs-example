package eu.europa.ec.agri.beerbar.api.event;

import java.util.List;
import java.util.UUID;
import lombok.Builder;
import lombok.Singular;
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

  @Singular
  private List<Integer> items;

}
