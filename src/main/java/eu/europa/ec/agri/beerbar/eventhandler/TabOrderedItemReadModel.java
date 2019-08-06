package eu.europa.ec.agri.beerbar.eventhandler;

import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * @author <a href="thomas.frezel@ext.ec.europa.eu">Thomas Frezel</a>
 * @version $
 */
public class TabOrderedItemReadModel {

  @Field(type = FieldType.Integer)
  private Integer item;

  @Field(type = FieldType.Keyword)
  private String description;

  @Field(type = FieldType.Boolean)
  private boolean drink;

  @Field(type = FieldType.Keyword)
  private String price;

}
