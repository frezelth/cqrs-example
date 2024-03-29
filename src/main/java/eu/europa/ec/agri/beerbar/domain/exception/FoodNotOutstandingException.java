package eu.europa.ec.agri.beerbar.domain.exception;

/**
 * @author <a href="thomas.frezel@ext.ec.europa.eu">Thomas Frezel</a>
 * @version $
 */
public class FoodNotOutstandingException extends RuntimeException {

  public FoodNotOutstandingException() {
    super("Food is not outstanding");
  }
}
