package br.com.sellcarplusmvcview.model.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.sellcarplusmvcview.model.negocio.Caminhao;
import br.com.sellcarplusmvcview.model.negocio.Carro;
import br.com.sellcarplusmvcview.model.negocio.Moto;
import br.com.sellcarplusmvcview.model.negocio.Veiculo;

@Service
public class VeiculoService {

	@Autowired
	private RestTemplate restTemplate;

	public List<Veiculo> findAll() {

		return this.restTemplate.exchange("http://localhost:8080/api/veiculo", HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Veiculo>>() {
				}).getBody();

	}

	public List<Moto> findAllMotos() {
		return this.restTemplate.exchange("http://localhost:8080/api/veiculo/motos", HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Moto>>() {
				}).getBody();

	}

	public List<Caminhao> findAllCaminhoes() {
		return this.restTemplate.exchange("http://localhost:8080/api/veiculo/caminhoes", HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Caminhao>>() {
				}).getBody();
	}

	public List<Carro> findAllCarros() {
		return this.restTemplate.exchange("http://localhost:8080/api/veiculo/carros", HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Carro>>() {
				}).getBody();
	}

	public Veiculo findById(long id) {
		return this.restTemplate.getForObject("http://localhost:8080/api/veiculo/" + id, Veiculo.class);
	}

	public void delete(long id) {
		this.restTemplate.delete("http://localhost:8080/api/veiculo/{id}", id);
	}

	public <T extends Veiculo> void save(T veiculo) {
		if (veiculo instanceof Carro) {
			this.restTemplate.postForEntity("http://localhost:8080/api/veiculo/carro", veiculo, String.class);
		}
		if (veiculo instanceof Moto) {
			this.restTemplate.postForEntity("http://localhost:8080/api/veiculo/moto", veiculo, String.class);
		}
		if (veiculo instanceof Caminhao) {
			this.restTemplate.postForEntity("http://localhost:8080/api/veiculo/caminhao", veiculo, String.class);
		}
	}
}
