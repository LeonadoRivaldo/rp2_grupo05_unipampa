package Repositorio.trabalho_1.minicurso;

import java.util.List;

/**
 * Classe menu, cria e manipula um objeto do tipo Minicursos e o que será
 * exibido ao usuario
 */
public class PMinicurso {

    private static final Minicursos minicursos = new Minicursos();

    /**
     * Metodo main, chama o menuPrincipal menu
     *
     *
     */
    public static void principal() {
        InOut.outL("MINICURSOS");
        menuPrincipal();
        InOut.outL("Adiossssssss muchacho!");
    }

    /**
     * Metodo responsável pelo menuPrincipal menu
     */
    private static void menuPrincipal() {
        int opcao;

        do {
            InOut.div();
            opcao = InOut.inInt("Digite:\n 1 - Para criar um novo Minicurso"
                    + "\n 2 - Para exibir os minicursos existentes"
                    + "\n 3 - Para pesquisar um minicurso"
                    + "\n 4 - Para editar um minicurso"
                    + "\n 5 - Para excluir um minicurso"
                    + "\n 0 - Para sair");

            switch (opcao) {
                case 0:
                    break;
                case 1:
                    criar();
                    break;
                case 2:
                    exibir();
                    menuMinicurso();
                    break;
                case 3:
                    pesquisar();
                    menuMinicurso();
                    break;
                case 4:
                    editar();
                    break;
                case 5:
                    menuDeletar();
                    break;
                default:
                    InOut.outL("Você digitou uma opção incorreta!");
            }
        } while (opcao != 0);
    }

    /**
     * Metodo responsável por criar um novo Minicurso
     */
    private static void criar() {
        String titulo, resumo, abstrac, metodologia, recursos;
        int situacao, duracao;
        List<String> autores;

        titulo = PreencheMinicurso.preencheTitulo();
        autores = PreencheMinicurso.preencheAutores();
        situacao = PreencheMinicurso.preencheSituacao();
        resumo = PreencheMinicurso.preencheResumo();
        abstrac = PreencheMinicurso.preencheAbstrac();
        metodologia = PreencheMinicurso.preencheMetodologia();
        recursos = PreencheMinicurso.preencheRecursos();
        duracao = PreencheMinicurso.preencheDuracao();

        minicursos.criar(titulo, autores, resumo, situacao, abstrac,
                metodologia, recursos, duracao);

        InOut.div();
        InOut.outL("Minicurso criado com sucesso!");
    }

    /**
     * Metodo responsavel por exibir os minicursos existentes
     */
    private static void exibir() {
        InOut.div();
        InOut.outL("Minicursos cadastrados:\n");
        InOut.outL(minicursos.getListaMinicursos());
    }

    /**
     * Metodo responsavel pela pesquisa de minicursos
     */
    private static void pesquisar() {
        String desejado = "";
        int tipo;

        do {
            InOut.div();
            tipo = InOut.inInt("Digite:"
                    + "\n 1 - Para pesquisar por autor"
                    + "\n 2 - Para pesquiasr por título");
            InOut.div();
            switch (tipo) {
                case 1:
                    desejado = InOut.inString("Digite o autor desejado:");
                    break;
                case 2:
                    desejado = InOut.inString("Digite o título desejado:");
                    break;
                default:
                    InOut.outL("Você digitou uma opção incorreta!");
            }
        } while (tipo != 1 && tipo != 2);

        InOut.div();
        System.out.println("Resultado da busca:");
        System.out.println("");
        System.out.println(minicursos.buscar(desejado, tipo));
    }

    /**
     * Metodo responsavel pelo menu ao deletar um minicurso
     */
    private static void menuDeletar() {
        int opcao = 0;

        InOut.div();
        while (opcao != 1 && opcao != 2) {
            opcao = InOut.inInt("Digite:"
                    + "\n 1 - Para exibir a lista de minicursos e selecionar qual deseja deletar"
                    + "\n 2 - Para inserir o titulo que deseja deletar");
        }

        switch (opcao) {
            case 1:
                deletarPorLista();
                break;
            case 2:
                deletarPorTitulo();
                break;
            default:
                break;
        }
    }

    /**
     * Metodo responsavel pelo menu ao deletar um minicurso por titulo
     */
    private static void deletarPorTitulo() {
        String desejado;
        int opcao = 0;

        InOut.div();
        exibir();
        desejado = InOut.inString("Digite o título desejado:");
        System.out.println(minicursos.buscar(desejado, 2));
        System.out.println("");
        InOut.div();
        while (opcao != 1 && opcao != 2) {
            opcao = InOut.inInt("Você tem certeza que deseja excluir este minicurso?"
                    + "Digite:"
                    + "\n 1 - Para excluir"
                    + "\n 2 - Para cancelar");
        }

        switch (opcao) {
            case 1:
                if (minicursos.excluir(desejado)) {
                    System.out.println("Minicurso deletado com sucesso!");
                } else {
                    System.out.println("Ocorreu algum erro. Verifique o que digitou");
                }
                InOut.div();
                opcao = 2;
                break;
            case 2:
                break;
            default:
                System.out.println("Opçao incorreta!");
                break;
        }

    }

    /**
     * Metodo responsavel pelo menu ao deletar um minicurso por lista
     */
    private static void deletarPorLista() {
        int opcao = 0;
        String desejado;

        exibir();
        InOut.div();
        desejado = InOut.inString("Digite o titulo do minicurso que deseja excluir:");
        InOut.div();
        while (opcao != 1 && opcao != 2) {
            opcao = InOut.inInt("Você tem certeza que deseja excluir este minicurso?"
                    + "Digite:"
                    + "\n 1 - Para excluir"
                    + "\n 2 - Para cancelar");
        }

        switch (opcao) {
            case 1:
                InOut.div();
                if (minicursos.excluir(desejado)) {
                    System.out.println("Minicurso deletado com sucesso!");
                } else {
                    System.out.println("Ocorreu algum erro. Verifique o que digitou");
                }
                break;
            case 2:
                break;
            default:
                InOut.outL("Opçao incorreta!");
                break;
        }
    }

    /**
     * Metodo responsavel pela edição de um minicurso
     */
    private static void editar() {
        int opcao;
        String desejado;

        exibir();
        InOut.div();
        desejado = InOut.inString("Digite o titulo do minicurso que deseja editar:");
        InOut.div();

        do {
            System.out.println("Minicurso selecionado:");
            System.out.println("");
            System.out.println(minicursos.getMinicurso(desejado));
            InOut.div();

            opcao = InOut.inInt("Digite:"
                    + "\n 1 - Para editar o titulo"
                    + "\n 2 - Para editar o autor"
                    + "\n 3 - Para editar a situação"
                    + "\n 4 - Para editar o resumo"
                    + "\n 5 - Para editar o abstract"
                    + "\n 6 - Para editar os recursos"
                    + "\n 7 - Para editar a metodologia"
                    + "\n 8 - Para editar a duração"
                    + "\n 0 - Para sair");
            InOut.div();

            switch (opcao) {
                case 0:
                    break;
                case 1:
                    String aux = PreencheMinicurso.preencheTitulo();
                    minicursos.editarTitulo(desejado, aux);
                    desejado = aux;
                    break;
                case 2:
                    minicursos.editarAutores(desejado, PreencheMinicurso.preencheAutores());
                    break;
                case 3:
                    minicursos.editarSituacao(desejado, PreencheMinicurso.preencheSituacao());
                    break;
                case 4:
                    minicursos.editarResumo(desejado, PreencheMinicurso.preencheResumo());
                    break;
                case 5:
                    minicursos.editarAbstract(desejado, PreencheMinicurso.preencheAbstrac());
                    break;
                case 6:
                    minicursos.editarRecursos(desejado, PreencheMinicurso.preencheRecursos());
                    break;
                case 7:
                    minicursos.editarMetodologia(desejado, PreencheMinicurso.preencheMetodologia());
                    break;
                case 8:
                    minicursos.editarDuracao(desejado, PreencheMinicurso.preencheDuracao());
                    break;
                default:
                    System.out.println("Opção incorreta!");
                    break;
            }

        } while (opcao != 0);
    }

    /**
     * Metodo responsavel pelo menuPrincipal que é exibido na busca e na
     * exibição de todos os minicursos
     */
    private static void menuMinicurso() {
        String desejado;

        System.out.println("");
        desejado = InOut.inString("Digite:"
                + "\n Para exibir mais informações sobre um minicurso, digite o"
                + " titulo correspondente"
                + "\n DEIXE EM BRANCO PARA SAIR");

        if (desejado != "") {
            System.out.println("");
            String aux = minicursos.getMinicurso(desejado);
            if (aux == null) {
                System.out.println("Nenhum minicurso encontrado. Verifique o que voce digitou");
            } else {
                System.out.println(aux);
            }
        }
    }
}
