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
public abstract class SubmissaoApresentacao extends Submissao {
    
    protected String resumo;
    protected String abstrac;
    protected int duracao;

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
     * @return the abstrac
     */
    public String getAbstrac() {
        return abstrac;
    }

    /**
     * @param abstrac the abstrac to set
     */
    public void setAbstrac(String abstrac) {
        this.abstrac = abstrac;
    }

    /**
     * @return the duracao
     */
    public int getDuracao() {
        return duracao;
    }

    /**
     * @param duracao the duracao to set
     */
    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }
    
    
    
}
