package eu.europa.ec.agri.beerbar.command;

import java.util.List;
import java.util.UUID;
import lombok.Builder;
import lombok.Singular;
import lombok.Value;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

/**
 * @author <a href="thomas.frezel@ext.ec.europa.eu">Thomas Frezel</a>
 * @version $
 */
@Value
@Builder
public class MarkFoodServed {

  @TargetAggregateIdentifier
  private UUID tabId;

  @Singular
  private List<Integer> items;

}
