package tours.tripedia.tripedia.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.Date;
import java.util.Optional;

@Entity
@Table(name = "comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long commentId;

    private String commentText;

    @Column(nullable = false)
    private Date commentDate;

    @ManyToOne
    @JsonIgnoreProperties(value = {"spot", "images", "comments", "user"})
    @JoinColumn(name = "post_id")
    private Post post;

    @ManyToOne
    @JsonIgnoreProperties(value = {"comments", "posts", "images"})
    @JoinColumn(name = "user_id")
    private User user;

    public Comment() {

    }

    public Comment(Long commentId, String commentText, Date commentDate, Post post, User user) {
        this.commentId = commentId;
        commentText = commentText;
        commentDate = commentDate;
        this.post = post;
        this.user = user;
    }

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        commentText = commentText;
    }

    public Date getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(Date commentDate) {
        commentDate = commentDate;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("Comment{" +
                "commentId=" + commentId +
                ", CommentText='" + commentText + '\'' +
                ", CommentDate=" + commentDate);

        if (post == null) {
            str.append(Optional.ofNullable(null));
        }
        else {
            str.append(post);
        }

        if (user == null) {
            str.append(Optional.ofNullable(null));
        }
        else {
            str.append(user);
        }

        str.append('}');

        return str.toString();
    }
}
