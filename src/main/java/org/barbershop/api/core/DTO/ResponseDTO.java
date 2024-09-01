package org.barbershop.api.core.DTO;

import org.springframework.validation.FieldError;

public class ResponseDTO {
    private String mensagem;

    public ResponseDTO(String mensagem) {
        this.mensagem = mensagem;
    }

    public ResponseDTO(FieldError error) {
        this.mensagem = error.getDefaultMessage();
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

}
