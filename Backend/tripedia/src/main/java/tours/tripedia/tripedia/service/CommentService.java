package tours.tripedia.tripedia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.tokens.CommentToken;
import tours.tripedia.tripedia.dao.CommentDao;
import tours.tripedia.tripedia.dao.PostDao;
import tours.tripedia.tripedia.dao.UserDao;
import tours.tripedia.tripedia.model.Comment;
import tours.tripedia.tripedia.model.Post;
import tours.tripedia.tripedia.model.User;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {
    private CommentDao commentDao;
    private PostDao postDao;
    private UserDao userDao;

    @Autowired
    public CommentService(CommentDao commentDao, PostDao postDao, UserDao userDao) {
        this.commentDao = commentDao;
        this.postDao = postDao;
        this.userDao = userDao;
    }

    public Comment addComment(Comment comment) {
        if (comment.getCommentText().isEmpty() || comment.getCommentText() == null) {
            throw new RuntimeException("Comment text can not be empty");
        }

        return commentDao.save(comment);
    }

    public List<Comment> getAllComment() {
        return (List<Comment>) commentDao.findAll();
    }

    public Optional<Comment> getCommentById(Long commentId) {
        return commentDao.findById(commentId);
    }

    public void deleteComment(Comment comment) {
        commentDao.delete(comment);
    }

    public void deleteCommentById(Long id) {
        commentDao.deleteById(id);
    }

    public Comment updateComment(Comment comment) {
        if (comment.getCommentText().isEmpty() || comment.getCommentText() == null) {
            throw new RuntimeException("Comment text can not be empty");
        }

        if (!commentDao.existsById(comment.getCommentId())) {
            throw new RuntimeException("Comment does not exist!");
        }

        return commentDao.save(comment);
    }

    public Comment assignPost(Long commentId, Long postId) {
        if (!commentDao.existsById(commentId)) {
            throw new RuntimeException("Can not find commentId: " + commentId);
        }

        if (!postDao.existsById(postId)) {
            throw new RuntimeException("Can not find postId: " + postId);
        }

        Comment comment = getCommentById(commentId).get();
        Post post = postDao.findById(postId).get();
        comment.setPost(post);

        return commentDao.save(comment);
    }

    public Comment assignUser(Long commentId, Long userId) {
        if (!commentDao.existsById(commentId)) {
            throw new RuntimeException("Can not find commentId: " + commentId);
        }

        if(!userDao.existsById(userId)) {
            throw new RuntimeException("Can not find userId" + userId);
        }

        Comment comment = getCommentById(commentId).get();
        User user = userDao.findById(userId).get();

        comment.setUser(user);
        return commentDao.save(comment);
    }
}
