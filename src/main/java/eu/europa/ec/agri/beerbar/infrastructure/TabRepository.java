package eu.europa.ec.agri.beerbar.infrastructure;

import eu.europa.ec.agri.beerbar.eventhandler.TabReadModel;
import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;

public interface TabRepository extends ElasticsearchCrudRepository<TabReadModel, String> {
}
