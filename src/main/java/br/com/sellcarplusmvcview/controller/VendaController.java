package br.com.sellcarplusmvcview.controller;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.sellcarplusmvcview.dto.VendaDTO;
import br.com.sellcarplusmvcview.model.service.ClienteService;
import br.com.sellcarplusmvcview.model.service.VeiculoService;
import br.com.sellcarplusmvcview.model.service.VendaService;

@Controller
public class VendaController {

	@Autowired
	private VendaService service;

	@Autowired
	private ClienteService clienteService;

	@Autowired
	private VeiculoService veiculoService;

	@RequestMapping(value = "/vendas", method = RequestMethod.GET)
	public String showLista(Model model) {
		model.addAttribute("vendas", service.findAll());
		return "venda/lista";
	}

	@RequestMapping(value = "/venda", method = RequestMethod.GET)
	public String showDetalhe(Model model) {
		model.addAttribute("clientes", clienteService.findAll());
		model.addAttribute("veiculos",
				veiculoService.findAll().stream().filter(veiculo -> !veiculo.isVendido()).collect(Collectors.toList()));
		return "venda/detalhe";
	}

	@RequestMapping(value = "/venda", method = RequestMethod.POST)
	public String incluir(Model model, VendaDTO venda) throws Exception {
		service.save(venda);
		return this.showLista(model);
	}

	@RequestMapping(value = "/venda/{id}", method = RequestMethod.GET)
	public String excluir(Model model, @PathVariable Integer id) {
		service.delete(id);
		return this.showLista(model);
	}

}