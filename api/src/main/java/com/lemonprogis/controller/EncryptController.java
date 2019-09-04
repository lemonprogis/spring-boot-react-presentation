package com.lemonprogis.controller;

import lombok.AllArgsConstructor;
import com.lemonprogis.model.DecryptRequest;
import com.lemonprogis.model.EncryptRequest;
import com.lemonprogis.service.EncryptService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class EncryptController {

    private final EncryptService encryptService;

    @PostMapping("/encrypt")
    public ResponseEntity<String> encrypt(@RequestBody EncryptRequest encryptRequest) {
        return ResponseEntity.ok(
                encryptService.encrypt(encryptRequest)
        );
    }

    @PostMapping("/decrypt")
    public ResponseEntity<String> decrypt(@RequestBody DecryptRequest decryptRequest) {
        return ResponseEntity.ok(
                encryptService.decrypt(decryptRequest)
        );
    }
}
