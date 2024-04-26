package miu.cs.ads_datapersisitence.controller;

import miu.cs.ads_datapersisitence.dto.request.LoginRequest;
import miu.cs.ads_datapersisitence.dto.response.LoginResponse;
import miu.cs.ads_datapersisitence.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public LoginResponse login(@RequestBody LoginRequest loginRequest) {
        System.out.println("--------------------------------------------");
        return authService.login(loginRequest);
    }
}