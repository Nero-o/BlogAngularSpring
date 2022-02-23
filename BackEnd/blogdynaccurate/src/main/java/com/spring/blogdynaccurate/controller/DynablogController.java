package com.spring.blogdynaccurate.controller;

import com.spring.blogdynaccurate.service.dynaBlogService;
import com.spring.blogdynaccurate.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@Controller
public class DynablogController {

    @Autowired
    dynaBlogService dynablogService;

    @RequestMapping(value = "/posts", method = RequestMethod.GET)
    public ResponseEntity<Post> getPosts() {
        List<Post> posts = dynablogService.findAll();

        return new ResponseEntity(posts, HttpStatus.OK);
    }

    @RequestMapping(value = "/posts/{id}", method = RequestMethod.GET)
    public ModelAndView getPostDetails(@PathVariable("id") long id) {
        ModelAndView mv = new ModelAndView("postDetails");
        Post post = dynablogService.findById(id);
        mv.addObject("post", post);
        return mv;
    }

    @RequestMapping(value = "/newpost", method = RequestMethod.GET)
    public ModelAndView getPostForm(){
        ModelAndView mv = new ModelAndView( "postForm");
         return mv;
    }

    @RequestMapping(value="/newpost", method=RequestMethod.POST)
    public String savePost(@Valid Post post, BindingResult result, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            attributes.addFlashAttribute("mensagem", "Verifique se os campos obrigatórios foram preenchidos!");
            return "redirect:/newpost";
        }
        post.setData(LocalDate.now());
        dynablogService.Save(post);
        return "redirect:/posts";
    }


}
