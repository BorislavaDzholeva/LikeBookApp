package com.likebookapp.service;

import com.likebookapp.model.entity.Post;
import com.likebookapp.model.service.AddPostServiceModel;

import java.util.List;

public interface PostService {
    void addPost(AddPostServiceModel addPostServiceModel);

    List<Post> findPostByUserId(Long id);

    List<Post> findPostByUserIdNot(Long id);

    void removePostById(Long id);

    Post findById(Long id);
}
