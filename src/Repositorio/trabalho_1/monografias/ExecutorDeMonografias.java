/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositorio.trabalho_1.monografias;

import Repositorio.trabalho_1.monografias.ControllerDeMonografias;
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
     */
    private static void exibir(Monografia monografia) {
        System.out.println("===================================================");
        System.out.println("Titulo: " + monografia.getTituloSubmissao());
        System.out.println("Situacao: " + monografia.getSituacaoSubmissao());
        //System.out.println("Tipo: " + monografia.getTipo());
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
            //System.out.println("2-Situacao: " + monografia.getSituacao());
            //System.out.println("2-Tipo: " + monografia.getTipo());
            System.out.println("3-Autor: " + monografia.getAutor().get(0));
            System.out.println("4-Instituição: " + monografia.getInstituicao().get(0));
            System.out.println("5-Orientador: " + monografia.getOrientador());
            System.out.println("6-Curso: " + monografia.getCurso());
            System.out.println("7-Ano: " + monografia.getAno());
            System.out.println("8-Numero De Paginas: " + monografia.getNumeroDePaginas());
            System.out.print("9-Palavras-chaves: ");
            List<String> palavras = monografia.getPalavrasChave();
            for (String palavra : palavras) {
                System.out.print(palavra + ", ");
            }
            System.out.println("");
            System.out.println("10-Resumo: " + monografia.getResumo());
            System.out.println("11-Abstract: " + monografia.getAbstract());
            System.out.println("===================================================");
            System.out.print("Qual atributo você quer editar: ");
            in = entrada.nextInt();
            if (in > 11 || in < 1) {
                msg("digito invalido");
            }
        } while (in > 11 || in < 1);
        return in;
    }

    /**
     * Consulta monografias
     *
     * @param c
     * @param frase
     * @return
     */
    public static int ConsultarMonografia(ControllerDeMonografias c, String frase) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("==============================");
        int in = -1;
        do {
            int i = 0;
            for (Monografia monografia : c.monografias) {
                i++;
                System.out.println(i + "- " + monografia.getTituloSubmissao());
            }
            System.out.println("------------------------------");
            System.out.println(frase);
            in = entrada.nextInt();
            if (in < 1 || in > c.monografias.size()) {
                msg("digito invalido");
            }
        } while (in < 1 || in > c.monografias.size());
        return --in;
    }

    /**
     * cria um objeto de monografia
     *
     * @return objeto monografia
     */
    public static Monografia criaMonografia() {
        //Monografia monografia = new Monografia();
        System.out.println("===============================================");
        String titulo = PreencheMonografia.preencheTitulo();
        //PreencheMonografia.preencheAutor());
        
        //monografia.setTipo(PreencheMonografia.preencheTipo());
        //monografia.setInstituicao(PreencheMonografia.preencheInstituicao());
        //monografia.setOrientador(PreencheMonografia.preencheOrientador());
        //monografia.setCurso(PreencheMonografia.preencheCurso());
        //monografia.setAno(Integer.parseInt(PreencheMonografia.preencheAno()));
        //monografia.setNumeroDePaginas(Integer.parseInt(PreencheMonografia.preencheNroPaginas()));
        //monografia.setPalavrasChaves(PreencheMonografia.preenchePalavrasChaves());
        //monografia.setResumo(PreencheMonografia.preencheResumo());
        //monografia.setAbstract(PreencheMonografia.preencheAbstract());
        System.out.println("===============================================");
        return null;
    }

    public static void msg(String s) {
        System.out.println("\n=============================\n" + s + "\n=============================\n");
    }

    public static void baseDeDados(ControllerDeMonografias controle) {
        String palavras[] = {"Um", "Doi", "Tres", "Quatro"};
        String resumo = "Lorem ipsum dolor sit amet, consectetur adipiscing elit\n";
        resumo += "in ligula est, placerat quis maximus vel, imperdiet eu sapien.\n";
        resumo += "Quisque aliquet placerat neque. Aenean auctor lacus sit amet,\n";
        resumo += "enim ultrices, in interdum lacus blandit. Class aptent taciti.\n";
        //controle.incluir(new Monografia("Monografia 1", "Graduação", "Leonardo", "Unipampa", "Aline", "ES", 2020, 200, palavras, resumo, resumo + " Abstract!"));
        //controle.incluir(new Monografia("Monografia 2", "Especialização", "Amanda", "Unipampa", "Aline", "ES", 2022, 150, palavras, resumo + "resumo2", resumo + "Abstract2"));
        //controle.incluir(new Monografia("Monografia 3", "Mestrado", "Leonardo", "MIT", "Jhon stuart", "ES", 2030, 350, palavras, resumo + "resumo3", resumo + "Abstract3"));
        //controle.incluir(new Monografia("Monografia 4", "Doutorado", "Amanda", "Oxford", "Jhon lenon", "ES", 2031, 450, palavras, resumo + "resumo4", resumo + "Abstract4"));
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
                return PreencheMonografia.preencheAutor();
            case 3:
                return PreencheMonografia.preencheTipo();
            case 4:
                return PreencheMonografia.preencheInstituicao();
            case 5:
                return PreencheMonografia.preencheOrientador();
            case 6:
                return PreencheMonografia.preencheCurso();
            case 7:
                return PreencheMonografia.preencheAno();
            case 8:
                return PreencheMonografia.preencheNroPaginas();
            case 9:
                String[] palavras = PreencheMonografia.preenchePalavrasChaves();
                String frase = "";
                for (String s : palavras) {
                    frase += s + " ";
                }
                return frase;
            case 10:
                return PreencheMonografia.preencheAbstract();
            case 11:
                return PreencheMonografia.preencheAbstract();
        }
        return null;
    }

    /**
     * menu do sistem
     */
    public void menu() {
        Scanner entrada = new Scanner(System.in);

        baseDeDados(controller);
        int opcao = 0;
        do {
            System.out.println("###################################################");
            System.out.println("Gerenciamento de monograficas");
            System.out.println("1- incluir");
            System.out.println("2- consular");
            System.out.println("3- excluir");
            System.out.println("4- editar");
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
                    System.out.println("========================================");
                    System.out.println("Lista:");
                    if (controller.monografias.size() <= 0) {
                        System.out.println("A lista está vazia!");
                    } else {
                        exibir(controller.consultar(ConsultarMonografia(controller, "Qual monografia você quer visualizar:")));
                    }
                    break;
                case 3:
                    System.out.println("========================================");
                    if (controller.monografias.size() <= 0) {
                        System.out.println("A lista está vazia!");
                    } else {
                        if (controller.excluir(ConsultarMonografia(controller, "Qual monografia você quer excluir:"))) {
                            msg("MONOGRAFIA excluida COM SUCESSO");
                        }
                    }
                    break;
                case 4:
                    int index = ConsultarMonografia(controller, "Qual monografia você deseja editar:");
                    Monografia mono = controller.consultar(index);
                    int atributo = editarMonografia(mono);
                    if (controller.editar(atributo, PegarValor(atributo), mono)) {
                        msg("MONOGRAFIA EDITADA COM SUCESSO");
                    }
                    break;
                default:
                    break;
            }
        } while (opcao != 0);
    }
    /*
     public static void main(String[] args) {
     menu();
     }
     */
}
