package trabalho_1.resumo;

public class NovoResumo {

	/*
	 * atributos da classe
	 */

	private String titulo;
	private String situacao = "Sob avalia��o";
	private String[] autor;
	private String[] institucao;
	private String[] Palavra_chave;

	/*public NovoResumo(String titulo, String[] autor, String[] institucao,
			String[] Palavra_chave) {
		this.titulo = titulo;
		this.autor = autor;
		this.institucao = institucao;
		this.Palavra_chave = Palavra_chave;
	}*/

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public String[] getAutor() {
		return autor;
	}

	public void setAutor(String[] autor) {
		this.autor = autor;
	}

	public String[] getInstitucao() {
		return institucao;
	}

	public void setInstitucao(String[] institucao) {
		this.institucao = institucao;
	}

	public String[] getPalavra_chave() {
		return Palavra_chave;
	}

	public void setPalavra_chave(String[] palavra_chave) {
		Palavra_chave = palavra_chave;
	}

}
