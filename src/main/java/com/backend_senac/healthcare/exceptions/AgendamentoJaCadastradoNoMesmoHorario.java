package com.backend_senac.healthcare.exceptions;

import com.backend_senac.healthcare.utils.MessageBundle;

public class AgendamentoJaCadastradoNoMesmoHorario extends RuntimeException {

    public AgendamentoJaCadastradoNoMesmoHorario(String data) {
        super(MessageBundle.getMessage("exception.AgendamentoJaCadastradoNoMesmoHorario", data));
    }
}
