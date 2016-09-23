package Repositorio.trabalho_1.minicurso;

import Repositorio.trabalho_1.Situacao;
import Repositorio.trabalho_1.Submissao;
import java.util.ArrayList;
import java.util.List;
import static Repositorio.trabalho_1.minicurso.InOut.*;

/**
 * Classe que auxilia na entrada de informações
 *
 * @author gilis
 */
public class PreencheSubmissao {

    /**
     *
     * @return String contendo o que foi inserido pelo usuario
     */
    public static String preencheTitulo() {
        InOut.div();
        return InOut.inString("Digite o titulo: ");
    }

    /**
     *
     * @param nroAutores int do numero de autores a serem adicionados no List
     * @return List<String> do que foi inserido pelo usuário
     */
    public static List<String> preencheAutores(int nroAutores) {
        List<String> autores = new ArrayList();

        InOut.div();

        for (int i = 0; i < nroAutores; i++) {
            autores.add(inString("Digite o nome do autor " + i + ": "));
        }
        return autores;
    }

    /**
     *
     * @return int contendo o que foi inserido pelo usuario
     */
    public static Situacao preencheSituacao() {
        int nSituacao = 0;

        InOut.div();
        while (nSituacao < 1 || nSituacao > 3) {
            nSituacao = InOut.inInt("Digite a situação do minicurso:"
                    + "\n 1 - Sob Avaliação"
                    + "\n 2 - Aprovado"
                    + "\n 3 - Não aprovado");
        }
        String pSituacao = situacaoToString(nSituacao);
        Situacao s;
        s = Submissao.verificaSituacao(pSituacao);
        return s;
    }

    /**
     *
     * @return String contendo o que foi inserido pelo usuario
     */
    public static String preencheResumo() {
        InOut.div();
        return InOut.inString("Digite o resumo:");
    }

    /**
     *
     * @return String contendo o que foi inserido pelo usuario
     */
    public static String preencheAbstrac() {
        InOut.div();
        return InOut.inString("Digite o abstract: ");
    }

    /**
     *
     * @return String contendo o que foi inserido pelo usuario
     */
    public static String preencheMetodologia() {
        InOut.div();
        return InOut.inString("Digite a metodologia: ");
    }

    /**
     *
     * @return String contendo o que foi inserido pelo usuario
     */
    public static String preencheRecursos() {
        InOut.div();
        return InOut.inString("Digite os recursos:");
    }

    /**
     *
     * @return int contendo o que foi inserido pelo usuario
     */
    public static int preencheDuracao() {
        int h = -1, m = -1;
        InOut.div();
        System.out.println("Digite a duração a seguir, seguindo conforme exigido:");
        while (h < 0 || h > 24) {
            h = InOut.inInt("Digite o numero de horas:");
        }
        while (m < 0 || m > 60) {
            m = InOut.inInt("Digite os minutos:");
        }
        return h * 60 + m;
    }

    /**
     * Metodo que recebe a situacao em int por parametro e devolve uma String da
     * situacao
     *
     * @param situacao int da situação, que deve ser: 1 - para sob avaliação, 2
     * - para aprovado, 3 - para nao aprovado
     * @return String da situação (sob avaliacao, aprovado ou reprovado
     */
    public static String situacaoToString(int situacao) {
        String pSituacao;
        switch (situacao) {
            case 1:
                pSituacao = "sob avaliacao";
                break;
            case 2:
                pSituacao = "aprovado";
                break;
            case 3:
                pSituacao = "reprovado";
                break;
            default:
                pSituacao = "sob avaliacao";
        }
        return pSituacao;
    }

}
