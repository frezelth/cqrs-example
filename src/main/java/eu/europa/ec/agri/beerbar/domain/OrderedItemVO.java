package eu.europa.ec.agri.beerbar.domain;

import java.math.BigDecimal;
import lombok.Builder;
import lombok.Value;

/**
 * @author <a href="thomas.frezel@ext.ec.europa.eu">Thomas Frezel</a>
 * @version $
 */
@Value
@Builder
public class OrderedItemVO {

  private Integer item;
  private String description;
  private boolean drink;
  private BigDecimal price;

}
