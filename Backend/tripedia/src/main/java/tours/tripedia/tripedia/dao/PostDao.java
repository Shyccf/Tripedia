package tours.tripedia.tripedia.dao;

import org.springframework.data.repository.CrudRepository;
import tours.tripedia.tripedia.model.Post;

public interface PostDao extends CrudRepository<Post, Long> {
}
