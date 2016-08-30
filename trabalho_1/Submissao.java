/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho_1;

/**
 *
 * @author leona_000
 */
public abstract class Submissao {
    
    
    protected String tituloSubmissao;
    protected Situacao situacaoSubmissao;
    
    
    
    protected enum Situacao{};
    
    
    
    /**
     * Estruturoda "\nNomeDoAtributo: " + atributo 
     * @return 
     */
    public String toString(){
        return "\nTitulo: " + tituloSubmissao + "\nSituacao: " + situacaoSubmissao.name();
    }
    
}
