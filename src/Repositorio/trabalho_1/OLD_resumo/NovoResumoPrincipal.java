package trabalho_1.resumo;

import java.util.Scanner;

public class NovoResumoPrincipal {

    NovoResumoCotrole novoResumoControle = new NovoResumoCotrole();

    /**
     * cria e inclui um novo resumo
     *
     * @param controle
     */
    public static void incluir(NovoResumoCotrole controle) {
        NovoResumo novoResumo = new NovoResumo();
        Scanner entrada = new Scanner(System.in);
        String titulo;
        System.out.println("Digite o nome do titulo");
        titulo = entrada.nextLine();
        novoResumo.setTitulo(titulo);

        System.out.println("digite o quantidade de autores no maximo 8.");
        int n;
        n = entrada.nextInt();
        entrada.nextLine();
        String[] autores = new String[n];
        for (int i = 0; i < autores.length; i++) {
            System.out.println("Digite o nome do autor:");
            autores[i] = entrada.nextLine();
        }
        novoResumo.setAutor(autores);

        System.out.println("Digite a qtde institução");
        int insti = entrada.nextInt();
        entrada.nextLine();
        String[] instituicao = new String[insti];
        for (int i = 0; i < insti; i++) {
            System.out.println("Digite o nome da institução");
            instituicao[i] = entrada.nextLine();
        }
        novoResumo.setInstitucao(instituicao);

        System.out.println("Digite o qtd de palavras Chaves");
        int qtdPalavrasChaves = entrada.nextInt();
        entrada.nextLine();
        String[] palavrasChaves = new String[qtdPalavrasChaves];
        for (int i = 0; i < palavrasChaves.length; i++) {
            System.out.println("Digite o nome da palavras chave:");
            palavrasChaves[i] = entrada.nextLine();
        }
        novoResumo.setPalavra_chave(palavrasChaves);
        controle.incluir(novoResumo);

    }

    public static void editar(int atributo, NovoResumo novoResumo) {
        Scanner entrada = new Scanner(System.in);
        switch (atributo) {
            case 1:
                System.out.println("Digite o nome do titulo");
                novoResumo.setTitulo(entrada.nextLine());
                break;
            case 2:
                System.out.println("digite o quantidade de autores no maximo 8.");
                int n = entrada.nextInt();
                entrada.nextLine();
                String[] autores = new String[n];
                for (int i = 0; i < autores.length; i++) {
                    System.out.print("Digite o nome do autor " + (i) + "º :");
                    autores[i] = entrada.nextLine();
                }
                novoResumo.setAutor(autores);
                break;
            case 3:
                System.out.println("Digite a qtde institução");
                int insti = entrada.nextInt();
                entrada.nextLine();
                String[] instituicao = new String[insti];
                for (int i = 0; i < insti; i++) {
                    System.out.print("Digite o nome da institução" + (i) + "º :");
                    instituicao[i] = entrada.nextLine();
                }
                novoResumo.setInstitucao(instituicao);
                break;
            case 4:
                System.out.println("Digite o qtd de palavras Chaves");
                int qtdPalavrasChaves = entrada.nextInt();
                entrada.nextLine();
                String[] palavrasChaves = new String[qtdPalavrasChaves];
                for (int i = 0; i < palavrasChaves.length; i++) {
                    System.out.print("Digite a palavra chave" + (i) + "º :");
                    palavrasChaves[i] = entrada.nextLine();
                }
                novoResumo.setPalavra_chave(palavrasChaves);
                break;
        }
    }

    /**
     * lista todos os items de resumos
     *
     * @param x
     * @param frase
     * @return
     */
    public static int listar(NovoResumoCotrole x, String frase) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("====================================");

        if (!x.getResumos().isEmpty()) {
            int i = 0;
            for (NovoResumo resumo : x.getResumos()) {
                System.out.println((++i) + "  " + resumo.getTitulo());
            }
            System.out.print("Selecione o resumo: ");
            return (entrada.nextInt() - 1);

        }
        return -1;
    }

    /**
     * exibi o conteudo de um resumo com base no objeto
     *
     * @param novoResumo
     */
    private static void exibir(NovoResumo novoResumo) {
        System.out.println("#################################################");
        System.out.println("Titulo:" + novoResumo.getTitulo());
        System.out.println("Situação: " + novoResumo.getSituacao());
        String[] autor = novoResumo.getAutor();
        System.out.print("Autores: ");
        for (int i = 0; i < novoResumo.getAutor().length; i++) {
            System.out.print(autor[i] + ", ");
        }
        System.out.println("");
        String[] instituicao = novoResumo.getInstitucao();
        System.out.print("Institução: ");
        for (int i = 0; i < novoResumo.getInstitucao().length; i++) {
            System.out.print(instituicao[i] + ", ");
        }
        System.out.println("");
        String[] palavrasChave = novoResumo.getPalavra_chave();
        System.out.print("Palavras chave: ");
        for (int i = 0; i < novoResumo.getPalavra_chave().length; i++) {
            System.out.print(palavrasChave[i] + ", ");
        }
        System.out.println("");
        System.out.println("#################################################");

    }

    public static void msg(String s) {
        System.out.println("\n=============================\n" + s + "\n=============================\n");
    }

    /**
     * executa o menu etc.
     */
    public void principal() {
        Scanner entrada = new Scanner(System.in);
        int opcao;

        do {

            System.out.println("###################################################");
            System.out.println("Gerenciamento de monograficas");
            System.out.println("0 - Sair");
            System.out.println("1 - consultar");
            System.out.println("2 - incluir");
            System.out.println("3 - Excluir");
            System.out.println("4 - Editar");

            System.out.print("Opção :");
            opcao = entrada.nextInt();

            switch (opcao) {
                case 0:
                    break;
                case 1:
                    int ix = listar(novoResumoControle, "Qual resumo você quer visualizar: ");
                    if (ix != -1) {
                        exibir(novoResumoControle.consultar(ix));
                    } else {
                        msg("lista vazia");
                    }
                    break;
                case 2:
                    NovoResumoPrincipal.incluir(novoResumoControle);
                    msg("resumo incluido com susseso");
                    break;
                case 3:
                    int i = listar(novoResumoControle, "Qual resumo você quer excluir: ");
                    if (i != -1) {
                        novoResumoControle.excluir(i);
                        msg("resumo excluido com susseso");
                    } else {
                        msg("lista vazia");
                    }

                case 4:
                    int index = listar(novoResumoControle, "Qual resumo você deseja editar:");
                    if (index != -1) {
                        NovoResumo resumo = novoResumoControle.consultar(index);
                        int atributo = editarResumo(resumo);
                        editar(atributo, resumo);
                        msg("resumo EDITADo COM SUCESSO");
                    } else {
                        msg("lista vazia");
                    }
                    break;
                default:
                    msg("Opção inesistente");
            }

        } while (opcao != 0);

    }

    private int editarResumo(NovoResumo novoResumo) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("#################################################");
        System.out.println("1- Titulo:" + novoResumo.getTitulo());
        String[] autor = novoResumo.getAutor();
        System.out.print("2- Autores: ");
        for (int i = 0; i < novoResumo.getAutor().length; i++) {
            System.out.print(autor[i] + ", ");
        }
        System.out.println("");
        String[] instituicao = novoResumo.getInstitucao();
        System.out.print("3- Institução: ");
        for (int i = 0; i < novoResumo.getInstitucao().length; i++) {
            System.out.print(instituicao[i] + ", ");
        }
        System.out.println("");
        String[] palavrasChave = novoResumo.getPalavra_chave();
        System.out.print("4- Palavras chave: ");
        for (int i = 0; i < novoResumo.getPalavra_chave().length; i++) {
            System.out.print(palavrasChave[i] + ", ");
        }
        System.out.println("");
        System.out.println("#################################################");
        return entrada.nextInt();
    }

}
