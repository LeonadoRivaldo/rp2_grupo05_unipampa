/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositorio.trabalho_1.artigos;

import Repositorio.trabalho_1.Situacao;
import Repositorio.trabalho_1.SubmissaoCientificia;
import java.util.List;



/**
 *
 * @author Amanda Lopes
 */
public class Artigo extends SubmissaoCientificia {

     private String Abstract;
    private String resumo;

    /**
     * 
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
    public Artigo(String resumo, String Abstract, String tituloSubmissao, Situacao situacaoSubmissao, List<String> autores, int MAX_AUTORES, List<String> instituicoes, List<String> palavrasChave, int MAX_PALAVRASCHAVES, int MAX_INSTITUICOES) {
        super(tituloSubmissao, situacaoSubmissao, autores, MAX_AUTORES, instituicoes, palavrasChave, MAX_PALAVRASCHAVES, MAX_INSTITUICOES);
        this.resumo = resumo;
        this.Abstract = Abstract;
    }
    
    public String getResumo(){
        return resumo;
    }
    
    public void setResumo(String resumo){
        this.resumo = resumo;
    }
    
    public String getAbstract(){
        return Abstract;
    }
    
    public void setAbstract(String Abstract){
        this.Abstract = Abstract;
    }

   

   
}

