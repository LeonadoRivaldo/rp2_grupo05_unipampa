/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositorio.trabalho_1;

import java.util.List;

/**
 *
 * @author leona_000
 */
public abstract class Submissao {
    
    
    protected String tituloSubmissao;
    protected Situacao situacaoSubmissao;
    protected List<String> autor;
    protected int MAX_AUTORES;

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
        return autor;
    }

    /**
     * @param autor the autor to set
     */
    public void setAutor(List<String> autor) {
        this.autor = autor;
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
    
    
    
    protected enum Situacao{};
    
    
    
    /**
     * Estruturoda "\nNomeDoAtributo: " + atributo 
     * @return 
     */
    public String toString(){
        return "\nTitulo: " + getTituloSubmissao() + "\nSituacao: " + getSituacaoSubmissao().name();
    }
    
}
