package org.launchcode.codingevents.models;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class EventLocation extends AbstractEntity {

    private String location;

    @OneToMany(mappedBy = "eventLocation")
    private final List<Event> events = new ArrayList<>();

    public EventLocation (){}

    public EventLocation(String location) {
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Event> getEvents() {
        return events;
    }
}
