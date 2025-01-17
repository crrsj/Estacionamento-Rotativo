package br.com.rotativo.servico;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.rotativo.dominio.Cliente;
import br.com.rotativo.dto.AtualizarDto;
import br.com.rotativo.dto.CadastrarClienteDto;
import br.com.rotativo.repositorio.ClienteRepositorio;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClienteServico {

	private final ClienteRepositorio repositorio;
	
	public Cliente cadastrarCliente(CadastrarClienteDto cadastrarClienteDto) {		
		var cadastrar = new Cliente(cadastrarClienteDto);
		cadastrar.setData(new Date());		
		return repositorio.save(cadastrar);
	}
	
	public List<Cliente>buscarClientes(){
		return repositorio.findAll();
	}
	
	public Cliente buscarPorId(Long id) {
		Optional<Cliente>buscar = repositorio.findById(id);
		return buscar.get();
	}
	
	public Cliente atualizarCliente(AtualizarDto atualizarDto) {
		var atualizar =  new Cliente(atualizarDto);
		return repositorio.save(atualizar);
	}
	
	public List<Cliente>buscarPorNome(String nome){
	 return repositorio.findByNome(nome.trim().toUpperCase());
	}
	
	public Cliente buscarPorPlaca(String placa){
		Optional<Cliente> buscaPlaca = repositorio.findByPlaca(placa.trim().toUpperCase());
		return buscaPlaca.get();
	}
	
	public void excluirClientes(Long id) {
		repositorio.deleteById(id);
	}
	
	@Transactional
	public void desativarCliente(Long id) {
	var buscar  = repositorio.getReferenceById(id);
		buscar.desativar();
		
	}
	
    @Transactional
	public void ativarCliente(Long id) {
		var buscando = repositorio.getReferenceById(id);
		buscando.ativar();
	}
	
	public List<Cliente>listarClientesAtivos(){
		return repositorio.findAllByClienteAtivoTrue();
	}

}
