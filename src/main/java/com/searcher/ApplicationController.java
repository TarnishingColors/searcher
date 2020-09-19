package com.searcher;

import com.searcher.domain.Message;
import com.searcher.repos.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
public class ApplicationController {
    @Autowired
    private MessageRepo mesageRepo;

    @GetMapping()
    public String greeting(Map<String, Object> model) {
        Iterable<Message> messages = mesageRepo.findAll();

        model.put("messages", messages);
        return "starting";
    }

    @PostMapping
    public String add(@RequestParam String text,
                      @RequestParam String tag,
                      Map<String, Object> model){
        Message message = new Message(text, tag);

        mesageRepo.save(message);

        Iterable<Message> messages = mesageRepo.findAll();

        model.put("messages", messages);

        return "starting";
    }

    @PostMapping("filter")
    public String filter(@RequestParam String filter,
                         Map<String, Object> model){
        Iterable<Message> messages;
        if(filter == null || filter.isEmpty()) {
            messages = mesageRepo.findAll();
        } else {
            messages = mesageRepo.findByTag(filter);
        }

        model.put("messages", messages);

        return "starting";
    }

}