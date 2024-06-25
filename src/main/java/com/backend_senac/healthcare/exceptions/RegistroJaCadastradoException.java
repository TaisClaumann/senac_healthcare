package com.backend_senac.healthcare.exceptions;

import com.backend_senac.healthcare.utils.MessageBundle;

public class RegistroJaCadastradoException extends RuntimeException {

    public RegistroJaCadastradoException(String msg) {
        super(msg);
    }

    public RegistroJaCadastradoException(String objeto, Long id) {
        super(MessageBundle.getMessage("exception.RegistroJaEncontrado", objeto, id));
    }
}
