package io.github.yunu7067.hibernatesearchdemo.post;

import io.github.yunu7067.hibernatesearchdemo.post.dto.PostRepository;
import io.github.yunu7067.hibernatesearchdemo.post.dto.UploadPostDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class PostController {
    private final HibernateSearchService hibernateSearchService;
    private final PostRepository postRepository;

    public PostController(PostRepository postRepository, HibernateSearchService hibernateSearchService) {
        this.postRepository = postRepository;
        this.hibernateSearchService = hibernateSearchService;
    }

    @GetMapping("/")
    public ModelAndView indexPage(ModelAndView modelAndView) {
        modelAndView.setViewName("index");
        modelAndView.addObject("test", "testvalue");


        var posts = postRepository.findAll();
        modelAndView.addObject("posts", posts);

        return modelAndView;
    }

    @PostMapping("/post")
    public String uploadPostApi(UploadPostDto uploadPostDto) throws InterruptedException {
        System.out.println(uploadPostDto.toString());
        var post = new Post(uploadPostDto.getTitle(), uploadPostDto.getContent());
        postRepository.save(post);
        hibernateSearchService.initialIndexing();

        return "redirect:/";
    }

    @GetMapping("/post/search")
    @ResponseBody
    public List<Post> searchPost(@RequestParam String keyword) {
        var results = hibernateSearchService.searchPost(keyword).hits();

        return results;
    }
}
