package com.likebookapp.service.impl;

import com.likebookapp.model.entity.Post;
import com.likebookapp.model.service.AddPostServiceModel;
import com.likebookapp.repository.PostRepository;
import com.likebookapp.service.MoodService;
import com.likebookapp.service.PostService;
import com.likebookapp.service.UserService;
import com.likebookapp.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    private final ModelMapper modelMapper;
    private final MoodService moodService;
    private final UserService userService;
    private final CurrentUser currentUser;

    public PostServiceImpl(PostRepository postRepository, ModelMapper modelMapper, MoodService moodService, UserService userService, CurrentUser currentUser) {
        this.postRepository = postRepository;
        this.modelMapper = modelMapper;
        this.moodService = moodService;
        this.userService = userService;
        this.currentUser = currentUser;
    }

    @Override
    public void addPost(AddPostServiceModel addPostServiceModel) {
        Post post = modelMapper.map(addPostServiceModel, Post.class);
        post.setMood(moodService.findByMoodNameEnum(addPostServiceModel.getMood()));
        post.setUser(userService.findById(currentUser.getId()));
        postRepository.save(post);
    }

    @Override
    public List<Post> findPostByUserId(Long id) {
        return postRepository.findByUserId(id);
    }

    @Override
    public List<Post> findPostByUserIdNot(Long id) {
        return postRepository.findByUserIdNot(id);
    }

    @Override
    public void removePostById(Long id) {
         postRepository.deleteById(id);
    }

    @Override
    public Post findById(Long id) {
        return postRepository.findById(id).orElse(null);

    }
}
