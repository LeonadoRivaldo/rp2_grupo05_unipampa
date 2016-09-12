package Repositorio.trabalho_1.minicurso;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe que auxilia na entrada de informações
 * @author gilis
 */
public class PreencheMinicurso {

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
     * @return List<String> do que foi inserido pelo usuário 
     */
    public static List<String> preencheAutores() {
        int nAutores = 0;
        List<String> autores = new ArrayList();

        InOut.div();
        while (nAutores < 1 || nAutores > 3) {
            nAutores = InOut.inInt("Digite o numero de autores (maximo 3):");
        }

        autores.add(InOut.inString("Digite o nome do autor:"));
        if (nAutores >= 2) {
            autores.add(InOut.inString("Digite o nome do autor 2:"));
        }
        if (nAutores == 3) {
            autores.add(InOut.inString("Digite o nome do autor 3:"));
        }

        return autores;
    }

    /**
     * 
     * @return int contendo o que foi inserido pelo usuario 
     */
    public static int preencheSituacao() {
        int nSituacao = 0;

        InOut.div();
        while (nSituacao < 1 || nSituacao > 3) {
            nSituacao = InOut.inInt("Digite a situação do minicurso:"
                    + "\n 1 - Sob Avaliação"
                    + "\n 2 - Aprovado"
                    + "\n 3 - Não aprovado");
        }
        return nSituacao;
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
        return h*60 + m;
    }

}
