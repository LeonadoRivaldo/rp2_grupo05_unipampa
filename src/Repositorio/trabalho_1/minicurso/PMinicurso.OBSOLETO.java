package Repositorio.trabalho_1.minicurso;
//
//import java.util.List;
//
///**
// * Classe menu, cria e manipula um objeto do tipo Minicursos e o que será
// * exibido ao usuario
// */
//public class PMinicurso {
//
//    private static final Minicursos minicursos = new Minicursos();
//
//    /**
//     * Metodo main, chama o menuPrincipal menu
//     *
//     *
//     */
//    public static void principal() {
//        InOut.outL("MINICURSOS");
//        menuPrincipal();
//        InOut.outL("Adiossssssss muchacho!");
//    }
//
//    /**
//     * Metodo responsável pelo menuPrincipal menu
//     */
//    private static void menuPrincipal() {
//        int opcao;
//
//        do {
//            InOut.div();
//            opcao = InOut.inInt("Digite:\n 1 - Para criar um novo Minicurso"
//                    + "\n 2 - Para exibir os minicursos existentes"
//                    + "\n 3 - Para pesquisar um minicurso"
//                    + "\n 4 - Para editar um minicurso"
//                    + "\n 5 - Para excluir um minicurso"
//                    + "\n 0 - Para sair");
//
//            switch (opcao) {
//                case 0:
//                    break;
//                case 1:
//                    criar();
//                    break;
//                case 2:
//                    exibir();
//                    menuMinicurso();
//                    break;
//                case 3:
//                    pesquisar();
//                    menuMinicurso();
//                    break;
//                case 4:
//                    editar();
//                    break;
//                case 5:
//                    menuDeletar();
//                    break;
//                default:
//                    InOut.outL("Você digitou uma opção incorreta!");
//            }
//        } while (opcao != 0);
//    }
//
//    /**
//     * Metodo responsável por criar um novo Minicurso
//     */
//    private static void criar() {
//        String titulo, resumo, abstrac, metodologia, recursos;
//        int situacao, duracao;
//        List<String> autores;
//
//        titulo = PreencheSubmissao.preencheTitulo();
//        if (minicursos.getMinicurso(titulo) == null) {
//            autores = PreencheSubmissao.preencheAutores();
//            situacao = PreencheSubmissao.preencheSituacao();
//            resumo = PreencheSubmissao.preencheResumo();
//            abstrac = PreencheSubmissao.preencheAbstrac();
//            metodologia = PreencheSubmissao.preencheMetodologia();
//            recursos = PreencheSubmissao.preencheRecursos();
//            duracao = PreencheSubmissao.preencheDuracao();
//
//            minicursos.criar(titulo, autores, resumo, situacao, abstrac,
//                    metodologia, recursos, duracao);
//
//            InOut.div();
//            InOut.outL("Minicurso criado com sucesso!");
//        } else {
//            System.out.println("Ja existe um minicurso com este nome, por favor tente novamente");
//        }
//    }
//
//    /**
//     * Metodo responsavel por exibir os minicursos existentes
//     */
//    private static void exibir() {
//        InOut.div();
//        InOut.outL("Minicursos cadastrados:\n");
//        if (minicursos.getListaMinicursos() != null) {
//            InOut.outL(minicursos.getListaMinicursos());
//        } else {
//            System.out.println("Nenhum minicurso cadastrado");
//        }
//    }
//
//    /**
//     * Metodo responsavel pela pesquisa de minicursos
//     */
//    private static void pesquisar() {
//        String desejado = "";
//        int tipo;
//
//        do {
//            InOut.div();
//            tipo = InOut.inInt("Digite:"
//                    + "\n 1 - Para pesquisar por autor"
//                    + "\n 2 - Para pesquiasr por título");
//            InOut.div();
//            switch (tipo) {
//                case 1:
//                    desejado = InOut.inString("Digite o autor desejado:");
//                    break;
//                case 2:
//                    desejado = InOut.inString("Digite o título desejado:");
//                    break;
//                default:
//                    InOut.outL("Você digitou uma opção incorreta!");
//            }
//        } while (tipo != 1 && tipo != 2);
//
//        InOut.div();
//        System.out.println("Resultado da busca:");
//        System.out.println("");
//        System.out.println(minicursos.buscar(desejado, tipo));
//    }
//
//    /**
//     * Metodo responsavel pelo menu ao deletar um minicurso
//     */
//    private static void menuDeletar() {
//        int opcao = 0;
//
//        InOut.div();
//        while (opcao != 1 && opcao != 2) {
//            opcao = InOut.inInt("Digite:"
//                    + "\n 1 - Para exibir a lista de minicursos e selecionar qual deseja deletar"
//                    + "\n 2 - Para inserir o titulo que deseja deletar");
//        }
//
//        switch (opcao) {
//            case 1:
//                deletarPorLista();
//                break;
//            case 2:
//                deletarPorTitulo();
//                break;
//            default:
//                break;
//        }
//    }
//
//    /**
//     * Metodo responsavel pelo menu ao deletar um minicurso por titulo
//     */
//    private static void deletarPorTitulo() {
//        String desejado;
//        int opcao = 0;
//
//        InOut.div();
//        desejado = InOut.inString("Digite o título desejado:");
//        if (minicursos.getMinicurso(desejado) != null) {
//            System.out.println(minicursos.getMinicurso(desejado));
//            System.out.println("");
//            InOut.div();
//            while (opcao != 1 && opcao != 2) {
//                opcao = InOut.inInt("Você tem certeza que deseja excluir este minicurso?"
//                        + "Digite:"
//                        + "\n 1 - Para excluir"
//                        + "\n 2 - Para cancelar");
//            }
//
//            switch (opcao) {
//                case 1:
//                    if (minicursos.excluir(desejado)) {
//                        System.out.println("Minicurso deletado com sucesso!");
//                    } else {
//                        System.out.println("Ocorreu algum erro. Verifique o que digitou");
//                    }
//                    InOut.div();
//                    opcao = 2;
//                    break;
//                case 2:
//                    break;
//                default:
//                    System.out.println("Opçao incorreta!");
//                    break;
//            }
//        } else {
//            System.out.println("Nenhum minicurso encontrado com este nome!");
//        }
//    }
//
//    /**
//     * Metodo responsavel pelo menu ao deletar um minicurso por lista
//     */
//    private static void deletarPorLista() {
//        int opcao = 0;
//        String desejado;
//
//        exibir();
//        InOut.div();
//        desejado = InOut.inString("Digite o titulo do minicurso que deseja excluir:");
//        InOut.div();
//        if (minicursos.getMinicurso(desejado) != null) {
//            System.out.println(minicursos.getMinicurso(desejado));
//            System.out.println("");
//            InOut.div();
//
//            while (opcao != 1 && opcao != 2) {
//                opcao = InOut.inInt("Você tem certeza que deseja excluir este minicurso?"
//                        + "Digite:"
//                        + "\n 1 - Para excluir"
//                        + "\n 2 - Para cancelar");
//            }
//
//            switch (opcao) {
//                case 1:
//                    InOut.div();
//                    if (minicursos.excluir(desejado)) {
//                        System.out.println("Minicurso deletado com sucesso!");
//                    } else {
//                        System.out.println("Ocorreu algum erro. Verifique o que digitou");
//                    }
//                    break;
//                case 2:
//                    break;
//                default:
//                    InOut.outL("Opçao incorreta!");
//                    break;
//            }
//        } else {
//            System.out.println("Nenhum minicurso encontrdo com este titulo!");
//        }
//    }
//
//    /**
//     * Metodo responsavel pela edição de um minicurso
//     */
//    private static void editar() {
//        int opcao;
//        String desejado;
//
//        exibir();
//        InOut.div();
//        desejado = InOut.inString("Digite o titulo do minicurso que deseja editar:");
//        InOut.div();
//
//        if (minicursos.getMinicurso(desejado) != null) {
//            do {
//                System.out.println("Minicurso selecionado:");
//                System.out.println("");
//                System.out.println(minicursos.getMinicurso(desejado));
//                InOut.div();
//
//                opcao = InOut.inInt("Digite:"
//                        + "\n 1 - Para editar o titulo"
//                        + "\n 2 - Para editar o autor"
//                        + "\n 3 - Para editar a situação"
//                        + "\n 4 - Para editar o resumo"
//                        + "\n 5 - Para editar o abstract"
//                        + "\n 6 - Para editar os recursos"
//                        + "\n 7 - Para editar a metodologia"
//                        + "\n 8 - Para editar a duração"
//                        + "\n 0 - Para sair");
//                InOut.div();
//
//                switch (opcao) {
//                    case 0:
//                        break;
//                    case 1:
//                        String aux = PreencheSubmissao.preencheTitulo();
//                        minicursos.editarTitulo(desejado, aux);
//                        desejado = aux;
//                        break;
//                    case 2:
//                        minicursos.editarAutores(desejado, PreencheSubmissao.preencheAutores());
//                        break;
//                    case 3:
//                        minicursos.editarSituacao(desejado, PreencheSubmissao.preencheSituacao());
//                        break;
//                    case 4:
//                        minicursos.editarResumo(desejado, PreencheSubmissao.preencheResumo());
//                        break;
//                    case 5:
//                        minicursos.editarAbstract(desejado, PreencheSubmissao.preencheAbstrac());
//                        break;
//                    case 6:
//                        minicursos.editarRecursos(desejado, PreencheSubmissao.preencheRecursos());
//                        break;
//                    case 7:
//                        minicursos.editarMetodologia(desejado, PreencheSubmissao.preencheMetodologia());
//                        break;
//                    case 8:
//                        minicursos.editarDuracao(desejado, PreencheSubmissao.preencheDuracao());
//                        break;
//                    default:
//                        System.out.println("Opção incorreta!");
//                        break;
//                }
//
//            } while (opcao != 0);
//        } else {
//            System.out.println("Nenhum minicurso com este titulo encontrado!");
//        }
//    }
//
//    /**
//     * Metodo responsavel pelo menuPrincipal que é exibido na busca e na
//     * exibição de todos os minicursos
//     */
//    private static void menuMinicurso() {
//        String desejado;
//
//        System.out.println("");
//        desejado = InOut.inString("Digite:"
//                + "\n Para exibir mais informações sobre um minicurso, digite o"
//                + " titulo correspondente"
//                + "\n DIGITE SAIR PARA SAIR");
//
//        if (!desejado.equalsIgnoreCase("sair")) {
//            System.out.println(desejado);
//            String aux = minicursos.getMinicurso(desejado);
//            if (aux == null) {
//                System.out.println("Nenhum minicurso encontrado. Verifique o que voce digitou");
//            } else {
//                System.out.println(aux);
//            }
//        }
//    }
//}
