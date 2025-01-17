package br.com.rotativo.dto;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.Date;

import br.com.rotativo.dominio.Cliente;
import jakarta.persistence.Column;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AtualizarDto {

	private Long id;	
	private Date data;
	private String nome;
	private String telefone;
	private String marca;
	private String modelo;
	private Integer anoModelo;		
	private String placa;
	private LocalTime horaEntrada;
	private LocalTime horaSaida;
	private BigDecimal valor;
	
	public AtualizarDto(Cliente atualize) {
		this.id = atualize.getId();
		this.data = atualize.getData();
		this.nome = atualize.getNome();
		this.telefone = atualize.getTelefone();
		this.marca = atualize.getMarca();
		this.modelo = atualize.getModelo();
		this.anoModelo = atualize.getAnoModelo();
		this.placa = atualize.getPlaca();
		this.horaEntrada = atualize.getHoraEntrada();
		this.horaSaida = atualize.getHoraSaida();
		this.valor = atualize.getValor();
	}
}
