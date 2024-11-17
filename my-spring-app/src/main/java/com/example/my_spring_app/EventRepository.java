package com.example.my_spring_app;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {
    List<Event>findByTypeInOrderByTimestampDesc(List<String> types);
}
