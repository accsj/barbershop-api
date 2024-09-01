package org.barbershop.api.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BcryptEncoderUtils {

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public static String criptografarSenha(String senha) {
        return encoder.encode(senha);
    }

    public static boolean compararSenhas(String senhaAntiga, String senhaAtual) {
        return encoder.matches(senhaAntiga, senhaAtual);
    }
}