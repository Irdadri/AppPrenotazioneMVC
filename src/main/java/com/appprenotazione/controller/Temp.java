/* package com.appprenotazione.controller;

import at.favre.lib.crypto.bcrypt.BCrypt;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Temp {
    public static void main(String[] args) throws NoSuchAlgorithmException {
       String hash = BCrypt.withDefaults()
                .hashToString(12, "123".toCharArray());

        System.out.println(hash);

        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] encodedhash = digest.digest(
                "123".getBytes(StandardCharsets.UTF_8));

        StringBuilder hexString = new StringBuilder(2*encodedhash.length);
        for(int i=0; i < encodedhash.length; i++){
            String hex = Integer.toHexString(0xff & encodedhash[i]);
            if(hex.length() == 1){
                hexString.append('0');
            }
            hexString.append(hex);
        }
        System.out.println(hexString.toString());

    }
}
*/