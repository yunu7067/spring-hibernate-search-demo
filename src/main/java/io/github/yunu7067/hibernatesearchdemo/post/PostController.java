package io.github.yunu7067.hibernatesearchdemo.post;

import io.github.yunu7067.hibernatesearchdemo.post.dto.PostRepository;
import io.github.yunu7067.hibernatesearchdemo.post.dto.UploadPostDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@Controller
public class PostController {
    @Autowired
    private PostRepository postRepository;

    @GetMapping("/")
    public ModelAndView IndexPage(ModelAndView modelAndView) {
        modelAndView.setViewName("index");
        modelAndView.addObject("test", "testvalue");

        var posts = postRepository.findAll();
        modelAndView.addObject("posts", posts);

        return modelAndView;
    }

    @PostMapping("/post")
    public String UploadPostApi(UploadPostDto uploadPostDto) {
        System.out.println(uploadPostDto.toString());
        var post = new Post(uploadPostDto.getTitle(), uploadPostDto.getContent());
        postRepository.save(post);

        return "redirect:/";
    }
}
