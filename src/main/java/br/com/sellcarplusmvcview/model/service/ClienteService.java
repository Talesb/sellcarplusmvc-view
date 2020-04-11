package br.com.sellcarplusmvcview.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.sellcarplusmvcview.model.negocio.Cliente;

@Service
public class ClienteService {

	@Autowired
	private RestTemplate restTemplate;

	public List<Cliente> findAll() {
		return (List<Cliente>) this.restTemplate.getForObject("http://localhost:8080/api/cliente", List.class);
	}

	public Cliente findById(long id) {
		return this.restTemplate.getForObject("http://localhost:8080/api/cliente/"+id, Cliente.class);
		 
	}

	public void delete(long id) {
		this.restTemplate.delete("http://localhost:8080/api/cliente/{id}", id);	
	}

	public void save(Cliente cliente) {
		this.restTemplate.postForEntity("http://localhost:8080/api/cliente", cliente, String.class);		
	}
}
