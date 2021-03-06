package com.gmail.burinigor7.fundraisinglogicservice.controller;

import com.gmail.burinigor7.fundraisinglogicservice.model.FundraisingProject;
import com.gmail.burinigor7.fundraisinglogicservice.model.FundraisingProjectStatus;
import com.gmail.burinigor7.fundraisinglogicservice.model.Investment;
import com.gmail.burinigor7.fundraisinglogicservice.model.User;
import com.gmail.burinigor7.fundraisinglogicservice.service.FundraisingProjectService;
import com.gmail.burinigor7.fundraisinglogicservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/fundraising-projects")
public class FundraisingProjectController {
    private final FundraisingProjectService fundraisingProjectService;
    private final UserService userService;

    @Autowired
    public FundraisingProjectController(FundraisingProjectService fundraisingProjectService,
                                        UserService userService) {
        this.fundraisingProjectService = fundraisingProjectService;
        this.userService = userService;
    }

    @GetMapping("/{fundraisingProjectId}")
    public FundraisingProject fundraisingProject(@PathVariable Long fundraisingProjectId) {
        return fundraisingProjectService.fundraisingProject(fundraisingProjectId);
    }

    @GetMapping("/all")
    public List<FundraisingProject> allFundraisingProjects() {
        return fundraisingProjectService.all();
    }

    @GetMapping
    public List<FundraisingProject> fundraisingProjectByTitlePiece(@RequestParam String titlePiece) {
        return fundraisingProjectService.fundraisingProjectsByTitlePiece(titlePiece);
    }

    @PostMapping
    public ResponseEntity<?> createFundraisingProject(@RequestBody FundraisingProject fundraisingProject,
                                                      @RequestParam String username) {
        fundraisingProject.setFounder(userService.getUserByUsername(username));
        fundraisingProject.setCurrentAmount(0.0F);
        Map<String, String> validationResults = fundraisingProjectService.validate(fundraisingProject);
        if (validationResults.isEmpty()) {
            return ResponseEntity.ok(fundraisingProjectService.createFundraisingProject(fundraisingProject));
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).body(validationResults);
    }

    @GetMapping("/username")
    public List<FundraisingProject> fundraisingProjectByUsername(@RequestParam String username) {
        return fundraisingProjectService.fundraisingProjectsByUsername(username);
    }

    @GetMapping("/visibleForUser")
    public List<FundraisingProject> fundraisingProjectByStatus() {
        return fundraisingProjectService.getFundraisingProjectByStatus();
    }

    @PostMapping("/start")
    public FundraisingProject startCompany(@RequestParam Long id, @RequestParam String contractAddress) {
        return fundraisingProjectService.startCompany(id, contractAddress);
    }

    @PostMapping("/invest")
    public FundraisingProject invest(@RequestParam Long id, @RequestParam Float currentAmount,
                                     @RequestParam Float ethAmount, @RequestParam Long investor,
                                     @RequestParam String from) {
        return fundraisingProjectService.invest(id, currentAmount, ethAmount, investor, from);
    }

    @PostMapping("/updateCurrentBalance")
    public FundraisingProject updateCurrentBalance(@RequestParam Long id, @RequestParam Float currentBalance) {
        return fundraisingProjectService.updateCurrentBalance(id, currentBalance);
    }

    @PostMapping("/expired")
    public FundraisingProject changeFundraisingProjectStatusToExpired(@RequestParam Long fpId) {
        return fundraisingProjectService.changeFundraisingProjectStatusToExpired(fpId);
    }

    @GetMapping("/invested")
    public List<FundraisingProject> getInvestedFundraisingProjects(@RequestParam String username) {
        return fundraisingProjectService.getInvestedFundraisingProjects(username);
    }

    @GetMapping("/tags/{projectId}")
    public List<String> getTagsForProject(@PathVariable Long projectId) {
        return fundraisingProjectService.getTags(projectId);
    }

    @GetMapping("/search/{titlePiece}")
    public List<FundraisingProject> search(@PathVariable String titlePiece, @RequestParam String[] tags) {
        return fundraisingProjectService.search(titlePiece, tags);
    }

    @GetMapping("/search-by-tags")
    public List<FundraisingProject> search(@RequestParam String[] tags) {
        return fundraisingProjectService.search(tags);
    }

    @GetMapping("/investments/{fpId}")
    public List<Investment> investors(@PathVariable Long fpId) {
        return userService.investors(fpId);
    }
}
