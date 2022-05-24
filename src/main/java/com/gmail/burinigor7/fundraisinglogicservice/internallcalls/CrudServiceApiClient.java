package com.gmail.burinigor7.fundraisinglogicservice.internallcalls;

import com.gmail.burinigor7.fundraisinglogicservice.dto.RegistrationForm;
import com.gmail.burinigor7.fundraisinglogicservice.model.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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

    @PostMapping("/api/payout-requests")
    PayoutRequest createPayoutRequest(@RequestBody PayoutRequest payoutRequest);

    @GetMapping("/api/payout-requests/{fundraisingProjectId}")
    List<PayoutRequest> payoutRequestByFundraisingProject(@PathVariable Long fundraisingProjectId);

    @GetMapping("/api/users/{userId}")
    User user(@PathVariable("userId") Long id);

    @PostMapping("/api/investments")
    Investment createInvestment(@RequestBody Investment investment);

    @GetMapping("/api/payout-requests")
    PayoutRequest payoutRequest(@RequestParam Long id);

    @GetMapping("/api/investments")
    List<Investment> getInvestments(@RequestParam Long fpId);

    @PostMapping("/api/payout-requests/approve")
    PayoutRequest approve(@RequestParam Long userId, @RequestParam Long prId, @RequestParam Integer countOfApproves);

    @GetMapping("/api/fundraising-projects/invested")
    List<FundraisingProject> invested(@RequestParam Long investor);

    @GetMapping("/api/fundraising-projects/tags/{projId}")
    List<String> getTags(@PathVariable Long projId);

    @GetMapping("/api/fundraising-projects/search/{titlePiece}")
    List<FundraisingProject> search(@PathVariable String titlePiece, @RequestParam String[] tags);

    @GetMapping("/api/fundraising-projects/search-by-tags")
    List<FundraisingProject> search(@RequestParam String[] tags);

    @GetMapping("/api/users/piece")
    List<User> usersByPieceOfUsername(@RequestParam String usernamePiece);

    @GetMapping ("/api/investments/user/{userId}")
    List<Investment> getInvestmentsForUser(@PathVariable Long userId);
}
