package com.learn.classPortal.controller;

import com.learn.classPortal.repositories.BatchRepository;
import com.learn.classPortal.repositories.ClassRoomRepository;
import com.learn.classPortal.repositories.EventRepository;
import com.learn.classPortal.repositories.StudentRepository;
import com.learn.classPortal.repositories.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/dashboard")
@CrossOrigin(origins = {"http://localhost:5173", "${frontend.url}"})
public class DashboardController {

    @Autowired
    private BatchRepository batchRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private TrainerRepository trainerRepository;

    @Autowired
    private ClassRoomRepository classRoomRepository;

    @GetMapping("/stats")
    public Map<String, Long> getDashboardStats() {
        Map<String, Long> stats = new HashMap<>();
        stats.put("totalBatches", batchRepository.count());
        stats.put("totalStudents", studentRepository.count());
        stats.put("totalEvents", eventRepository.count());
        stats.put("totalTrainers", trainerRepository.count());
        stats.put("totalClassRooms", classRoomRepository.count());
        return stats;
    }
}
