package edu.university.finals.polyclinic.controller;

import edu.university.finals.polyclinic.dto.HistoryDto;
import edu.university.finals.polyclinic.service.HistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/history")
@RequiredArgsConstructor
public class HistoryController {
    private final HistoryService historyService;

    @GetMapping
    public ResponseEntity<List<HistoryDto>> getHistoryOfPatient(@RequestParam(defaultValue = "0") Long id) {
        if (id == 0) return ResponseEntity.ok(new ArrayList<>());
        return ResponseEntity.ok(historyService.getHistoryOfPatient(id));
    }
}
