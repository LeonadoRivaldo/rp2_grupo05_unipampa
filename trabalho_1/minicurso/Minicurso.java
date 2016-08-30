package trabalho_1.minicurso;

/**
 * Classe para objetos do tipo Minicurso que contem os atributos e operações do
 * mesmo
 *
 */
public class Minicurso {

    private String titulo;
    private String autor;
    private String situacao;
    private String resumo;
    private String abstrac;
    private String recursos;
    private String metodologia;
    private String duracao;

    /**
     * @return retorna o titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo seta o titulo
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return retorna o autor
     */
    public String getAutor() {
        return autor;
    }

    /**
     * @param autor seta o autor
     */
    public void setAutor(String autor) {
        this.autor = autor;
    }

    /**
     * @return retorna a situação
     */
    public String getSituacao() {
        return situacao;
    }

    /**
     * @param situacao seta a situação
     */
    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    /**
     * @return retorna o resumo
     */
    public String getResumo() {
        return resumo;
    }

    /**
     * @param resumo seta o resumo
     */
    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    /**
     * @return retorna o abstract
     */
    public String getAbstrac() {
        return abstrac;
    }

    /**
     * @param abstrac seta o abstract
     */
    public void setAbstrac(String abstrac) {
        this.abstrac = abstrac;
    }

    /**
     * @return retorna os recursos
     */
    public String getRecursos() {
        return recursos;
    }

    /**
     * @param recursos seta os recursos
     */
    public void setRecursos(String recursos) {
        this.recursos = recursos;
    }

    /**
     * @return retorna a metodologia
     */
    public String getMetodologia() {
        return metodologia;
    }

    /**
     * @param metodologia seta a metodologia
     */
    public void setMetodologia(String metodologia) {
        this.metodologia = metodologia;
    }

    /**
     * @return retorna a duração
     */
    public String getDuracao() {
        return duracao;
    }

    /**
     * @param duracao seta a duração
     */
    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }
}
