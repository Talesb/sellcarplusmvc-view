package br.com.sellcarplusmvcview.model.negocio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.sellcarplusmvcview.dto.VendaDTO;

public class Venda {

	private long id;

	private Date dataRetirada;

	private double valorTotal;
	private double porcentagemDesconto;

	private Cliente cliente;

	private List<Veiculo> veiculos;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDataRetirada() {
		return dataRetirada;
	}

	public void setDataRetirada(Date dataRetirada) {
		this.dataRetirada = dataRetirada;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public double getPorcentagemDesconto() {
		return porcentagemDesconto;
	}

	public void setPorcentagemDesconto(double porcentagemDesconto) {
		this.porcentagemDesconto = porcentagemDesconto;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Veiculo> getVeiculos() {
		return veiculos;
	}

	public void setVeiculos(List<Veiculo> veiculos) {
		this.veiculos = veiculos;
	}

	public void adicionarVeiculo(Veiculo veiculo) {
		if (this.getVeiculos() == null) {
			this.veiculos = new ArrayList<Veiculo>();
		}

		veiculo.setVendido(true);
		this.veiculos.add(veiculo);

	}

	public static Venda fromDTO(VendaDTO dto) {
		Venda venda = new Venda();
		if (dto.getDataRetirada() != null) {
			venda.setDataRetirada(dto.getDataRetirada());
		}
		if (dto.getPorcentagemDesconto() != null) {
			venda.setPorcentagemDesconto(dto.getPorcentagemDesconto());
		}

		return venda;
	}

	@Override
	public String toString() {
		return "Venda [id=" + id + ", dataRetirada=" + dataRetirada + ", valorTotal=" + valorTotal
				+ ", porcentagemDesconto=" + porcentagemDesconto + ", cliente=" + cliente + ", veiculos=" + veiculos
				+ "]";
	}

}
