package org.launchcode.codingevents.controllers;

import org.launchcode.codingevents.data.EventCategoryRepository;
import org.launchcode.codingevents.data.EventRepository;
import org.launchcode.codingevents.models.Event;
import org.launchcode.codingevents.models.EventCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
    @RequestMapping("events")
    public class EventController {

        @Autowired
        private EventRepository eventRepository;

        @Autowired
        private EventCategoryRepository eventCategoryRepository;

        @GetMapping
        public String displayEvents(@RequestParam(required = false) Integer categoryId, Model model) {
            if (categoryId == null) {
                model.addAttribute("title", "All Events");
                model.addAttribute("events", eventRepository.findAll());
            } else {
                Optional<EventCategory> result = eventCategoryRepository.findById(categoryId);
                if (result.isEmpty()) {  //user asked for a category id and that id wasn't in the database
                    model.addAttribute("title", "Invalid Category ID: " + categoryId);
                } else {
                    EventCategory category = result.get();
                    model.addAttribute("title", "Events in category: " + category.getName());
                    model.addAttribute("events", category.getEvents());
                }
            }

            return "events/index";
        }

//        static page lives at /events/create
        @GetMapping("create")
        public String displayCreateEventForm(Model model) {
            model.addAttribute("title", "Create Event");
            model.addAttribute(new Event()); //passing empty event object because it has information about the parameters
            model.addAttribute("categories", eventCategoryRepository.findAll()); //returns array of 4 constant values in the EventType
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
                return "events/create";
            }
            eventRepository.save(newEvent);

            return "redirect:";
        }

//        displays the form, returns a form
        @GetMapping("delete")
        public String displayDeleteEventForm(Model model) {
            model.addAttribute("title", "Delete Events");
            model.addAttribute("events", eventRepository.findAll());
            return "events/delete";
        }

        @PostMapping("delete") //required=false means that the method can run without an ID
        public String processDeleteEventsForm(@RequestParam(required = false) int[] eventIds) {
            if (eventIds != null) {
                for (int id : eventIds) {
                    eventRepository.deleteById(id);
                }
            }
            return "redirect:";  //sends us back to the index
        }

}
