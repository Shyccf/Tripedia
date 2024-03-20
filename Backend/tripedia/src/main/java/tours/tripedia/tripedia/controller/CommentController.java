package tours.tripedia.tripedia.controller;

import org.hibernate.sql.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tours.tripedia.tripedia.model.Comment;
import tours.tripedia.tripedia.service.CommentService;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import static tours.tripedia.tripedia.Component.GlobalVariables.crossOriginUrl;

@RestController
@RequestMapping("api/comment")
@CrossOrigin(origins = crossOriginUrl)
public class CommentController {
    private CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping
    public List<Comment> getAllComment() {
        return commentService.getAllComment();
    }

    @GetMapping(path = "{id}")
    public Optional<Comment> getCommentById(@PathVariable("id") Long commentId) {
        return commentService.getCommentById(commentId);
    }

    @PostMapping(path = "/add")
    public ResponseEntity<String> addComment(@RequestBody Comment comment) {
        try {
            comment.setCommentDate(Calendar.getInstance().getTime());
            Comment savedComment = commentService.addComment(comment);
            return ResponseEntity.ok("Added comment: " + savedComment.toString());
        }
        catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @DeleteMapping(path = "/delete")
    public void deleteComment(@RequestBody Comment comment) {
        commentService.deleteComment(comment);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void deleteCommentById(@PathVariable("id") Long commentId) {
        commentService.deleteCommentById(commentId);
    }

    @PostMapping("/update")
    public ResponseEntity<String> updateComment(@RequestBody Comment comment) {
        try {
            comment.setCommentDate(Calendar.getInstance().getTime());
            Comment savedComment = commentService.updateComment(comment);
            return ResponseEntity.ok("Updated comment: " + savedComment.toString());
        }
        catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PostMapping("assignpost/{cid}/{pid}")
    public ResponseEntity<String> assignPost(@PathVariable("cid") Long commentId, @PathVariable("pid") Long postId) {
        try {
            Comment savedComment = commentService.assignPost(commentId, postId);
            return ResponseEntity.ok("Assigned comment: " + savedComment.toString());
        }
        catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PostMapping("assignuser/{cid}/{uid}")
    public ResponseEntity<String> assignUser(@PathVariable("cid") Long commentId,
                                             @PathVariable("uid") Long userId) {
        try {
            Comment savedComment = commentService.assignUser(commentId, userId);
            return ResponseEntity.ok("Assigned comment: " + savedComment.toString());
        }
        catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
