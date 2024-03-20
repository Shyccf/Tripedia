package tours.tripedia.tripedia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tours.tripedia.tripedia.model.Image;
import tours.tripedia.tripedia.service.ImageService;

import java.util.List;
import java.util.Optional;

import static tours.tripedia.tripedia.Component.GlobalVariables.crossOriginUrl;

@RestController
@RequestMapping("api/image")
@CrossOrigin(origins = crossOriginUrl)
public class ImageController {
    private ImageService imageService;

    @Autowired
    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @GetMapping
    public List<Image> getAllImage() {
        return imageService.getAllImage();
    }

    @GetMapping("{id}")
    public Optional<Image> getImageById(@PathVariable("id") Long imageId) {
        return imageService.getImageById(imageId);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addImage(@RequestBody Image image) {
        try {
            Image savedImage = imageService.addImage(image);
            return ResponseEntity.ok("Added Image: " + savedImage.toString());
        }
        catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @DeleteMapping(path = "/delete")
    public void delImage(@RequestBody Image image) {
        imageService.deleteImage(image);
    }

    @DeleteMapping("/delete/{id}")
    public void delImageById(@PathVariable("id") Long id) {
        imageService.deleteImageById(id);
    }

    @RequestMapping("/update")
    @PostMapping
    public ResponseEntity<String> updateImage(@RequestBody Image image) {
        try {
            Image savedImage = imageService.updateImage(image);
            return ResponseEntity.ok("Updated Image: " + savedImage.toString());
        }
        catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping(path = "assignspot/{iid}/{sid}")
    public ResponseEntity<String> assignSpot(@PathVariable("iid") Long imageId,
                                             @PathVariable("sid") Long spotId) {
        try {
            Image updatedImage = imageService.assignSpot(imageId, spotId);
            return ResponseEntity.ok("Assigned spot to image: " + updatedImage.toString());
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping(path = "assignpost/{iid}/{pid}")
    public ResponseEntity<String> assignPost(@PathVariable("iid") Long imageId,
                                             @PathVariable("pid") Long postId) {
        try {
            Image updatedImage = imageService.assignPost(imageId, postId);
            return ResponseEntity.ok("Assigned post to image: " + updatedImage.toString());
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping(path = "assignuser/{iid}/{uid}")
    public ResponseEntity<String> assignUser(@PathVariable("iid") Long imageId,
                                             @PathVariable("uid") Long userId) {
        try {
            Image updatedImage = imageService.assignUser(imageId, userId);
            return ResponseEntity.ok("Assigned user to image: " + updatedImage.toString());
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
