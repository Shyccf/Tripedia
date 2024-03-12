package tours.tripedia.tripedia.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "user")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;

    private String signTime;

    private String introduction;

    private String city;

    @Column(nullable = false, name = "username")
    private String userName;

    private String password;

    private String email;

    private String avatarId;

    private Long rating;

    private String profileBgId;

    /*
    posts, comments, images
     */

    public User() {
    }

    public User(String userName){
        this.userName = userName;
    }

    public User(String introduction, String city, String userName, String password, String email, String avatarId, Long rating, String profileBgId) {
        this.introduction = introduction;
        this.city = city;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.avatarId = avatarId;
        this.rating = rating;
        this.profileBgId = profileBgId;
        /*
        this.posts = posts;
        this.comments = comments;
        this.images = images;
         */
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getSignTime() {
        return signTime;
    }

    public void setSignTime(String signTime) {
        this.signTime = signTime;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatarId() {
        return avatarId;
    }

    public void setAvatarId(String avatarId) {
        this.avatarId = avatarId;
    }

    public Long getRating() {
        return rating;
    }

    public void setRating(Long rating) {
        this.rating = rating;
    }

    public String getProfileBgId() {
        return profileBgId;
    }

    public void setProfileBgId(String profileBgId) {
        this.profileBgId = profileBgId;
    }

    /*
    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }
     */

    @Override
    public String toString() {

        StringBuilder str = new StringBuilder("User{" +
                "userId=" + userId +
                ", signTime=" + signTime +
                ", introduction='" + introduction + '\'' +
                ", city='" + city + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", avatarId='" + avatarId + '\'' +
                ", rating=" + rating +
                ", profileBgId='" + profileBgId + '\'');

        /*
        if (posts == null) {
            str.append(null);
        }
        else {
            for (Post post : posts) {
                str.append(post.getPostId());
            }
        }

        if (comments == null) {
            str.append(null);
        }
        else {
            for (Comment comment : comments) {
                str.append(comment.getCommentId());
            }
        }

        if (images == null) {
            str.append(null);
        }
        else {
            for (Image image : images) {
                str.append(image.getImageId());
            }
        }

         */
        str.append('}');

        return str.toString();
    }
}
