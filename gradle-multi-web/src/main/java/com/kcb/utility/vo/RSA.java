package com.kcb.utility.vo;

import java.security.PrivateKey;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RSA {
    private PrivateKey privateKey;
    private String modulus;
    private String exponent;
 
}
