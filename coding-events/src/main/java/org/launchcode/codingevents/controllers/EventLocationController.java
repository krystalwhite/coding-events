package org.launchcode.codingevents.controllers;

import org.launchcode.codingevents.data.EventCategoryRepository;
import org.launchcode.codingevents.data.EventLocationRepository;
import org.launchcode.codingevents.models.EventCategory;
import org.launchcode.codingevents.models.EventLocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("eventLocations")
public class EventLocationController {

    @Autowired
    private EventLocationRepository eventLocationRepository;

    @GetMapping
    public String displayAllLocations(Model model) {
        model.addAttribute("title", "All Locations");
        model.addAttribute("locations", eventLocationRepository.findAll());
        return "eventLocations/index";
    }

    @GetMapping("create")
    public String renderCreateEventLocationForm (Model model) {
        model.addAttribute("title", "Create Location");
        model.addAttribute(new EventLocation());
        return "eventLocations/create";
    }

    @PostMapping("create")
    public String processCreateEventLocationForm(@ModelAttribute @Valid EventLocation newEventLocation,
                                                 Errors errors,
                                                 Model model) {
        if(errors.hasErrors()) {
            model.addAttribute("title", "Create Location");
            model.addAttribute(new EventLocation());
            return "eventLocations/create";
        }
        eventLocationRepository.save(newEventLocation);
        return "redirect:";
    }
}

