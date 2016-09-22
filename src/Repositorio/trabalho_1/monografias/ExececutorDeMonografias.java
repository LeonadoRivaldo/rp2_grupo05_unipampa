/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositorio.trabalho_1.monografias;

import Repositorio.trabalho_1.Situacao;
import Repositorio.trabalho_1.Submissao;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author leona_000
 */
public class ExececutorDeMonografias {

    ControllerDeMonografias controller = new ControllerDeMonografias();

    /**
     * Mostra as informações da monografia
     *
     * @param monografia recebe um objeto e apresenta as informações dele
     */
    private static void exibir(Monografia monografia) {
        System.out.println("===================================================");
        System.out.println("Titulo: " + monografia.getTituloSubmissao());
        System.out.println("Situacao: " + monografia.getSituacaoSubmissao().getNome());
        System.out.println("Tipo: " + monografia.getTipo().getNome());
        System.out.println("Autor: " + monografia.getAutor().get(0));
        System.out.println("Instituição: " + monografia.getInstituicao().get(0));
        System.out.println("Orientador: " + monografia.getOrientador());
        System.out.println("Curso: " + monografia.getCurso());
        System.out.println("Ano: " + monografia.getAno());
        System.out.println("Numero De Paginas: " + monografia.getNumeroDePaginas());
        System.out.print("Palavras-chaves: ");
        List<String> palavras = monografia.getPalavrasChave();
        for (String palavra : palavras) {
            System.out.print(palavra + ", ");
        }
        System.out.println("\nResumo: " + monografia.getResumo());
        System.out.println("Abstract: " + monografia.getAbstract());
        System.out.println("===================================================");
    }

    /**
     * permite o usuario a selecionar qual atributo ele quer editar
     *
     * @param monografia
     * @return
     */
    private static int editarMonografia(Monografia monografia) {
        Scanner entrada = new Scanner(System.in);
        int in = -1;
        do {
            System.out.println("===================================================");
            System.out.println("1-Titulo: " + monografia.getTituloSubmissao());
            System.out.println("2-Situacao: " + monografia.getSituacaoSubmissao().getNome());
            System.out.println("3-Tipo: " + monografia.getTipo().getNome());
            System.out.println("4-Autor: " + monografia.getAutor().get(0));
            System.out.println("5-Instituição: " + monografia.getInstituicao().get(0));
            System.out.println("6-Orientador: " + monografia.getOrientador());
            System.out.println("7-Curso: " + monografia.getCurso());
            System.out.println("8-Ano: " + monografia.getAno());
            System.out.println("9-Numero De Paginas: " + monografia.getNumeroDePaginas());
            System.out.print("10-Palavras-chaves: ");
            List<String> palavras = monografia.getPalavrasChave();
            for (String palavra : palavras) {
                System.out.print(palavra + ", ");
            }
            System.out.println("");
            System.out.println("11-Resumo: " + monografia.getResumo());
            System.out.println("12-Abstract: " + monografia.getAbstract());
            System.out.println("===================================================");
            System.out.print("Qual atributo você quer editar: ");
            in = entrada.nextInt();
            if (in > 12 || in < 1) {
                msg("digito invalido");
            }
        } while (in > 12 || in < 1);
        return in;
    }

    /**
     * faz uma lista por autor
     *
     * @param autor recebe o autor
     * @param c o controller
     * @param frase string que vai aparecer na interface
     * @return retorna um inteiro com o indice da monografia
     */
    private static Monografia listaPorAutor(ControllerDeMonografias controller, List<Submissao> submissoes) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("====================================================");
        for (Submissao monografia : submissoes) {
            System.out.println(monografia.getTituloSubmissao());
        }
        System.out.println("----------------------------------------------------");
        System.out.println("Digite o titulo da monografia a ser exibida: ");
        return controller.consultar(entrada.nextLine());
    }

    /**
     * Faz pesquisa pelo titulo!
     *
     * @param controller de monografias
     * @param frase string que mostra para o usuario
     * @return objeto monografia ou null se não achar
     */
    private static Monografia consultarMonografia(ControllerDeMonografias controller, String frase) {
        System.out.println("====================================================");
        Scanner entrada = new Scanner(System.in);
        System.out.println(frase);
        return controller.consultar(entrada.nextLine());
    }

    /**
     * cria um objeto de monografia
     *
     * @return objeto monografia
     */
    private static Monografia criaMonografia() {
        String tituloSubmissao = PreencheMonografia.preencheTitulo();
        List<String> autores = PreencheMonografia.preencheAutor();
        Situacao situacaoSubmissao = null;
        do {
            String situacao = PreencheMonografia.preencheSituacao();
            situacaoSubmissao = Submissao.verificaSituacao(situacao);
        } while (situacaoSubmissao == null);
        Tipo tipoMonografia = null;
        do {
            String tipo = PreencheMonografia.preencheTipo();
            tipoMonografia = Submissao.verificaTipo(tipo);
        } while (tipoMonografia == null);

        String instituicao = PreencheMonografia.preencheInstituicao();
        List<String> instituicoes = new ArrayList();
        instituicoes.add(instituicao);
        String orientador = PreencheMonografia.preencheOrientador();
        String curso = PreencheMonografia.preencheCurso();
        int ano = Integer.parseInt(PreencheMonografia.preencheAno());
        int numeroDePaginas = Integer.parseInt(PreencheMonografia.preencheNroPaginas());
        List<String> palavrasChave = PreencheMonografia.preenchePalavrasChaves();
        String resumo = PreencheMonografia.preencheResumo();
        String Abstract = PreencheMonografia.preencheAbstract();

        int MAX_AUTORES = 1;
        int MAX_PALAVRASCHAVES = 4;
        int MAX_INSTITUICOES = 1;
        System.out.println("===============================================");
        Monografia monografia = new Monografia(tipoMonografia, orientador, curso, ano, numeroDePaginas, resumo, Abstract, tituloSubmissao, situacaoSubmissao, autores, MAX_AUTORES, instituicoes, palavrasChave, MAX_PALAVRASCHAVES, MAX_INSTITUICOES);
        return monografia;
    }

    /**
     * função para exibir mensagens no sistema
     *
     * @param s mensagem que vai ser exibida para o usuario
     */
    private static void msg(String s) {
        System.out.println("\n===========================================================\n");
        System.out.println(s.toUpperCase());
        System.out.println("\n===========================================================\n");
    }

    /**
     * cria objetos para colocar na lista
     *
     * @param controle
     */
    private static void baseDeDados(ControllerDeMonografias controle) {
        List<String> palavras = new ArrayList();
        List<String> autor = new ArrayList();
        List<String> institucao = new ArrayList();
        palavras.add("Um");
        palavras.add("Doi");
        palavras.add("tres");
        palavras.add("quatro");
        autor.add("tres");
        institucao.add("quatro");
        String resumo = "Lorem ipsum dolor sit amet, consectetur adipiscing elit\n";
        resumo += "in ligula est, placerat quis maximus vel, imperdiet eu sapien.\n";
        resumo += "Quisque aliquet placerat neque. Aenean auctor lacus sit amet,\n";
        resumo += "enim ultrices, in interdum lacus blandit. Class aptent taciti.\n";
        for (int i = 0; i < 10; i++) {
            controle.incluir(new Monografia(Tipo.graduacao, "Aline", "ES", 2020 + i, i, resumo, resumo + "Abstract" + i, "Leonardo" + i, Situacao.sobAvaliacao, autor, 1, institucao, palavras, 4, 1));

        }
    }

    /**
     * pega o novo valor que o usuario quer para preencher o novo objeto
     *
     * @param atributo
     * @return
     */
    private static String PegarValor(int atributo) {
        switch (atributo) {
            case 1:
                return PreencheMonografia.preencheTitulo();
            case 2:
                return PreencheMonografia.preencheSituacao();
            case 3:
                return PreencheMonografia.preencheTipo();
            case 4:
                List<String> autores = PreencheMonografia.preencheAutor();
                String frase1 = "";
                for (String s : autores) {
                    frase1 += s + "-";
                }
                return frase1;
            case 5:
                return PreencheMonografia.preencheInstituicao();
            case 6:
                return PreencheMonografia.preencheOrientador();
            case 7:
                return PreencheMonografia.preencheCurso();
            case 8:
                return PreencheMonografia.preencheAno();
            case 9:
                return PreencheMonografia.preencheNroPaginas();
            case 10:
                List<String> palavras = PreencheMonografia.preenchePalavrasChaves();
                String frase = "";
                for (String s : palavras) {
                    frase += s + "-";
                }
                return frase;
            case 11:
                return PreencheMonografia.preencheAbstract();
            case 12:
                return PreencheMonografia.preencheAbstract();
        }
        return null;
    }

    /**
     * menu principal da sessao de monografias
     */
    public void principal() {
        Scanner entrada = new Scanner(System.in);
        Monografia monografia;
        List<Submissao> submissoes;
        baseDeDados(controller);
        int opcao = 0;
        do {
            System.out.println("#########################################");
            System.out.println("#                                       #");
            System.out.println("#   Gerenciamento de monograficas       #");
            System.out.println("#   -----------------------------       #");
            System.out.println("#   1- incluir                          #");
            System.out.println("#   2- consultar                        #");
            System.out.println("#   3- consultar por autor              #");
            System.out.println("#   4- excluir                          #");
            System.out.println("#   5- editar                           #");
            System.out.println("#   0- sair                             #");
            System.out.println("#                                       #");
            System.out.println("#########################################");
            System.out.print("Opção: ");
            opcao = entrada.nextInt();

            switch (opcao) {
                case 0:
                    break;
                case 1:
                    monografia = criaMonografia();
                    if (controller.incluir(monografia)) {
                        msg("MONOGRAFIA CRIADA COM SUCESSO");
                    } else {
                        System.out.println(":(");
                    }
                    System.out.println("");
                    break;
                case 2:
                    monografia = consultarMonografia(controller, "Digite o titulo que você quer pesquisar: ");
                    do {
                        if (monografia != null) {
                            exibir(monografia);
                        } else {
                            msg("MONOGRAFIA NÃO ENCONTRADA");
                            System.out.println("Deseja pesquisar novamente?");
                            if (!entrada.nextLine().equalsIgnoreCase("sim")) {
                                break;
                            }
                        }
                    } while (monografia == null);
                    break;
                case 3:
                    entrada.nextLine();
                    monografia = null;
                    do {
                        System.out.println("========================================");
                        System.out.println("Digite o nome do autor que você quer pesquisar: ");
                        submissoes = controller.consultarAutor(entrada.nextLine());
                        if (submissoes != null) {
                            monografia = listaPorAutor(controller, submissoes);
                            if (monografia != null) {
                                exibir(monografia);
                            } else {
                                msg("monografia não encontrada");
                                System.out.println("Deseja pesquisar novamente?");
                                if (!entrada.nextLine().equalsIgnoreCase("sim")) {
                                    break;
                                }
                            }
                        } else {
                            msg("Autor não encontrado");
                            System.out.println("Deseja pesquisar novamente?");
                            if (!entrada.nextLine().equalsIgnoreCase("sim")) {
                                break;
                            }
                        }
                    } while (monografia == null);
                    break;
                case 4:
                    entrada.nextLine();
                    boolean excluida = false;
                    do {
                        System.out.println("================================================");
                        System.out.println("Qual é o titulo da monografia que você deseja excluir:");
                        excluida = controller.excluir(entrada.nextLine());
                        if (excluida) {
                            msg("Monografia excluida com sucesso");
                        } else {
                            msg("Monografia não encontrada");
                            System.out.print("Pesquisar novamente?");
                            if (!entrada.nextLine().equalsIgnoreCase("sim")) {
                                excluida = true;
                            }
                        }
                    } while (!excluida);
                    break;
                case 5:

                    monografia = consultarMonografia(controller, "Qual monografia você deseja editar:");
                    int fim = 0;
                    boolean editada = false;
                    do {
                        if (monografia != null) {
                            do {
                                int atributo = editarMonografia(monografia);
                                editada = controller.editar(atributo, PegarValor(atributo), monografia);
                                if (editada) {
                                    msg("MONOGRAFIA EDITADA COM SUCESSO");
                                }
                                System.out.println("====================================");
                                System.out.println("Deseja editar outro atributo? 1- sim | 2- não ");
                                fim = entrada.nextInt();
                            } while (fim != 2);
                        } else {
                            msg("monografia não encontrada");
                            if (!entrada.nextLine().equalsIgnoreCase("sim")) {
                                break;
                            }
                        }
                    } while (!editada);

                    break;
                default:
                    msg("Opção invalida!");
                    break;
            }

        } while (opcao != 0);
    }

    /**
     * main executavel do sistema
     *
     * @param args
     */
    public static void main(String[] args) {
        ExececutorDeMonografias ex = new ExececutorDeMonografias();
        ex.principal();
    }
}
