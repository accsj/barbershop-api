package org.barbershop.api.utils;

public class ObterPrimeirasPalavras {

    public String primeiroNome(String nomeEmpresarial) {
        String[] palavras = nomeEmpresarial.split("\\s+");
        if (palavras.length > 0) {
            return palavras[0];
        } else {
            return "";
        }
    }

    public String duasPrimeirasLetrasNomeEmpresarial(String nomeEmpresarial) {
        String[] partesNome = nomeEmpresarial.split("\\s+");
        if (partesNome.length > 1) {
            String primeiraPalavra = partesNome[0];
            if (primeiraPalavra.length() >= 2) {
                return primeiraPalavra.substring(0, 2);
            }
        }
        throw new IllegalArgumentException("O nome empresarial não contém duas palavras ou a segunda palavra não possui duas letras");
    }

}
