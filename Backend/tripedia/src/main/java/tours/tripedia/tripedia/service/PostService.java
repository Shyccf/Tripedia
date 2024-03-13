package tours.tripedia.tripedia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tours.tripedia.tripedia.dao.PostDao;
import tours.tripedia.tripedia.dao.SpotDao;
import tours.tripedia.tripedia.dao.UserDao;
import tours.tripedia.tripedia.model.Post;
import tours.tripedia.tripedia.model.Spot;
import tours.tripedia.tripedia.model.User;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    private PostDao postDao;
    private SpotDao spotDao;
    private UserDao userDao;

    @Autowired
    public PostService(PostDao postDao, SpotDao spotDao, UserDao userDao) {
        this.postDao = postDao;
        this.spotDao = spotDao;
        this.userDao = userDao;
    }

    public Post addPost(Post post) {
        if (post.getTitle().isEmpty() || post.getTitle() == null) {
            throw new RuntimeException("Post title can not be empty!");
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat(("yyyy-MM-dd HH:mm:ss"));
        // 格式化时间对象
        post.setPostTime(dateFormat.format(new Date()));

        return postDao.save(post);
    }

    public List<Post> getAllPost() {
        return (List<Post>) postDao.findAll();
    }

    public Optional<Post> getPostById(Long id) {
        return postDao.findById(id);
    }

    public void deletePostById(Long id) {
        postDao.deleteById(id);
    }

    public Post updatePost(Post post) {
        if (post.getTitle().isEmpty() || post.getTitle() == null) {
            throw new RuntimeException("Post title can not be empty!");
        }

        return postDao.save(post);
    }

    /*
    public Post assignSpot(Long postId, Long spotId) {
        if (!postDao.existsById(postId)) {
            throw new RuntimeException("Cannot find post ID" + postId);
        }

        if (!spotDao.existsById(spotId)) {
            throw new RuntimeException("Cannot find spot ID" + spotId);
        }

        Post post = getPostById(postId).get();
        Spot spot = spotDao.findById(spotId).get();

        post.setSpot(spot);
        spot.addPopularity();

        return postDao.save(post);
    }

    public Post assignUser(Long postId, Long userId) {
        if (!postDao.existsById(postId)) {
            throw new RuntimeException("Cannot find post ID" + postId);
        }

        if(!userDao.existsById(userId)) {
            throw new RuntimeException("Cannot find user ID" + userId);
        }

        Post post = getPostById(postId).get();
        User user = userDao.findById(userId).get();

        post.setUser(user);
        return postDao.save(post);
    }
     */

    public Post assignContent(Long postId, String content) {
        if (!postDao.existsById(postId)) {
            throw new RuntimeException(("Cannot find post ID" + postId));
        }

        Post post = getPostById(postId).get();
        post.setContent(content);

        return postDao.save(post);
    }

}
