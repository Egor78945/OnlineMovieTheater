package org.example.onlinemovietheater.authenticationservice.controller.security;

import lombok.RequiredArgsConstructor;
import org.example.onlinemovietheater.authenticationservice.model.dto.security.request.AuthenticationRequestModel;
import org.example.onlinemovietheater.authenticationservice.service.user.security.AuthenticationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @GetMapping
    public ResponseEntity<String> authenticate(@RequestBody AuthenticationRequestModel authenticationRequestModel) {
        return ResponseEntity.ok(authenticationService.authenticate(authenticationRequestModel));
    }

    @PostMapping
    public ResponseEntity<String> register(@RequestBody AuthenticationRequestModel authenticationRequestModel){
        authenticationService.register(authenticationRequestModel);
        return ResponseEntity.ok("User has been registered");
    }
}
