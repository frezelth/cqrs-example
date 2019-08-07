package eu.europa.ec.agri.beerbar.infrastructure;

import eu.europa.ec.agri.beerbar.eventhandler.TabReadModel;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface TabRepository extends ElasticsearchRepository<TabReadModel, String> {
}
