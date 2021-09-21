package org.launchcode.codingevents.models;
import javax.validation.constraints.*;

import java.util.Objects;

public class Event {

    private int id;
    private static int nextId = 1;

    @Size(min=3, max=50, message = "Name must be between 3 and 50 characters.")
    @NotBlank(message = "Name is required.")
    private String name;

    @Size(max = 500, message = "Description too long.")
    private String description;

    @NotBlank(message = "Email is required.")
    @Email(message = "Invalid email, try again.")
    private String contactEmail;

    @NotBlank(message = "Location is required.")
    private String location;

    private boolean mustRegister = true;

    @Positive(message = "Event must have participants.")
    private int attendeeNumber;

    private boolean masksRequired = true;

    @NotBlank(message = "Response is required. Please enter from these three options: virtual, in person, or hybrid.")
    private String virtualOrInPerson;

    public Event(String name,
                 String description,
                 String contactEmail,
                 String location,
                 boolean mustRegister,
                 int attendeeNumber,
                 String virtualOrInPerson,
                 boolean masksRequired
    ) {
        this();
        this.name = name;
        this.description = description;
        this.contactEmail = contactEmail;
        this.location = location;
        this.mustRegister = mustRegister;
        this.attendeeNumber = attendeeNumber;
        this.virtualOrInPerson = virtualOrInPerson;
        this.masksRequired = masksRequired;

    }

    public Event(){
        this.id = nextId;
        nextId++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean isMustRegister() {
        return mustRegister;
    }

    public void setMustRegister(boolean mustRegister) {
        this.mustRegister = mustRegister;
    }

    public int getAttendeeNumber() {
        return attendeeNumber;
    }

    public void setAttendeeNumber(int attendeeNumber) {
        this.attendeeNumber = attendeeNumber;
    }

    public String getVirtualOrInPerson() {
        return virtualOrInPerson;
    }

    public void setVirtualOrInPerson(String virtualOrInPerson) {
        this.virtualOrInPerson = virtualOrInPerson;
    }

    public boolean isMasksRequired() {
        return masksRequired;
    }

    public void setMasksRequired(boolean masksRequired) {
        this.masksRequired = masksRequired;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return id == event.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
