package Repositorio.trabalho_1.palestra;

import Repositorio.trabalho_1.Situacao;
import Repositorio.trabalho_1.SubmissaoApresentacao;
import java.util.List;

/**
 *
 * @author luh-l
 */
public class Palestra extends SubmissaoApresentacao {

   
    private String curriculo;
/**
 * 
 * @param curriculo
 * @param resumo
 * @param abstrac
 * @param duracao
 * @param tituloSubmissao
 * @param situacaoSubmissao
 * @param autores
 * @param MAX_AUTORES 
 */
    public Palestra(String curriculo, String resumo, String abstrac, int duracao, String tituloSubmissao, Situacao situacaoSubmissao, List<String> autores, int MAX_AUTORES) {
        super(resumo, abstrac, duracao, tituloSubmissao, situacaoSubmissao, autores, MAX_AUTORES);
        this.curriculo = curriculo;
    }
   
    public String getCurriculo() {
        return curriculo;
    }

    public void setCurriculo(String curriculo) {
        this.curriculo = curriculo;
    }
public String toString() {
        String string = "";
        string += "\ncurriculo" + getCurriculo();
        return string;
    }
}
