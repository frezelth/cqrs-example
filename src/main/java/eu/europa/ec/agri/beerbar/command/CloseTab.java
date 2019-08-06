package eu.europa.ec.agri.beerbar.command;

import java.math.BigDecimal;
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
public class CloseTab {

  @TargetAggregateIdentifier
  private UUID tabId;
  
  private BigDecimal amountPaid;

}
