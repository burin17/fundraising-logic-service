package com.gmail.burinigor7.fundraisinglogicservice.service;

import com.gmail.burinigor7.fundraisinglogicservice.internallcalls.CrudServiceApiClient;
import com.gmail.burinigor7.fundraisinglogicservice.model.FundraisingProject;
import com.gmail.burinigor7.fundraisinglogicservice.model.Investment;
import com.gmail.burinigor7.fundraisinglogicservice.model.PayoutRequest;
import com.gmail.burinigor7.fundraisinglogicservice.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@Service
public class PayoutRequestService {
    private final CrudServiceApiClient crudServiceApiClient;

    @Autowired
    public PayoutRequestService(CrudServiceApiClient crudServiceApiClient) {
        this.crudServiceApiClient = crudServiceApiClient;
    }

    public PayoutRequest create(PayoutRequest payoutRequest,
                                String username) {
        LocalDate until = LocalDate.now().plusDays(payoutRequest.getDays());
        Date achieveBy = Date.from(until.atStartOfDay()
                .atZone(ZoneId.systemDefault())
                .toInstant());
        payoutRequest.setAchieveBy(achieveBy);
        FundraisingProject fundraisingProject = crudServiceApiClient.getFundraisingProjectById(payoutRequest.getFundraisingProjectId());
        Long currentUserId = crudServiceApiClient.getUserByUsername(username).getId();
        if (fundraisingProject.getFounder().getId().equals(currentUserId)) {
            payoutRequest.setFundraisingProject(fundraisingProject);
            return crudServiceApiClient.createPayoutRequest(payoutRequest);
        }
        return null;
    }

    public List<PayoutRequest> getPayoutRequestByFundraisingProject(Long fundraisingProjectId) {
        return crudServiceApiClient.payoutRequestByFundraisingProject(fundraisingProjectId);
    }

    public PayoutRequest approvePayoutRequest(Long payoutRequestId, Long approverId, Integer countOfApproves) {
        PayoutRequest payoutRequest = crudServiceApiClient.payoutRequest(payoutRequestId);
        FundraisingProject fundraisingProject = payoutRequest.getFundraisingProject();
        List<Investment> investments = crudServiceApiClient.getInvestments(fundraisingProject.getFundraisingProjectId());
        if (investments.stream().anyMatch(investment -> investment.getInvestor().getId().equals(approverId))) {
            return crudServiceApiClient.approve(approverId, payoutRequestId, countOfApproves);
        }
        return null;
    }

    public boolean isApproved(String username, Long prId) {
        User user = crudServiceApiClient.getUserByUsername(username);
        PayoutRequest payoutRequest = crudServiceApiClient.payoutRequest(prId);
        return payoutRequest.getApprovers().stream().anyMatch(approver -> approver.getId().equals(user.getId()));
    }
}
