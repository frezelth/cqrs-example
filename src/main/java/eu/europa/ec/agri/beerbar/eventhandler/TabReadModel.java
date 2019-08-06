package eu.europa.ec.agri.beerbar.eventhandler;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * @author <a href="thomas.frezel@ext.ec.europa.eu">Thomas Frezel</a>
 * @version $
 */
@Data
@Document(indexName = "cc-academy-pub", type="_doc")
public class TabReadModel {

  @Id
  @Field(type = FieldType.Keyword)
  private String id;

  @Field(type = FieldType.Keyword)
  private String waiter;

  @Field(type = FieldType.Keyword)
  private String amountPaid;

  @Field(type = FieldType.Keyword)
  private String tipValue;

  @Field(type = FieldType.Keyword)
  private String orderPrice;

}
