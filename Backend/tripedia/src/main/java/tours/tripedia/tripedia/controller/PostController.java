package tours.tripedia.tripedia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tours.tripedia.tripedia.model.Post;
import tours.tripedia.tripedia.service.PostService;

import java.util.List;
import java.util.Optional;

import static tours.tripedia.tripedia.Component.GlobalVariables.crossOriginUrl;

@RestController
@RequestMapping("api/post")
@CrossOrigin(origins = crossOriginUrl)
public class PostController {
    PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public List<Post> getAllPost() {
        return postService.getAllPost();
    }

    @GetMapping("/{pid}")
    public Optional<Post> getPostById(@PathVariable("pid") Long postId) {
        return postService.getPostById(postId);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addPost(@RequestBody Post post) {
        try {
            Post savedPost = postService.addPost(post);

            return ResponseEntity.ok("Added post: " + savedPost.toString());
        }
        catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @DeleteMapping("/delete")
    public void deletePostById(Long postId) {
        postService.deletePostById(postId);
    }

    @PostMapping("/update")
    public ResponseEntity<String> updatePost(@RequestBody Post post) {
        try {
            Post savedPost = postService.updatePost(post);

            return ResponseEntity.ok("Updated post: " + savedPost.toString());
        }
        catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    /*
    @GetMapping(path = "assignspot/{pid}/{sid}")
    public ResponseEntity<String> assignSpot(PathVariable("pid") Long postId, @PathVariable("sid") Long spotId) {
        try {
            Post updatedPost = postService.assignSpot(postId, spotId);

            return ResponseEntity.ok("Assigned spot: " + updatedPost.toString());
        }
        catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping(path = "assignuser/{pid}/{uid}")
    public ResponseEntity<String> assignUser(@PathVariable("pid") Long postId,
                                             @PathVariable("uid") Long userId) {
        try {
            Post updatedPost = postService.assignUser(postId, userId);
            return ResponseEntity.ok("Assigned user. " + updatedPost.toString());
        } catch (PostNotExistException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (UserNotExistException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PostMapping("/assigncontent/{pid}")
    public ResponseEntity<String> assignContent(@PathVariable("pid") Long postId,
                                                @RequestBody String content) {
        try{
            Post updatedPost = postService.assignContent(postId, content);
            return ResponseEntity.ok("Assigned content. " + updatedPost.toString());
        } catch (InvalidPostException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
     */
}
