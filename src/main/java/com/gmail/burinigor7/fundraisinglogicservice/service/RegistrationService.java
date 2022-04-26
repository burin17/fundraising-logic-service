package com.gmail.burinigor7.fundraisinglogicservice.service;

import com.gmail.burinigor7.fundraisinglogicservice.dto.RegistrationForm;
import com.gmail.burinigor7.fundraisinglogicservice.internallcalls.CrudServiceApiClient;
import com.gmail.burinigor7.fundraisinglogicservice.model.Role;
import com.gmail.burinigor7.fundraisinglogicservice.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;

import java.io.File;
import java.util.Map;

@Service
public class RegistrationService {
    private final CrudServiceApiClient crudServiceApiClient;
    @Value("${wallets.dir}")
    private String walletsDir;

    @Autowired
    public RegistrationService(CrudServiceApiClient crudServiceApiClient) {
        this.crudServiceApiClient = crudServiceApiClient;
    }

    public ResponseEntity<?> register(RegistrationForm registrationForm) {
        Map<String, String> validationResults = validate(registrationForm);
        if (validationResults.isEmpty()) {
            User newUser = new User(registrationForm);
            newUser.setRole(Role.USER);
            return ResponseEntity.ok().body(crudServiceApiClient.createUser(newUser));
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).body(validationResults);
    }

    private Map<String, String> validate(RegistrationForm registrationForm) {
        return crudServiceApiClient.validate(registrationForm);
    }
}
