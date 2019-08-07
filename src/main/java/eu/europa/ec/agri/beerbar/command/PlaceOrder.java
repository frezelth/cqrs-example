package eu.europa.ec.agri.beerbar.command;

import eu.europa.ec.agri.beerbar.domain.OrderedItemVO;
import java.util.Collection;
import java.util.UUID;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

/**
 * @author <a href="thomas.frezel@ext.ec.europa.eu">Thomas Frezel</a>
 * @version $
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PlaceOrder {

  @TargetAggregateIdentifier
  private UUID tabId;

  private @Singular Collection<OrderedItemVO> items;

}
