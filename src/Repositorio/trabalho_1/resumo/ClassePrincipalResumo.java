package Repositorio.trabalho_1.resumo;

import Repositorio.trabalho_1.resumo.ControladorResumo;
import Repositorio.trabalho_1.resumo.ClassePrincipalResumo;
import Repositorio.trabalho_1.SubmissaoCientificia;
import Repositorio.trabalho_1.resumo.Resumo;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClassePrincipalResumo {

    private static ControladorResumo resumo = new ControladorResumo();

    public static void main(String[] args) {
        principal();
    }

    public static String pegarvalor(int indice) {
        Scanner entrada = new Scanner(System.in);

        switch (indice) {
            case 1:
                System.out.println("Qual o novo  titulo");
                return entrada.nextLine();

            case 2:
                System.out.println("Qual o novo autor ");
                return entrada.nextLine();

            case 3:
                System.out.println("Qual a nova instituição");
                return entrada.nextLine();

            case 4:
                System.out.println("Qual a nova palavra chave");
                return entrada.nextLine();
        }
        return null;
    }

    public static void principal() {

        String titulo = null;
        int situacao;
        String autor;
        String instituicao;
        String palavrachave;
        Scanner e = new Scanner(System.in);

        int n = 0;
        do {
            System.out.println("===============================================");
            System.out.println("Índice  de resumos");
            System.out.println("===============================================");
            System.out.println("1)Cadastrar resumo:");
            System.out.println("2)Pesquisar resumo");
            System.out.println("3)deletar resumo");
            System.out.println("4)editar resumo");
            System.out.println("0)sair do programa");
            n = e.nextInt();
            e.nextLine();
            switch (n) {
                case 1:
                    System.out.println("Titulo do resumo :");
                    titulo = e.nextLine();
                    System.out.println("Situação do resumo: 1-Aprovado/2-Reprovado/3-sob avaliação: ");
                    situacao = e.nextInt();
                    e.nextLine();
                    System.out.println("Autor do resumo:");
                    autor = e.nextLine();
                    System.out.println("Instituição do resumo");
                    instituicao = e.nextLine();
                    int opcao;
                    ArrayList<String> palavraschave = new ArrayList();
                    do {
                        System.out.println("Palavras-chaves do resumo: ");
                        palavrachave = e.next();
                        System.out.println("Deseja digitar outras palavras-chave?(1-SIM 2-NÃO)");
                        opcao = e.nextInt();
                        palavraschave.add(palavrachave);
                    } while (opcao != 2);
                    resumo.incluir(titulo, situacao, autor, instituicao, palavraschave);
                    break;
                case 2:
                    System.out.println("Titulo do resumo que deseja pesquisar: ");
                    ControladorResumo.consulta(e.nextLine());
                    break;
                case 3:
                    System.out.println("Digite o titulo do resumo  a ser deletado:");
                    titulo = e.nextLine();
                    if (resumo.excluir(titulo)) {
                        System.out.println("Excluido com sucesso!");
                    } else {
                        System.out.println("Resumo não encontrado");
                    }
                    break;
                case 4:
                // n sei 
                case 0:
                    break;
            }
        } while (n != 0);
    }
}
