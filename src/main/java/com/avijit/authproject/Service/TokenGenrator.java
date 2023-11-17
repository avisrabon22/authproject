package com.avijit.authproject.Service;

import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.util.Base64;

@Component
public class TokenGenrator {
        private static final SecureRandom secureRandom = new SecureRandom();
        public static String generateRandomString(int length) {
            byte[] randomBytes = new byte[length];
            secureRandom.nextBytes(randomBytes);
            return Base64.getUrlEncoder().withoutPadding().encodeToString(randomBytes);
        }
    }
