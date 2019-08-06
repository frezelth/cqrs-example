package eu.europa.ec.agri.beerbar.domain.exception;

/**
 * @author <a href="thomas.frezel@ext.ec.europa.eu">Thomas Frezel</a>
 * @version $
 */
public class TabHasUnservedItemsException extends RuntimeException {

  public TabHasUnservedItemsException() {
    super("Tab has unserved items");
  }
}
