package com.lemonprogis.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import com.lemonprogis.model.DecryptRequest;
import com.lemonprogis.model.EncryptRequest;
import com.lemonprogis.service.EncryptService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
public class EncryptControllerTests {

    @Test
    public void encryptDecryptRequests() {
        // arrange
        String secret = "TestSecret";
        String toEncrypt = "Iampassword";
        EncryptRequest encryptRequest = new EncryptRequest(secret, toEncrypt);
        EncryptService encryptService = new EncryptService();
        EncryptController encryptController = new EncryptController(encryptService);

        // act
        ResponseEntity<String> encryptResponse = encryptController.encrypt(encryptRequest);

        DecryptRequest decryptRequest = new DecryptRequest(secret, encryptResponse.getBody());

        ResponseEntity<String> decryptResponse = encryptController.decrypt(decryptRequest);

        // assert
        assertThat(encryptResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(decryptResponse.getStatusCode()).isEqualTo(HttpStatus.OK);

        assertThat(encryptResponse.getBody()).isEqualTo(decryptRequest.getToDecrypt());
        assertThat(decryptResponse.getBody()).isEqualTo(toEncrypt);
    }
}
