package com.jobportal.Controllers;

import com.jobportal.DTOS.ExperienceDTO;
import com.jobportal.Entities.Exprience;
import com.jobportal.Services.ExprienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/exprience")
@CrossOrigin(origins = "http://localhost:5173")
public class ExprienceController {
    @Autowired
    private ExprienceService exprienceService;

    @GetMapping("")
    public List<Exprience> getAllExprience() {
        return exprienceService.getAllExprience();
    }

    @PostMapping("/{id}")
    public ExperienceDTO addExprience(@RequestBody ExperienceDTO exprience, @PathVariable Long id){
        return exprienceService.addExprience(exprience,id);
    }

    @PutMapping("/{id}")
    public ExperienceDTO updateExprience(@RequestBody ExperienceDTO exprience, @PathVariable Long id){
        return exprienceService.updateExprience(exprience, id);
    }

    @DeleteMapping("/{expId}")
    public ResponseEntity<String> deleteExprience(@PathVariable Long expId){
        return exprienceService.delExp(expId);
    }
}
