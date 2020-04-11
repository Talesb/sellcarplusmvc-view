package br.com.sellcarplusmvcview.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.sellcarplusmvcview.dto.VendaDTO;
import br.com.sellcarplusmvcview.model.negocio.Venda;

@Service
public class VendaService {

	@Autowired
	private RestTemplate restTemplate;

	public List<Venda> findAll() {
		return (List<Venda>) this.restTemplate.getForObject("http://localhost:8080/api/venda", List.class);
	}

	public Venda findById(long id) {
		return this.restTemplate.getForObject("http://localhost:8080/api/venda/" + id, Venda.class);
	}

	public void delete(long id) {
		this.restTemplate.delete("http://localhost:8080/api/venda/{id}", id);
	}

	public void save(VendaDTO vendaDTO) throws Exception {
		this.restTemplate.postForEntity("http://localhost:8080/api/venda", vendaDTO, String.class);
	}

}
