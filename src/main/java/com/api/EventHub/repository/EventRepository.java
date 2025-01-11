package com.api.EventHub.repository;

import com.api.EventHub.model.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

    @Query(value = "SELECT *"
            + " FROM event"
            + " WHERE ds_event_type LIKE :type"
            , nativeQuery = true)
    List<Event> findEventsByType(@Param("type") String type);
}
