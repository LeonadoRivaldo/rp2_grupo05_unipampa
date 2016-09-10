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
public class ExecutorDeMonografias {

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
    private static void listaPorAutor(String autor, ControllerDeMonografias c, String frase) {
        System.out.println("TODO");
    }

    /**
     * Consulta monografias, por pequista ou lista, dando ao usuario opçao de
     * pesquisar por titulo ou por autor ou ter uma lista de todas as
     * monografias pelo titulo
     *
     * @deprecated old - refazer
     * @param c controler de monografia
     * @param frase String que vai aparecer para o usuario
     * @return
     */
    public static int ConsultarMonografia(ControllerDeMonografias c, String frase) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("==============================");
        int in = -1, i = 0;
        String pesquisa = "pesquisa";
        //System.out.println("Pesquisa por titulo ou consulta em lista? (pesquisa/lista)");
        //pesquisa = entrada.nextLine();
        if (pesquisa.equalsIgnoreCase("lista")) {
            //System.out.println("-----------------------------------------------");
            //System.out.println("Listar monografias por titulo ou por autor:");
            pesquisa = "titulo";
            if (pesquisa.equalsIgnoreCase("titulo")) {
                System.out.println("--------------------------------------------");
                for (Monografia monografia : c.monografias) {
                    i++;
                    System.out.println(i + "- " + monografia.getTituloSubmissao());
                    if (i % 10 == 0) {
                        do {
                            System.out.println("------------------------------");
                            System.out.print(frase + " ou -1 para continuar:");
                            in = entrada.nextInt();
                            System.out.println("------------------------------");
                            if (in == -1) {
                                break;
                            }
                        } while (in < 1 || in > i);
                        if (in != -1) {
                            break;
                        }
                    }
                }
                do {
                    if (i == c.monografias.size()) {
                        System.out.println("fim da lista!");
                        System.out.println("------------------------------");
                        System.out.print(frase + ": ");
                        in = entrada.nextInt();
                    }
                } while (in < 1 || in > c.monografias.size());
            } else {
                msg("FAZER LISTA POR AUTOR!");
                entrada.nextLine();
            }
        } else {
            System.out.println("==================================================");
            System.out.print("Pesquisa por titulo ou autor:");
            pesquisa = entrada.nextLine();
            if (pesquisa.equalsIgnoreCase("autor")) {
                String autor = PreencheMonografia.preencheAutor().get(0);
                return listaPorAutor(autor, c, frase);
            } else {
                i = 0;
                String titulo = PreencheMonografia.preencheTitulo();
                for (Monografia monografia : c.monografias) {
                    if (monografia.getTituloSubmissao().contains(titulo)) {
                        i++;
                        int pos = c.monografias.indexOf(monografia);
                        System.out.println(pos + "- " + monografia.getTituloSubmissao());
                    }
                }
                if (i > 0) {
                    do {
                        System.out.println("------------------------------");
                        System.out.print(frase + ": ");
                        in = entrada.nextInt();
                    } while (in < 1 || in > c.monografias.size());
                    return in;
                } else {
                    msg("Nenhuma monografia encontrada com esse titulo");
                }
            }
        }
        return --in;
    }

    public static Monografia consultarMonografia(ControllerDeMonografias c, String frase) {
        System.out.println("TODO");
        return null;
    }

    /**
     * cria um objeto de monografia
     *
     * @return objeto monografia
     */
    public static Monografia criaMonografia() {
        System.out.println("===============================================");
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
    public static void msg(String s) {
        System.out.println("\n=============================\n" + s + "\n=============================\n");
    }

    /**
     * cria objetos para colocar na lista
     *
     * @param controle
     */
    public static void baseDeDados(ControllerDeMonografias controle) {
        List<String> palavras = new ArrayList();
        List<String> palavras1 = new ArrayList();
        List<String> palavras2 = new ArrayList();
        palavras.add("Um");
        palavras.add("Doi");
        palavras.add("tres");
        palavras.add("quatro");
        palavras1.add("tres");
        palavras2.add("quatro");
        String resumo = "Lorem ipsum dolor sit amet, consectetur adipiscing elit\n";
        resumo += "in ligula est, placerat quis maximus vel, imperdiet eu sapien.\n";
        resumo += "Quisque aliquet placerat neque. Aenean auctor lacus sit amet,\n";
        resumo += "enim ultrices, in interdum lacus blandit. Class aptent taciti.\n";
        for (int i = 0; i < 50; i++) {
            controle.incluir(new Monografia(Tipo.graduacao, "Aline", "ES", 2020 + i, i, resumo, resumo + "Abstract" + i, "Leonardo" + i, Situacao.sobAvaliacao, palavras, i, palavras1, palavras2, 4, 1));

        }
    }

    /**
     * pega o novo valor que o usuario quer para preencher o novo objeto
     *
     * @param atributo
     * @return
     */
    public static String PegarValor(int atributo) {
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
     * menu do sistem
     */
    public void principal() {
        Scanner entrada = new Scanner(System.in);

        baseDeDados(controller);
        int opcao = 0;
        do {
            System.out.println("###################################################");
            System.out.println("Gerenciamento de monograficas");
            System.out.println("1- incluir");
            System.out.println("2- consultar");
            System.out.println("3- consultar por autor");
            System.out.println("4- excluir");
            System.out.println("5- editar");
            System.out.println("0- sair");
            System.out.print("Opção: ");
            opcao = entrada.nextInt();

            switch (opcao) {
                case 0:
                    break;
                case 1:
                    Monografia m = criaMonografia();
                    if (controller.incluir(m)) {
                        msg("MONOGRAFIA CRIADA COM SUCESSO");
                    } else {
                        System.out.println(":(");
                    }
                    System.out.println("");
                    break;
                case 2:
                    Monografia mono = consultarMonografia(controller, "Digite o titulo que você quer pesquisar: ");
                    do {
                        if (mono != null) {
                            exibir(mono);
                        } else {
                            msg("MONOGRAFIA NÃO ENCONTRADA");
                            System.out.println("Deseja pesquisar novamente?");
                            if (entrada.nextLine().equalsIgnoreCase("sim")) {
                                mono = consultarMonografia(controller, "Digite o titulo que você quer pesquisar: ");
                            }
                        }
                    } while (mono == null);
                    break;
                case 4:
                    System.out.println("========================================");
                    if (controller.monografias.size() <= 0) {
                        System.out.println("A lista está vazia!");
                    } else {
                        if (controller.excluir(ConsultarMonografia(controller, "Qual monografia você quer excluir:"))) {
                            msg("MONOGRAFIA excluida COM SUCESSO");
                        }
                    }
                    break;
                case 5:
                    int index = ConsultarMonografia(controller, "Qual monografia você deseja editar:");
                    Monografia mono = controller.consultar(index);
                    int fim = 0;
                    do {
                        int atributo = editarMonografia(mono);
                        if (controller.editar(atributo, PegarValor(atributo), mono)) {
                            msg("MONOGRAFIA EDITADA COM SUCESSO");
                        }
                        System.out.println("====================================");
                        System.out.println("Deseja editar outro atributo? 1- sim | 2- não ");
                        fim = entrada.nextInt();
                    } while (fim != 2);
                    break;
                default:
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
        ExecutorDeMonografias ex = new ExecutorDeMonografias();
        ex.principal();
    }

}
