/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositorio.trabalho_1;

import java.util.List;
import java.util.Scanner;

/**
 *
 * @author leona_000
 */
public abstract class interfaceSistema {

    static final Scanner entrada = new Scanner(System.in);

    /**
     * Metodo que carega todos os outros metodos da sessao do sistema
     */
    public abstract void principal();

    /**
     * Metodo para o menu
     *
     * @return
     */
    public abstract int menu();
    
    
    /**
     * 
     * @param submissao objeto de submissao a ser exibido 
     */
    public void exibir(Submissao submissao) {
        System.out.println("====================================================");
        System.out.println(submissao.toString());
        System.out.println("====================================================");
    }

    public abstract int escolherAtributo(Submissao submissao);

    /**
     * faz uma lista por autor
     *
     * @param lista objeto da classe listaSubmissao
     * @param frase string que vai aparecer na interface
     * @return retorna o objeto que o usuario escolheu
     */
    private Submissao listaPorAutor(List<Submissao> submissoes, ListaSubmissoes lista) {
        System.out.println("====================================================");
        for (Submissao submissao : submissoes) {
            System.out.println(submissao.getTituloSubmissao());
        }
        System.out.println("----------------------------------------------------");
        System.out.println("Digite o titulo da monografia a ser exibida: ");
        return lista.consultarTitulo(entrada.nextLine());
    }

}
