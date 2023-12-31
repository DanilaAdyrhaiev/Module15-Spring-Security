package com.goit.Module15.Controllers;

import com.goit.Module15.Repos.NoteRepository;
import com.goit.Module15.Services.NoteService;
import com.goit.Module15.entities.Note;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/note")
@RequiredArgsConstructor
public class NoteController {
    private final NoteService service;

    @GetMapping("/list")
    public ModelAndView list(){
        ModelAndView res = new ModelAndView("list");
        res.addObject("notes", service.listAll());
        return res;
    }

    @GetMapping("/add")
    public ModelAndView getAddPage(Note note) {
        ModelAndView modelAndView = new ModelAndView("add");
        modelAndView.addObject("note", note);
        return modelAndView;
    }

    @PostMapping("/add")
    public ModelAndView add(@ModelAttribute("note") Note note){
        service.add(note);
        return new ModelAndView("redirect:/note/list");
    }

    @PostMapping("/delete")
    public String delete(@RequestParam Long id){
        service.deleteById(id);
        return "redirect:/note/list";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView getEditPage(@PathVariable Long id) {
        ModelAndView res = new ModelAndView("edit");
        Note note = service.getById(id);
        System.out.println("edit> id: " + note.getId());
        res.addObject("note", note);
        return res;
    }

    @PostMapping("/edit")
    public ModelAndView edit(Note note){
        service.update(note);
        return new ModelAndView("redirect:/note/list");
    }
}
