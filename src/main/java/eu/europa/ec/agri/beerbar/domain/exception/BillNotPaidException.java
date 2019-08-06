package eu.europa.ec.agri.beerbar.domain.exception;

/**
 * @author <a href="thomas.frezel@ext.ec.europa.eu">Thomas Frezel</a>
 * @version $
 */
public class BillNotPaidException extends RuntimeException {

  public BillNotPaidException() {
    super("Bill is not paid!");
  }
}
