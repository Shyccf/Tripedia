package tours.tripedia.tripedia.dao;

import org.springframework.data.repository.CrudRepository;
import tours.tripedia.tripedia.model.Image;

public interface ImageDao extends CrudRepository<Image, Long> {
}
