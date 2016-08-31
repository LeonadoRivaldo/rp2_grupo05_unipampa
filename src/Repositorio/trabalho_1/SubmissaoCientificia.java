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
public abstract class SubmissaoCientificia extends Submissao {

    protected List<String> instituicoes;
    protected List<String> palavrasChave;
    protected int MAX_PALAVRASCHAVES;
    protected int MAX_INSTITUICOES;

    /**
     * construtor
     * @param tituloSubmissao
     * @param situacaoSubmissao
     * @param autores
     * @param instituicoes
     * @param MAX_AUTORES
     * @param palavrasChave
     * @param MAX_PALAVRASCHAVES
     * @param MAX_INSTITUICOES
     */
    public SubmissaoCientificia(String tituloSubmissao,Situacao situacaoSubmissao,List<String> autores, int MAX_AUTORES,List<String> instituicoes, List<String> palavrasChave, int MAX_PALAVRASCHAVES, int MAX_INSTITUICOES) {
        super(tituloSubmissao, situacaoSubmissao, autores, MAX_AUTORES);
        this.instituicoes = instituicoes;
        this.palavrasChave = palavrasChave;
        this.MAX_PALAVRASCHAVES = MAX_PALAVRASCHAVES;
        this.MAX_INSTITUICOES = MAX_INSTITUICOES;
    }

    /**
     * @return the instituicao
     */
    public List<String> getInstituicao() {
        return instituicoes;
    }

    /**
     * @param instituicoes
     * @return 
     */
    public boolean setInstituicao(List<String> instituicoes) {
        if (instituicoes.size() < this.MAX_INSTITUICOES) {
            this.instituicoes = instituicoes;
            return true;
        }
        return false;
    }

    /**
     * adciona uma nova instituição, se o maximo não foi atingido ainda;
     *
     * @param instituicao
     * @return
     */
    public boolean addInstituicao(String instituicao) {
        if (this.instituicoes.size() < this.MAX_INSTITUICOES) {
            this.instituicoes.add(instituicao);
            return true;
        }
        return false;
    }

    /**
     * @return the palavrasChave
     */
    public List<String> getPalavrasChave() {
        return palavrasChave;
    }

    /**
     * @param palavrasChave the palavrasChave to set
     * @return 
     */
    public boolean setPalavrasChave(List<String> palavrasChave) {
        if (palavrasChave.size() < this.MAX_PALAVRASCHAVES) {
            this.palavrasChave = palavrasChave;
            return true;
        }
        return false;
    }

    /**
     * adciona uma nova palavra chave se o maximo não foi atingido
     *
     * @param palavraChave
     * @return
     */
    public boolean addPalavraChave(String palavraChave) {
        if (this.palavrasChave.size() < this.MAX_PALAVRASCHAVES) {
            this.palavrasChave.add(palavraChave);
            return true;
        }
        return false;
    }

}
