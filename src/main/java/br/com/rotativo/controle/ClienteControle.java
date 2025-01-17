package br.com.rotativo.controle;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.rotativo.dto.AtualizarDto;
import br.com.rotativo.dto.CadastrarClienteDto;
import br.com.rotativo.dto.ClienteDto;
import br.com.rotativo.servico.ClienteServico;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/rotativo")
@RequiredArgsConstructor
public class ClienteControle {
	
	private final ClienteServico servico;
	
	
	@PostMapping
	@Operation(summary = "Endpoint responsável por cadastrar clientes.") 
    @ApiResponse(responseCode = "201",description = " sucesso",content = {
   	@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })           
	public ResponseEntity<CadastrarClienteDto>cadastrarCliente(@RequestBody @Valid CadastrarClienteDto cadastrarClienteDto){
		var cadastro = servico.cadastrarCliente(cadastrarClienteDto);
		var uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
		.buildAndExpand(cadastro.getId()).toUri();
		return ResponseEntity.created(uri).body(new CadastrarClienteDto(cadastro));
	}

	
	@GetMapping("/nomes")
	@Operation(summary = "Endpoint responsável por buscar clientes pelo nome ou parte deles.") 
    @ApiResponse(responseCode = "200",description = " sucesso",content = {
   	@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })           
	public ResponseEntity<List<ClienteDto>>buscaPorNome(@RequestParam(name = "nome")String nome){
		var buscar = servico.buscarPorNome(nome);
		return ResponseEntity.ok().body(buscar.stream().map(ClienteDto::new).toList());
	}
	
	
	@GetMapping
	@Operation(summary = "Endpoint responsável por buscar todos os clientes.") 
    @ApiResponse(responseCode = "200",description = " sucesso",content = {
   	@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })           
	public ResponseEntity<List<ClienteDto>>listarClientes(){
		var lista = servico.buscarClientes();
		return ResponseEntity.ok().body(lista.stream().map(ClienteDto::new).toList());
	}
	
	
	@GetMapping("/placas")
	@Operation(summary = "Endpoint responsável por buscar veículo pela placa ou parte dela.") 
    @ApiResponse(responseCode = "200",description = " sucesso",content = {
   	@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })           
	public ResponseEntity<ClienteDto>buscarPorPlaca(@RequestParam(name = "placa") String placa){
		var buscaPlaca = servico.buscarPorPlaca(placa);
		return ResponseEntity.ok().body(new ClienteDto(buscaPlaca));
	}
	
	
	@PutMapping
	@Operation(summary = "Endpoint responsável por atualizar clientes.") 
    @ApiResponse(responseCode = "200",description = " sucesso",content = {
   	@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })           
	public ResponseEntity<CadastrarClienteDto>atualizarCliente(@RequestBody AtualizarDto atualizarDto){
		var atualizar = servico.atualizarCliente(atualizarDto);
		return ResponseEntity.ok().body(new CadastrarClienteDto(atualizar));
	}
	
	
	@GetMapping("/{id}")
	@Operation(summary = "Endpoint responsável por buscar cliente pelo id.") 
    @ApiResponse(responseCode = "200",description = " sucesso",content = {
   	@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })           
	public ResponseEntity<ClienteDto>buscarPorId(@PathVariable Long id){
		var buscando = servico.buscarPorId(id);
		return ResponseEntity.ok().body(new ClienteDto(buscando));
	}
	
	@DeleteMapping("{id}")
	@Operation(summary = "Endpoint responsável por excluir cliente pelo id.") 
    @ApiResponse(responseCode = "204",description = " sucesso",content = {
   	@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })           
	public ResponseEntity<Void>excluirClientes(@PathVariable Long id){
		servico.excluirClientes(id);
		return ResponseEntity.noContent().build();
	}
	
	
	@DeleteMapping("/inativar/{id}")
	@Operation(summary = "Endpoint responsável por ocultar cliente pelo id.") 
    @ApiResponse(responseCode = "204",description = " sucesso",content = {
   	@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })           
	public ResponseEntity<Void>desativarCliente(@PathVariable Long id){
		servico.desativarCliente(id);
		return ResponseEntity.noContent().build();
		
	}
	
	@PutMapping("/ativat/{id}")
	@Operation(summary = "Endpoint responsável por tornar o cliente novamente visível nas rotas GET, passando o id como parâmetro.") 
    @ApiResponse(responseCode = "200",description = " sucesso",content = {
   	@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })           
	public ResponseEntity<Void>ativarCliente(@PathVariable Long id){		
		servico.ativarCliente(id);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("/ativos")
	@Operation(summary = "Endpoint responsável por buscar os clientes que não estão ocultos.") 
    @ApiResponse(responseCode = "200",description = " sucesso",content = {
   	@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })           
	public ResponseEntity<List<ClienteDto>>buscarClientesAtivos(){
		var buscarAtivos = servico.listarClientesAtivos();
		return ResponseEntity.ok().body(buscarAtivos.stream().map(ClienteDto::new).toList());
	}
	
	
}
