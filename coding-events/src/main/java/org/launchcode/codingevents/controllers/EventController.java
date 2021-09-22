package org.launchcode.codingevents.controllers;

import org.launchcode.codingevents.data.EventData;
import org.launchcode.codingevents.models.Event;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

    @Controller
    @RequestMapping("events")
    public class EventController {

        @GetMapping
        public String displayAllEvents(Model model) {
            model.addAttribute("title", "All Events");
            model.addAttribute("events", EventData.getAll());
            return "events/index";
        }

//        static page lives at /events/create
        @GetMapping("create")
        public String displayCreateEventForm(Model model) {
            model.addAttribute("title", "Create Event");
            return "events/create";
        }

        //    lives at /events/create
//    the "redirect:" without anything additional sends back to root /create page
//    could also use "redirect:/create"
//        the @modelattribute does the model binding of taking all incoming parameters and making an Event object with them
//        force the checking of validation rules with @Valid
        @PostMapping("create")
        public String processCreateEventForm(@ModelAttribute @Valid Event newEvent,
                                             Errors errors, Model model) {
            if(errors.hasErrors()) {
                model.addAttribute("title", "Create Event");
                model.addAttribute("errorMsg", "Bad data!");
                return "events/create";
            }
            EventData.add(newEvent);
            return "redirect:";
        }

//        displays the form, returns a form
        @GetMapping("delete")
        public String displayDeleteEventForm(Model model) {
            model.addAttribute("title", "Delete Events");
            model.addAttribute("events", EventData.getAll());
            return "events/delete";
        }

        @PostMapping("delete") //required=false means that the method can run without an ID
        public String processDeleteEventsForm(@RequestParam(required = false) int[] eventIds) {
            if (eventIds != null) {
                for (int id : eventIds) {
                    EventData.remove(id);
                }
            }
            return "redirect:";  //sends us back to the index
        }

}
