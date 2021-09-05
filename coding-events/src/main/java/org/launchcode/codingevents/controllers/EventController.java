package org.launchcode.codingevents.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

    @Controller
    @RequestMapping("events")
    public class EventController {

        private HashMap<String, String> events = new HashMap<>();

        @GetMapping
        public String displayAllEvents(Model model) {
            events.put("Event 1", "party in September");
            events.put("Event 2", "party in December");
            events.put("Event 3", "party in March");
            model.addAttribute("title", "All Events");
            model.addAttribute("events", events);
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
        @PostMapping("create")
        public String processCreateEventForm(@RequestParam String eventName, @RequestParam String eventDescription) {
            events.put(eventName, eventDescription);
            return "redirect:";
        }




}
