package com.gmail.burinigor7.fundraisinglogicservice.internallcalls;

import com.gmail.burinigor7.fundraisinglogicservice.dto.RegistrationForm;
import com.gmail.burinigor7.fundraisinglogicservice.model.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@FeignClient(name = "crud-service")
public interface CrudServiceApiClient {
    @PostMapping("/api/users")
    User createUser(@RequestBody User newUser);

    @PostMapping("/api/users/validate")
    Map<String, String> validate(@RequestBody RegistrationForm registrationForm);

    @PostMapping("/api/fundraising-projects/validate")
    Map<String, String> validate(@RequestBody FundraisingProject fundraisingProject);

    @GetMapping("/api/users")
    User getUserByUsername(@RequestParam String username);

    @GetMapping("/api/fundraising-projects/{fundraisingProjectId}")
    FundraisingProject getFundraisingProjectById(@PathVariable Long fundraisingProjectId);

    @GetMapping("/api/fundraising-projects")
    List<FundraisingProject> getFundraisingProjectByTitlePiece(@RequestParam String titlePiece);

    @PostMapping("/api/fundraising-projects")
    FundraisingProject createFundraisingProject(@RequestBody FundraisingProject fundraisingProject);

    @GetMapping("/api/fundraising-projects/username")
    List<FundraisingProject> fundraisingProjectsByUsername(@RequestParam String username);

    @GetMapping("/api/fundraising-projects/all")
    List<FundraisingProject> allFundraisingProjects();

    @GetMapping("/api/fundraising-projects/visibleForUser")
    List<FundraisingProject> getFundraisingProjectVisibleForUser();

    @PutMapping("/api/fundraising-projects")
    FundraisingProject updateFundraisingProject(@RequestBody FundraisingProject fundraisingProject);

    @PostMapping("/payout-requests")
    PayoutRequest createPayoutRequest(@RequestBody PayoutRequest payoutRequest);

    @GetMapping("/payout-requests/{fundraisingProjectId}")
    List<PayoutRequest> payoutRequestByFundraisingProject(@PathVariable Long fundraisingProjectId);

    @GetMapping("/api/users/{userId}")
    User user(@PathVariable("userId") Long id);

    @PostMapping("/api/investments")
    Investment createInvestment(@RequestBody Investment investment);

    @GetMapping("/payout-requests")
    PayoutRequest payoutRequest(@RequestParam Long id);

    @GetMapping("/api/investments")
    List<Investment> getInvestments(@RequestParam Long fpId);

    @PostMapping("/payout-requests/approve")
    PayoutRequest approve(@RequestParam Long userId, @RequestParam Long prId, @RequestParam Long countOfApproves);

    @GetMapping("/api/fundraising-projects/invested")
    List<FundraisingProject> invested(@RequestParam Long investor);
}
