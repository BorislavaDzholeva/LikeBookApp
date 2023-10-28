package com.likebookapp.controller;

import com.likebookapp.model.entity.Post;
import com.likebookapp.model.entity.User;
import com.likebookapp.repository.PostRepository;
import com.likebookapp.service.PostService;
import com.likebookapp.service.UserService;
import com.likebookapp.util.CurrentUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Set;

@Controller
public class HomeController {
    private final CurrentUser currentUser;
    private final PostService postService;
    private final UserService userService;
    private final PostRepository postRepository;

    public HomeController(CurrentUser currentUser, PostService postService, UserService userService, PostRepository postRepository) {
        this.currentUser = currentUser;
        this.postService = postService;
        this.userService = userService;
        this.postRepository = postRepository;
    }

    @GetMapping("/")
    public String index() {
        if (currentUser.getId() != null) {
            return "redirect:/home";
        }
        return "index";

    }

    @GetMapping("/home")
    public String home(Model model) {
        if (currentUser.getId() == null) {
            return "index";
        }
        List<Post> myPosts = postService.findPostByUserId(currentUser.getId());
        List<Post> otherPosts = postService.findPostByUserIdNot(currentUser.getId());

        model.addAttribute("myPosts", myPosts);
        model.addAttribute("otherPosts", otherPosts);
        return "home";
    }


    @GetMapping("/like/{id}")
    public String likePost(@PathVariable Long id){
        User user = userService.findById(currentUser.getId());
        Post post = postService.findById(id);
        Set<User> likes = post.getUserLikes();
        likes.add(user);
        post.setUserLikes(likes);
        postRepository.save(post);
        return "redirect:/home";
    }
    @GetMapping("/remove/{id}")
    public String removePost(@PathVariable Long id) {
        postService.removePostById(id);
        return "redirect:/home";
    }
}
