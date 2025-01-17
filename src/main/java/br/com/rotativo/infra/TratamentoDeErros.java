package br.com.rotativo.infra;

import java.util.NoSuchElementException;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.rotativo.dto.MensagemDeErros;
import br.com.rotativo.dto.ValidarCampos;
import jakarta.validation.ConstraintViolationException;

@ControllerAdvice
public class TratamentoDeErros {

	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<MensagemDeErros>objetoNaoEncontrado(){
		var mensagem = new MensagemDeErros(HttpStatus.NOT_FOUND, "Objeto não encontrado!");
		return new ResponseEntity<>(mensagem,HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<MensagemDeErros>placaJaCadastrada(){ 
		var msg = new MensagemDeErros(HttpStatus.CONFLICT, "Placa já cadastrada!");
		return new ResponseEntity<>(msg,HttpStatus.CONFLICT);
	}
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?>validandoCampos(MethodArgumentNotValidException ex){
		var validar = ex.getFieldErrors();
		return ResponseEntity.badRequest().body(validar.stream().map(ValidarCampos::new).toList());
	}
	
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<MensagemDeErros>placaInválida(){
		var erroPlaca = new MensagemDeErros(HttpStatus.BAD_REQUEST, "Placa inválida,deve ter 7 caracteres!");
		return new ResponseEntity<>(erroPlaca,HttpStatus.BAD_REQUEST);
	}
}
