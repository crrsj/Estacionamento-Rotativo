package br.com.rotativo.dto;

import org.springframework.http.HttpStatus;

public record MensagemDeErros(HttpStatus status,String mensagem) {

}
