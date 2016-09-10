package Repositorio.trabalho_1.palestra;

import Repositorio.trabalho_1.Situacao;
import Repositorio.trabalho_1.Submissao;
import java.util.ArrayList;
import java.util.Scanner;

public class ControleDePalestras {

    ArrayList<Palestra> palestras = new ArrayList<Palestra>();

    /**
     * Metodo para criar e incluir uma Palestra, onde é adicionado um objeto na lista palestras.
     *
     * @param p
     */
    public void incluir(Palestra p) {
        palestras.add(p);
    }

    /**
     * Metodo para excluir uma palestra, onde é excluido atraves do indice
     *
     * @param indice
     */
    public void excluir(int indice) {
        palestras.remove(indice);
    }

    /**
     * Metodo para editar uma palestra, onde o usuario vai escolher pelo indice o atributo que ele quer editar.
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
                situacao = Submissao.verificaSituacao(valor);
                while (situacao == null) {
                    System.out.println("Situacao da Palestra: Aprovado/Reprovado/SobA valiacao");
                    situacao = Submissao.verificaSituacao(entrada.nextLine());
                }
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
/**
 * Metodo para consultar uma palestra, onde reotrna a lista de palestra pelo indice.
 * @param indice
 * @return 
 */
    public Palestra consultar(int indice) {
        return palestras.get(indice);
    }

}
