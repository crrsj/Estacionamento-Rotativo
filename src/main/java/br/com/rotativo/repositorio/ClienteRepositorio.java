package br.com.rotativo.repositorio;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.rotativo.dominio.Cliente;
import br.com.rotativo.dto.CadastrarClienteDto;

public interface ClienteRepositorio extends JpaRepository<Cliente, Long> {
	
	@Query(value = "select c from Cliente c where upper(trim(c.nome)) like %?1% ") 
	List<Cliente> findByNome(String nome);

	@Query(value = "select c from Cliente c where upper(trim(c.placa)) like %?1% ") 
	Optional<Cliente> findByPlaca(String placa);

	List<Cliente> findAllByClienteAtivoTrue();

}
