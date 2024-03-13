package tours.tripedia.tripedia.dao;

import org.springframework.data.repository.CrudRepository;
import tours.tripedia.tripedia.model.Spot;

public interface SpotDao extends CrudRepository<Spot, Long> {
}
