package com.lemonprogis.service;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import com.lemonprogis.model.DecryptRequest;
import com.lemonprogis.model.EncryptRequest;
import org.springframework.stereotype.Service;

@Service
public class EncryptService {

    public String encrypt(EncryptRequest encryptRequest) {
        return encrypt(encryptRequest.getSecret(), encryptRequest.getToEncrypt());
    }

    public String decrypt(DecryptRequest decryptRequest) {
        return decrypt(decryptRequest.getSecret(), decryptRequest.getToDecrypt());
    }

    private String decrypt(String secret, String toDecrypt) {
        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        encryptor.setPassword(secret);
        return encryptor.decrypt(toDecrypt);
    }

    private String encrypt(String secret, String toEncrypt) {
        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        encryptor.setPassword(secret);
        return encryptor.encrypt(toEncrypt);
    }
}
