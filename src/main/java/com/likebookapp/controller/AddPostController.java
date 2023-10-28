package com.likebookapp.controller;

import com.likebookapp.model.binding.AddPostBindingModel;
import com.likebookapp.model.service.AddPostServiceModel;
import com.likebookapp.service.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/posts")
public class AddPostController {
    private final PostService postService;
    private final ModelMapper modelMapper;

    public AddPostController(PostService postService, ModelMapper modelMapper) {
        this.postService = postService;
        this.modelMapper = modelMapper;
    }
    @ModelAttribute
    public AddPostBindingModel addPostBindingModel(){
        return new AddPostBindingModel();
    }

    @GetMapping("/add")
    public String add(){
        return "post-add";
    }
    @PostMapping("/add")
    public String addConfirm(@Valid AddPostBindingModel addPostBindingModel, BindingResult bindingResult,
                             RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("addPostBindingModel", addPostBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.addPostBindingModel", bindingResult);

            return "redirect:add";
        }
        postService.addPost(modelMapper.map(addPostBindingModel, AddPostServiceModel.class));
        return "redirect:/home";

    }

}
