package trabalho_1.palestra;

/**
 *
 * @author luh-l
 */
public class Palestra {

    private String titulo;
    private String situacao;
    private String autor;
    private String resumo;
    private String Abstract;
    private int duracao;
    private String curriculo;
   

    public Palestra() {

    }
    

    public Palestra(String titulo, String autor, String resumo, String Abstract, int duracao, String curriculo) {
        this.titulo = titulo;
        this.autor = autor;
        this.resumo = resumo;
        this.Abstract = Abstract;
        this.duracao = duracao;
        this.curriculo = curriculo;

    }

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

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public String getabstract() {
        return Abstract;
    }

    public void setabstract(String Abstract) {
        this.Abstract = Abstract;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {  
        this.duracao = duracao;
    }

    public String getCurriculo() {
        return curriculo;
    }

    public void setCurriculo(String curriculo) {
        this.curriculo = curriculo;
    }

}
