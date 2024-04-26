package miu.cs.ads_datapersisitence.controller;

import jakarta.mail.MessagingException;
import miu.cs.ads_datapersisitence.exception.NotFoundException;
import miu.cs.ads_datapersisitence.service.Impl.MailSenderService;
import miu.cs.ads_datapersisitence.service.Impl.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;

@RestController
@RequestMapping(value = "/ads/api/v1/manager")
public class ManagerController {

    @Autowired
    private MailSenderService mailService;

    @Autowired
    ManagerService managerService;

    @PostMapping("/send/{email}")
    public void Foo(@PathVariable String email)  throws MessagingException, UnsupportedEncodingException {
        mailService.sendNewMail(email, "Subject right here", "Body right there!");
    }

    @PostMapping("/approve/{patientId}/{appointmentId}")
    public void approveRequest(@PathVariable Integer patientId, @PathVariable Integer appointmentId) throws NotFoundException {
        managerService.approveRequest(patientId, appointmentId);
    }
}