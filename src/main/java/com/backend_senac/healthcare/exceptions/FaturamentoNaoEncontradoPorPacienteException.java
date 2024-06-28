package com.backend_senac.healthcare.exceptions;

import com.backend_senac.healthcare.utils.MessageBundle;

public class FaturamentoNaoEncontradoPorPacienteException extends RuntimeException {

    public FaturamentoNaoEncontradoPorPacienteException(String paciente) {
        super(MessageBundle.getMessage("exception.FaturamentoNaoEncontradoPorPaciente", paciente));
    }
}
