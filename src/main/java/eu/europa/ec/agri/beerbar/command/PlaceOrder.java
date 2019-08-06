package eu.europa.ec.agri.beerbar.command;

import eu.europa.ec.agri.beerbar.domain.OrderedItemVO;
import java.util.Collection;
import java.util.UUID;
import lombok.Builder;
import lombok.Singular;
import lombok.Value;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

/**
 * @author <a href="thomas.frezel@ext.ec.europa.eu">Thomas Frezel</a>
 * @version $
 */
@Builder
@Value
public class PlaceOrder {

  @TargetAggregateIdentifier
  private UUID tabId;

  @Singular
  private Collection<OrderedItemVO> items;

}
