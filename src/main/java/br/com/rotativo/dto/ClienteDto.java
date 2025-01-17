package br.com.rotativo.dto;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.Date;

import br.com.rotativo.dominio.Cliente;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ClienteDto {

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
	private Boolean clienteAtivo;
	
	public ClienteDto(Cliente cadastre) {
		this.data = cadastre.getData();
		this.nome = cadastre.getNome();
		this.telefone = cadastre.getTelefone();
		this.marca = cadastre.getMarca();
		this.modelo = cadastre.getModelo();
		this.anoModelo = cadastre.getAnoModelo();
		this.placa = cadastre.getPlaca();
		this.horaEntrada = cadastre.getHoraEntrada();
		this.horaSaida = cadastre.getHoraSaida();
		this.valor = cadastre.getValor();
		this.clienteAtivo = cadastre.getClienteAtivo();
	}
}
