package com.gmail.burinigor7.fundraisinglogicservice.controller;

import com.gmail.burinigor7.fundraisinglogicservice.model.PayoutRequest;
import com.gmail.burinigor7.fundraisinglogicservice.service.PayoutRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payout-requests")
public class PayoutRequestController {
    private final PayoutRequestService payoutRequestService;

    @Autowired
    public PayoutRequestController(PayoutRequestService payoutRequestService) {
        this.payoutRequestService = payoutRequestService;
    }

    @PostMapping
    public PayoutRequest createPayoutRequest(@RequestBody PayoutRequest payoutRequest,
                                                       @RequestParam String username) {
        return payoutRequestService.create(payoutRequest, username);
    }

    @GetMapping("/{fundraisingProjectId}")
    public List<PayoutRequest> payoutRequestByFundraisingProject(@PathVariable Long fundraisingProjectId) {
        return payoutRequestService.getPayoutRequestByFundraisingProject(fundraisingProjectId);
    }

    @PostMapping("/approve")
    public PayoutRequest approvePayoutRequest(@RequestParam Long payoutRequestId, @RequestParam Long approverId,
                                              @RequestParam Integer countOfApproves) {
        return payoutRequestService.approvePayoutRequest(payoutRequestId, approverId, countOfApproves);
    }

    @GetMapping("/isApproved")
    public boolean isApproved(@RequestParam String username, @RequestParam Long prId) {
        return payoutRequestService.isApproved(username, prId);
    }
}
