package eu.europa.ec.agri.beerbar.command;

import java.util.List;
import java.util.UUID;
import javax.validation.constraints.NotNull;
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
public class MarkFoodPrepared {

  @TargetAggregateIdentifier
  private UUID tabId;

  @NotNull
  private @Singular List<Integer> items;

}
