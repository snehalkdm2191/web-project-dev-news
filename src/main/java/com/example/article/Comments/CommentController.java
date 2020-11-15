package com.example.article.Comments;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class CommentController {
    private CommentServices commentServices;

    public CommentController(@Autowired CommentServices commentServices) {
        this.commentServices = commentServices;
    }

    @GetMapping("/comments")
    public List<Comment> getAll(){
        return commentServices.getAll();
    }

    @RequestMapping("comments/{id}")
    public Comment getById(@PathVariable Long id){
        return commentServices.getByID(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/comments")
    public Comment create(@RequestBody Comment comment){
        return commentServices.create(comment);
    }

    @PutMapping("/comments")
    public Comment update(@RequestBody Comment comment){
        return commentServices.update(comment);
    }

    @DeleteMapping("comments/{id}")
    public void delete(@PathVariable Long id){
        commentServices.delete(id);
    }
}
