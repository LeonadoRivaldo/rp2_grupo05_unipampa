package Repositorio.trabalho_1.palestra;

import Repositorio.trabalho_1.Situacao;
import Repositorio.trabalho_1.Submissao;
import java.util.ArrayList;
import java.util.Scanner;

public class ControleDePalestras {

    ArrayList<Palestra> palestras = new ArrayList<Palestra>();

    /**
     * Metodo para criar e incluir uma Palestra
     *
     * @param p
     */
    public void incluir(Palestra p) {
        palestras.add(p);
    }

    /**
     * Metodo para excluir uma palestra
     *
     * @param indice
     */
    public void excluir(int indice) {
        palestras.remove(indice);
    }

    /**
     * Metodo para editar uma palestra
     *
     * @param indice
     * @param valor
     * @param palestra
     */
    public void editar(int indice, String valor, Palestra palestra) {
        Scanner entrada = new Scanner(System.in);
        /* String titulo,
       String situacao,
       String autor, 
       String resumo,
       String Abstract,
       int duracao,
       String curriculo*/
        switch (indice) {
            case 1:
                palestra.setTituloSubmissao(valor);
                break;
            case 2:
                Situacao situacao = null;
                do {
                    System.out.println("Situacao da Palestra: Aprovado/Reprovado/SobAvaliacao");
                    situacao = Submissao.verificaSituacao(entrada.nextLine());
                } while (situacao == null);
                palestra.setSituacaoSubmissao(Submissao.verificaSituacao(valor));
                break;
            case 3:
                ArrayList<String> vvv = new ArrayList();
                vvv.add(valor);
                palestra.setAutor(vvv);
                break;
            case 4:
                palestra.setResumo(valor);
                break;
            case 5:
                palestra.setAbstrac(valor);
                break;
            case 6:
                palestra.setDuracao(Integer.parseInt(valor));
                break;
            case 7:
                palestra.setCurriculo(valor);
                break;

        }
    }

    public Palestra consultar(int indice) {
        return palestras.get(indice);
    }

}
