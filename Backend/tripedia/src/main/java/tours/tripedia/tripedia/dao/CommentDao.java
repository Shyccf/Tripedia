package tours.tripedia.tripedia.dao;

import org.springframework.data.repository.CrudRepository;
import tours.tripedia.tripedia.model.Comment;

public interface CommentDao extends CrudRepository<Comment, Long> {
}
