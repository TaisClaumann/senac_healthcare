package com.backend_senac.healthcare.exceptions;

import com.backend_senac.healthcare.utils.MessageBundle;

public class RegistroNaoEncontradoException extends RuntimeException {

    public RegistroNaoEncontradoException(String objeto, Long id) {
        super(MessageBundle.getMessage("exception.RegistroNaoEncontrado", objeto, "id", id));
    }

    public RegistroNaoEncontradoException(String objeto, String nome) {
        super(MessageBundle.getMessage("exception.RegistroNaoEncontrado", objeto, "", nome));
    }
}
