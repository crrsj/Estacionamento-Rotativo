package br.com.rotativo.dto;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.rotativo.dominio.Cliente;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CadastrarClienteDto {

	
	private Long id;	
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd/MM/yyyy")
	private Date data;
	@NotBlank(message = "não pode estar em branco!")
	private String nome;
	@NotBlank(message = "não pode estar em branco!")
	private String telefone;
	@NotBlank(message = "não pode estar em branco!")
	private String marca;
	@NotBlank(message = "não pode estar em branco!")
	private String modelo;
	private Integer anoModelo;	
	@NotBlank(message = "não pode estar em branco!")
	private String placa;
	@NotNull(message = "não pode estar em branco!")
	private LocalTime horaEntrada;
	@NotNull(message = "não pode estar em branco!")
	private LocalTime horaSaida;
	private BigDecimal valor;
	
	
	public CadastrarClienteDto(Cliente cadastro) {
		this.id = cadastro.getId();
		this.data = cadastro.getData();
		this.nome = cadastro.getNome();
		this.telefone = cadastro.getTelefone();
		this.marca = cadastro.getMarca();
		this.modelo = cadastro.getModelo();
		this.anoModelo = cadastro.getAnoModelo();
		this.placa = cadastro.getPlaca();
		this.horaEntrada = cadastro.getHoraEntrada();
		this.horaSaida = cadastro.getHoraSaida();
		this.valor  = cadastro.getValor();
		
	}
	
}
