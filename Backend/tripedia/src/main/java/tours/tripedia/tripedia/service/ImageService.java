package tours.tripedia.tripedia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tours.tripedia.tripedia.dao.ImageDao;
import tours.tripedia.tripedia.dao.PostDao;
import tours.tripedia.tripedia.dao.SpotDao;
import tours.tripedia.tripedia.dao.UserDao;
import tours.tripedia.tripedia.model.Image;
import tours.tripedia.tripedia.model.Post;
import tours.tripedia.tripedia.model.Spot;
import tours.tripedia.tripedia.model.User;

import java.util.List;
import java.util.Optional;

@Service
public class ImageService {
    private ImageDao imageDao;
    private PostDao postDao;
    private SpotDao spotDao;
    private UserDao userDao;

    @Autowired
    public ImageService(ImageDao imageDao, PostDao postDao, SpotDao spotDao, UserDao userDao) {
        this.imageDao = imageDao;
        this.postDao = postDao;
        this.spotDao = spotDao;
        this.userDao = userDao;
    }

    public Image addImage(Image image) {
        if (image.getImageUrl().isEmpty() || image.getImageUrl() == null) {
            throw new RuntimeException("Image url can not be empty.");
        }

        return imageDao.save(image);
    }

    public List<Image> getAllImage() {
        return (List<Image>) imageDao.findAll();
    }

    public Optional<Image> getImageById(Long imageId) {
        return imageDao.findById(imageId);
    }

    public void deleteImage(Image image) {
        imageDao.delete(image);
    }

    public void deleteImageById(Long id) {
        imageDao.deleteById(id);
    }

    public Image updateImage(Image image) {
        if (image.getImageId() == null || !imageDao.existsById(image.getImageId())) {
            throw new RuntimeException("Image Id can not be found");
        }

        return imageDao.save(image);
    }

    public Image assignSpot(Long imageId, Long spotId) {
        if (!imageDao.existsById(imageId)) {
            throw new RuntimeException("Can not find image Id: " + imageId);
        }

        if(!spotDao.existsById(spotId)) {
            throw new RuntimeException("Can not find spot Id: " + spotId);
        }

        Image image = getImageById(imageId).get();
        Spot spot = spotDao.findById(spotId).get();

        image.setSpot(spot);
        return imageDao.save(image);
    }

    public Image assignPost(Long imageId, Long postId) {
        if (!imageDao.existsById(imageId)) {
            throw new RuntimeException("Can not find image Id: " + imageId);
        }

        if(!postDao.existsById(postId)) {
            throw new RuntimeException("Can not find post Id: " + postId);
        }

        Image image = getImageById(imageId).get();
        Post post = postDao.findById(postId).get();

        image.setPost(post);
        return imageDao.save(image);
    }

    public Image assignUser(Long imageId, Long userId) {
        if (!imageDao.existsById(imageId)) {
            throw new RuntimeException("Can not find image Id: " + imageId);
        }

        if(!userDao.existsById(userId)) {
            throw new RuntimeException("Can not find user Id: " + userId);
        }

        Image image = getImageById(imageId).get();
        User user = userDao.findById(userId).get();

        image.setUser(user);
        return imageDao.save(image);
    }
}
