/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositorio.trabalho_1;

/**
 *
 * @author leona_000
 */
public abstract class SubmissaoCientificia extends Submissao {
    
    protected String[] instituicao;
    protected String[] palavrasChave;

    /**
     * @return the instituicao
     */
    public String[] getInstituicao() {
        return instituicao;
    }

    /**
     * @param instituicao the instituicao to set
     */
    public void setInstituicao(String[] instituicao) {
        this.instituicao = instituicao;
    }

    /**
     * @return the palavrasChave
     */
    public String[] getPalavrasChave() {
        return palavrasChave;
    }

    /**
     * @param palavrasChave the palavrasChave to set
     */
    public void setPalavrasChave(String[] palavrasChave) {
        this.palavrasChave = palavrasChave;
    }
    
    
    
    
}
