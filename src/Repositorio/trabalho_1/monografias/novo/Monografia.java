/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositorio.trabalho_1.monografias.novo;

import Repositorio.trabalho_1.Situacao;
import Repositorio.trabalho_1.SubmissaoCientifica;
import java.util.List;

/**
 *
 * @author leona_000
 */
public class Monografia extends SubmissaoCientifica {

    //private String tipo;
    protected Tipo tipo;
    private String orientador;
    private String curso;
    private int ano;
    private int numeroDePaginas;
    private String resumo;
    private String Abstract;

    /**
     *
     * @param orientador
     * @param curso
     * @param ano
     * @param numeroDePaginas
     * @param resumo
     * @param Abstract
     * @param tituloSubmissao
     * @param situacaoSubmissao
     * @param autores
     * @param MAX_AUTORES
     * @param instituicoes
     * @param palavrasChave
     * @param MAX_PALAVRASCHAVES
     * @param MAX_INSTITUICOES
     */
    public Monografia(Tipo tipo, String orientador, String curso, int ano, int numeroDePaginas, String resumo, String Abstract, String tituloSubmissao, Situacao situacaoSubmissao, List<String> autores, int MAX_AUTORES, List<String> instituicoes, List<String> palavrasChave, int MAX_PALAVRASCHAVES, int MAX_INSTITUICOES) {
        super(tituloSubmissao, situacaoSubmissao, autores, MAX_AUTORES, instituicoes, palavrasChave, MAX_PALAVRASCHAVES, MAX_INSTITUICOES);
        this.orientador = orientador;
        this.curso = curso;
        this.ano = ano;
        this.numeroDePaginas = numeroDePaginas;
        this.resumo = resumo;
        this.Abstract = Abstract;
        this.tipo = tipo;

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

    /**
     * @return the tipo
     */
    public Tipo getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public String toString() {
        String str = "";
        str += super.toString();
        str += "\nTipo: " + tipo.getNome();
        str += "\nOrientador: " + orientador;
        str += "\nCurso: " + curso;
        str += "\nAno: " + ano;
        str += "\nNumero De Paginas: " + numeroDePaginas;
        str += "\nResumo: " + resumo;
        str += "\nAbstract: " + Abstract;
        return str;
    }
}
