package org.launchcode.codingevents.data;

import org.launchcode.codingevents.models.EventLocation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventLocationRepository extends CrudRepository<EventLocation, Integer> {
}
