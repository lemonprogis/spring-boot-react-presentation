package com.lemonprogis.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import com.lemonprogis.model.DecryptRequest;
import com.lemonprogis.model.EncryptRequest;
import com.lemonprogis.service.EncryptService;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
public class EncryptServiceTests {

    @Test
    public void encryptAndDecryptMethods() {
        // arrange
        String secret = "TestSecret";
        String toEncrypt = "Iampassword";
        EncryptService encryptService = new EncryptService();

        // act
        String encryptedValue = encryptService.encrypt(new EncryptRequest(secret, toEncrypt));
        String decryptedValue = encryptService.decrypt(new DecryptRequest(secret, encryptedValue));

        // assert
        assertThat(encryptedValue).isNotEmpty();
        assertThat(decryptedValue).isEqualTo(toEncrypt);
    }

    @Test
    public void test() {}
}
