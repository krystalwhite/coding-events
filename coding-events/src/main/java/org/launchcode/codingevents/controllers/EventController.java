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
            events.put("Code with Pride", "Code with Pride is an affinity group that aims to help underrepresented groups succeed in tech and is working for inclusive change in the St. Louis tech community and beyond.");
            events.put("Women Who Code", "Women Who Code inspires women to excel in technology careers.");
            events.put("Strange Loop", "Strange Loop is a conference for software developers covering programming languages, databases, creativity, and more.");
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
