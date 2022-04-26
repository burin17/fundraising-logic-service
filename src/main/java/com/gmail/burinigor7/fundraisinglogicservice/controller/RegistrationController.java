package com.gmail.burinigor7.fundraisinglogicservice.controller;

import com.gmail.burinigor7.fundraisinglogicservice.dto.RegistrationForm;
import com.gmail.burinigor7.fundraisinglogicservice.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping("/register")
public class RegistrationController {
    private final RegistrationService registrationService;

    @Autowired
    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @PostMapping
    public ResponseEntity<?> register(@Valid @RequestBody RegistrationForm registrationForm) {
        return registrationService.register(registrationForm);
    }
}
