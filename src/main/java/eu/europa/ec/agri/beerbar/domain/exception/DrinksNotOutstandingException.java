package eu.europa.ec.agri.beerbar.domain.exception;

/**
 * @author <a href="thomas.frezel@ext.ec.europa.eu">Thomas Frezel</a>
 * @version $
 */
public class DrinksNotOutstandingException extends RuntimeException {

  public DrinksNotOutstandingException() {
    super("Drinks are not outstanding");
  }
}
