package eu.europa.ec.agri.beerbar.command;

import java.util.List;
import java.util.UUID;
import javax.validation.constraints.NotNull;
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
public class MarkFoodServed {

  @TargetAggregateIdentifier
  private UUID tabId;

  @NotNull
  private @Singular List<Integer> items;

}
