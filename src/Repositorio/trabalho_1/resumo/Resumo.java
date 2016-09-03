package Repositorio.trabalho_1.resumo;

import Repositorio.trabalho_1.Situacao;
import Repositorio.trabalho_1.SubmissaoCientificia;
import java.util.List;


public class Resumo extends SubmissaoCientificia {

    public Resumo(String tituloSubmissao, Situacao situacaoSubmissao, List<String> autores, int MAX_AUTORES, List<String> instituicoes, List<String> palavrasChave, int MAX_PALAVRASCHAVES, int MAX_INSTITUICOES) {
        super(tituloSubmissao, situacaoSubmissao, autores, MAX_AUTORES, instituicoes, palavrasChave, MAX_PALAVRASCHAVES, MAX_INSTITUICOES);
    }

}

    