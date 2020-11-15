package com.example.article.Comments;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CommentServices {
    @Autowired
    private CommentRepo repo;

    private static final List<Comment> commentList =new ArrayList<>();

    public List<Comment> getAll(){
        return repo.findAll();
    }

    public Optional<Comment> getByID(long id){
        return repo.findById(id);
    }

    public Comment create(Comment newComment){
        return repo.save(newComment);
    }

    public Comment update(Comment updateComment){
        return repo.save(updateComment);
    }

    public void delete(Long id){
        repo.deleteById(id);
    }
}
