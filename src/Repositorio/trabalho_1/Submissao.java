/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositorio.trabalho_1;

import Repositorio.trabalho_1.monografias.novo.Tipo;
import java.util.List;

/**
 */
public abstract class Submissao {

    protected String tituloSubmissao;
    protected Situacao situacaoSubmissao;
    protected List<String> autores;
    protected int MAX_AUTORES;

    /**
     * Contrutor das submissoes
     *
     * @param tituloSubmissao titulo da submissao
     * @param situacaoSubmissao situação da submissao
     * @param autores lista de autores
     * @param MAX_AUTORES quantidade maxima de autores por submissao
     */
    public Submissao(String tituloSubmissao, Situacao situacaoSubmissao, List<String> autores, int MAX_AUTORES) {
        this.tituloSubmissao = tituloSubmissao;
        this.situacaoSubmissao = situacaoSubmissao;
        this.autores = autores;
        this.MAX_AUTORES = MAX_AUTORES;
    }

    /**
     * Chama o metodo que verifica a situação das submissões
     *
     * @param situacao
     * @return objeto situação
     */
    public static Situacao verificaSituacao(String situacao) {
        return Situacao.verifica(situacao);
    }

    /**
     * chama o metodo que verifica se o tipo da monografia ta correto
     *
     * @param tipo
     * @return
     */
    public static Tipo verificaTipo(String tipo) {
        return Tipo.verifica(tipo);
    }

    /**
     * @return the tituloSubmissao
     */
    public String getTituloSubmissao() {
        return tituloSubmissao;
    }

    /**
     * @param tituloSubmissao the tituloSubmissao to set
     */
    public void setTituloSubmissao(String tituloSubmissao) {
        this.tituloSubmissao = tituloSubmissao;
    }

    /**
     * @return the situacaoSubmissao
     */
    public Situacao getSituacaoSubmissao() {
        return situacaoSubmissao;
    }

    /**
     * @param situacaoSubmissao the situacaoSubmissao to set
     */
    public void setSituacaoSubmissao(Situacao situacaoSubmissao) {
        this.situacaoSubmissao = situacaoSubmissao;
    }

    /**
     * @return the autor
     */
    public List<String> getAutor() {
        return autores;
    }

    /**
     * @param autores the autor to set
     * @return true quando a lista de autores é menor q o maximo / false quando
     * a lista é maior
     */
    public boolean setAutor(List<String> autores) {
        if (this.MAX_AUTORES >= autores.size()) {
            this.autores = autores;
            return true;
        }
        return false;
    }

    /**
     * Adiciona um autor sempre q lista de autores não estiver cheia
     *
     * @param autor
     * @return
     */
    public boolean addAutor(String autor) {
        if (this.MAX_AUTORES >= this.autores.size()) {
            this.autores.add(autor);
            return true;
        }
        return false;
    }

    public boolean isAutor(String procuraAutor) {
        for (String autor : autores) {
            if (autor.equalsIgnoreCase(procuraAutor)) {
                return true;
            }
        }
        return false;
    }

    /**
     * @return the MAX_AUTORES
     */
    public int getMAX_AUTORES() {
        return MAX_AUTORES;
    }

    /**
     * @param MAX_AUTORES the MAX_AUTORES to set
     */
    public void setMAX_AUTORES(int MAX_AUTORES) {
        this.MAX_AUTORES = MAX_AUTORES;
    }

    /**
     * Estruturoda "\nNomeDoAtributo: " + atributo
     *
     * @return
     */
    @Override
    public String toString() {
        String string = "";
        string += "\nTitulo: " + getTituloSubmissao();
        string += "\nSituacao: " + getSituacaoSubmissao().getNome();
        string += "\nAutores: ";
        for (String s : autores) {
            string += s + ", ";
        }
        return string;
    }

}
