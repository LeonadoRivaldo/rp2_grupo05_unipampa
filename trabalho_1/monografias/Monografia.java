/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho_1.monografias;

/**
 *
 * @author leona_000
 */
public class Monografia {

    //atributos
    private String titulo;
    private String situacao = "Sob avaliação";
    private String tipo;
    private String autor;
    private String instituicao;
    private String orientador;
    private String curso;
    private int ano;
    private int numeroDePaginas;
    private String[] palavrasChaves;
    private String resumo;
    private String Abstract;
    
    /**
     * construtor simples 
     */
    public Monografia(){
    }
    
    /**
     * construtur completo
     * @param titulo
     * @param tipo
     * @param autor
     * @param instituicao
     * @param orientador
     * @param curso
     * @param ano
     * @param numeroDePaginas
     * @param palavrasChaves
     * @param resumo
     * @param Abstract 
     */
    public Monografia(String titulo, String tipo, String autor, String instituicao, String orientador, String curso, int ano, int numeroDePaginas, String[] palavrasChaves, String resumo, String Abstract) {
        this.titulo = titulo;
        this.tipo = tipo;
        this.autor = autor;
        this.instituicao = instituicao;
        this.orientador = orientador;
        this.curso = curso;
        this.ano = ano;
        this.numeroDePaginas = numeroDePaginas;
        this.palavrasChaves = palavrasChaves;
        this.resumo = resumo;
        this.Abstract = Abstract;
    }

    /**
     * Recupera a informação do titulo da monografia
     *
     * @return uma string que contem o titulo
     */
    public String getTitulo() {
        return this.titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return the situacao
     */
    public String getSituacao() {
        return situacao;
    }

    /**
     * @param situacao the situacao to set
     */
    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the autor
     */
    public String getAutor() {
        return autor;
    }

    /**
     * @param autor the autor to set
     */
    public void setAutor(String autor) {
        this.autor = autor;
    }

    /**
     * @return the instituicao
     */
    public String getInstituicao() {
        return instituicao;
    }

    /**
     * @param instituicao the instituicao to set
     */
    public void setInstituicao(String instituicao) {
        this.instituicao = instituicao;
    }

    /**
     * @return the orientador
     */
    public String getOrientador() {
        return orientador;
    }

    /**
     * @param orientador the orientador to set
     */
    public void setOrientador(String orientador) {
        this.orientador = orientador;
    }

    /**
     * @return the curso
     */
    public String getCurso() {
        return curso;
    }

    /**
     * @param curso the curso to set
     */
    public void setCurso(String curso) {
        this.curso = curso;
    }

    /**
     * @return the ano
     */
    public int getAno() {
        return ano;
    }

    /**
     * @param ano the ano to set
     */
    public void setAno(int ano) {
        this.ano = ano;
    }

    /**
     * @return the numeroDePaginas
     */
    public int getNumeroDePaginas() {
        return numeroDePaginas;
    }

    /**
     * @param numeroDePaginas the numeroDePaginas to set
     */
    public void setNumeroDePaginas(int numeroDePaginas) {
        this.numeroDePaginas = numeroDePaginas;
    }

    /**
     * @return the palavrasChaves
     */
    public String[] getPalavrasChaves() {
        return palavrasChaves;
    }

    /**
     * @param palavrasChaves the palavrasChaves to set
     */
    public void setPalavrasChaves(String[] palavrasChaves) {
        this.palavrasChaves = palavrasChaves;
    }

    /**
     * @return the resumo
     */
    public String getResumo() {
        return resumo;
    }

    /**
     * @param resumo the resumo to set
     */
    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    /**
     * @return the Abstract
     */
    public String getAbstract() {
        return Abstract;
    }

    /**
     * @param Abstract the Abstract to set
     */
    public void setAbstract(String Abstract) {
        this.Abstract = Abstract;
    }
}
