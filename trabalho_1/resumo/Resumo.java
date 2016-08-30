package Repositorio.trabalho_1.resumo;
import java.util.ArrayList;

public class Resumo {

    private String titulo;
    private int situacao;
    private String autor;
    private String instituicao;

    private ArrayList<String> palavrachave = new ArrayList<>();

    public Resumo(String titulo, int Situação, String autor, String instituição, ArrayList<String> palavrachave) {
        this.titulo = titulo;
        this.situacao = Situação;
        this.autor = autor;
        this.instituicao = instituição;
        this.palavrachave = palavrachave;

    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getSituacao() {
        return situacao;
    }

    public void setSituacao(int Situação) {
        this.situacao = Situação;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(String instituição) {
        this.instituicao = instituição;
    }

    //void remove(ArrayList<Resumo> resumo) {
    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    /**
     * @return the palavrachave
     */
    public ArrayList<String> getPalavrachave() {
        return palavrachave;
    }

    /**
     * @param palavrachave the palavrachave to set
     */
    public void setPalavrachave(ArrayList<String> palavrachave) {
        this.palavrachave = palavrachave;
    }
}
