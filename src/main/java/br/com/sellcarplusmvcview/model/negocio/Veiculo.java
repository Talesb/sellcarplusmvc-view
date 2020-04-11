package br.com.sellcarplusmvcview.model.negocio;

public class Veiculo {

	private long id;
	private int ano;
	private String nome;
	private String cor;
	private int potencia;
	private double preco;
	private String marca;
	private boolean vendido;

	private Venda venda;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public int getPotencia() {
		return potencia;
	}

	public void setPotencia(int potencia) {
		this.potencia = potencia;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public boolean isVendido() {
		return vendido;
	}

	public void setVendido(boolean vendido) {
		this.vendido = vendido;
	}

	public Venda getVenda() {
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}

	@Override
	public String toString() {
		return "Veiculo [id=" + id + ", ano=" + ano + ", nome=" + nome + ", cor=" + cor + ", potencia=" + potencia
				+ ", preco=" + preco + ", marca=" + marca + ", vendido=" + vendido;
	}

}
