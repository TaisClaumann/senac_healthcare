package com.backend_senac.healthcare.exceptions;


import com.backend_senac.healthcare.utils.MessageBundle;

public class ObjetoNaoEncontradoException extends RuntimeException {

    public ObjetoNaoEncontradoException(String objeto, Long id) {
        super(MessageBundle.getMessage("exception.RegistroNaoEncontrado", objeto, id));
    }
}
