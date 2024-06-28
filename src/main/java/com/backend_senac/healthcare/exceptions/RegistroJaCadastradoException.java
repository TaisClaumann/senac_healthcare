package com.backend_senac.healthcare.exceptions;

import com.backend_senac.healthcare.utils.MessageBundle;

public class RegistroJaCadastradoException extends RuntimeException {

    public RegistroJaCadastradoException(String objeto, Long id) {
        super(MessageBundle.getMessage("exception.RegistroJaCadastrado", objeto, id));
    }
}
