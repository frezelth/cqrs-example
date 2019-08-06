package eu.europa.ec.agri.beerbar.event;

import java.math.BigDecimal;
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
public class TabClosed {

  private UUID tabId;
  private BigDecimal amountPaid;
  private BigDecimal orderPrice;
  private BigDecimal tipValue;

}
