package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.AssesmentApplication;
import com.example.demo.model.Email;
import com.example.demo.model.SampleModel;
import com.example.demo.repository.SampleRepository;
import com.example.demo.service.EmailService;
import com.example.demo.utils.HttpResponse;
import com.example.demo.utils.Logger;
import java.io.IOException;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

@RestController
@RequestMapping("")
public class Controller {

    @Autowired
    private SampleRepository sampleRepository;

    @Autowired
    private EmailService emailService;

    @PostMapping(path = {""}, name = "form-post", produces = "application/json")
    public ResponseEntity<HttpResponse> postForm(HttpServletRequest request, @RequestBody SampleModel bodyRequest) {
        String logPrefix = request.getRequestURI();
        HttpResponse response = new HttpResponse(request.getRequestURI());
        Logger.application.info(Logger.pattern, AssesmentApplication.VERSION, logPrefix, "", "");

        SampleModel savedSample = sampleRepository.save(bodyRequest);

        response.setStatus(HttpStatus.CREATED);
        response.setData(savedSample);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @PostMapping(path = {"/email"}, name = "email-post", produces = "application/json")
    public ResponseEntity<HttpResponse> postEmail(HttpServletRequest request, @RequestBody Email bodyEmail) throws AddressException, MessagingException, IOException {
        String logPrefix = request.getRequestURI();
        HttpResponse response = new HttpResponse(request.getRequestURI());
        Logger.application.info(Logger.pattern, AssesmentApplication.VERSION, logPrefix, "", "");

        if (null == bodyEmail.getEmail()) {
            Logger.application.info(Logger.pattern, AssesmentApplication.VERSION, logPrefix, " EMAIL IS NULL ");
            response.setStatus(HttpStatus.BAD_REQUEST);
            response.setError("Receiver Email is empty");
            return ResponseEntity.status(response.getStatus()).body(response);
        }

        if (null == bodyEmail.getContent()) {
            Logger.application.info(Logger.pattern, AssesmentApplication.VERSION, logPrefix, " CONTENT IS NULL ");
            response.setStatus(HttpStatus.BAD_REQUEST);
            response.setError("Email Content is empty");
            return ResponseEntity.status(response.getStatus()).body(response);
        }

        emailService.sendmail(bodyEmail.getEmail(), bodyEmail.getSubject(), bodyEmail.getContent());

        response.setStatus(HttpStatus.OK);
        response.setData("Email Sent Sucessfully");
        return ResponseEntity.status(response.getStatus()).body(response);

    }

}
