package Repositorio.trabalho_1.resumo;

import Repositorio.trabalho_1.Situacao;
import Repositorio.trabalho_1.SubmissaoCientifica;
import java.util.List;


public class Resumo extends SubmissaoCientifica {
    
    /**
     * 
     * @param tituloSubmissao
     * @param situacaoSubmissao
     * @param autores
     * @param MAX_AUTORES
     * @param instituicoes
     * @param palavrasChave
     * @param MAX_PALAVRASCHAVES
     * @param MAX_INSTITUICOES 
     */
    public Resumo(String tituloSubmissao, Situacao situacaoSubmissao, List<String> autores, int MAX_AUTORES, List<String> instituicoes, List<String> palavrasChave, int MAX_PALAVRASCHAVES, int MAX_INSTITUICOES) {
        super(tituloSubmissao, situacaoSubmissao, autores, MAX_AUTORES, instituicoes, palavrasChave, MAX_PALAVRASCHAVES, MAX_INSTITUICOES);
    }
    
     public String toString() {
        
        return super.toString();
    }

}

    