package com.gmail.burinigor7.fundraisinglogicservice.service;

import com.gmail.burinigor7.fundraisinglogicservice.internallcalls.CrudServiceApiClient;
import com.gmail.burinigor7.fundraisinglogicservice.model.Investment;
import com.gmail.burinigor7.fundraisinglogicservice.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final CrudServiceApiClient crudServiceApiClient;

    public UserService(CrudServiceApiClient crudServiceApiClient) {
        this.crudServiceApiClient = crudServiceApiClient;
    }

    public User getUserByUsername(String username) {
        return crudServiceApiClient.getUserByUsername(username);
    }

    public boolean isInvestor(String username, Long fpId) {
        User user = crudServiceApiClient.getUserByUsername(username);
        return crudServiceApiClient.getInvestments(fpId).stream()
                .anyMatch(investment -> investment.getInvestor().getId().equals(user.getId()));
    }

    public List<User> usersByPieceOfUsername(String piece) {
        return crudServiceApiClient.usersByPieceOfUsername(piece);
    }

    public List<Investment> investments(Long userId) {
        return crudServiceApiClient.getInvestmentsForUser(userId);
    }
}
