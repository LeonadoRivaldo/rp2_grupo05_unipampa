package Repositorio.trabalho_1.minicurso;

import java.util.List;

/**
 * Classe principal, cria e manipula um objeto do tipo Minicursos e o que será
 * exibido ao usuario
 */
public class PMinicurso {
    
    private static final Minicursos minicursos = new Minicursos();

    /**
     * Metodo main, chama o menu principal
     *
     *
     */
    public static void principal() {
        InOut.outL("MINICURSOS");
        menu();
        InOut.outL("Adiossssssss muchacho!");
    }

    /**
     * Metodo responsável pelo menu principal
     */
    private static void menu() {
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
                    deletar();
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
        InOut.inString(minicursos.getListaMinicursos());
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
     * Metodo responsavel por excluir um minicurso
     */
    private static void deletar() {
        int opcao, minicursoSelecionado;
        
        do {
            exibir();
            InOut.div();
            minicursoSelecionado = InOut.inInt("Digite o numero do minicurso que deseja excluir:");
            InOut.div();
            opcao = InOut.inInt("Você tem certeza que deseja excluir este minicurso?"
                    + "Digite:"
                    + "\n 1 - Para excluir"
                    + "\n 2 - Para cancelar");
            
            switch (opcao) {
                case 1:
                    minicursos.excluir(minicursoSelecionado);
                    InOut.div();
                    InOut.outL("Minicurso deletado com sucesso!");
                    opcao = 2;
                    break;
                case 2:
                    break;
                default:
                    InOut.outL("Opçao incorreta!");
                    break;
            }
        } while (opcao != 2);
    }

    /**
     * Metodo responsavel pela edição de um minicurso
     */
    private static void editar() {
        String novoDado;
        int opcao;
        int nAutores, nSituacao, index;
        
        exibir();
        InOut.div();
        index = InOut.inInt("Digite o numero do minicurso que deseja editar:");
        InOut.div();
        
        do {
            System.out.println("Minicurso selecionado:");
            System.out.println("");
            minicursos.getMinicurso(index);
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
                    minicursos.editarTitulo(index, PreencheMinicurso.preencheTitulo());
                    break;
                case 2:
                    minicursos.editarAutores(index, PreencheMinicurso.preencheAutores());
                    break;
                case 3:
                    minicursos.editarSituacao(index, PreencheMinicurso.preencheSituacao());
                    break;
                case 4:
                    minicursos.editarResumo(index, PreencheMinicurso.preencheResumo());
                    break;
                case 5:
                    minicursos.editarAbstract(index, PreencheMinicurso.preencheAbstrac());
                    break;
                case 6:
                    minicursos.editarRecursos(index, PreencheMinicurso.preencheRecursos());
                    break;
                case 7:
                    minicursos.editarMetodologia(index, PreencheMinicurso.preencheMetodologia());
                    break;
                case 8:
                    minicursos.editarDuracao(index, PreencheMinicurso.preencheDuracao());
                    break;
                default:
                    System.out.println("Opção incorreta!");
                    break;
            }
            
        } while (opcao != 0);
    }

    /**
     * Metodo responsavel pelo menu que é exibido na busca e na exibição de
     * todos os minicursos
     */
    private static void menuMinicurso() {
        int opcao;
        
        System.out.println("");
        opcao = InOut.inInt("Digite:"
                + "\n Para exibir mais informações sobre um minicurso, digite o"
                + " numero correspondente"
                + "\n DIGITE -1 PARA SAIR");
        
        if (opcao != -1) {
            System.out.println("");
            System.out.println(minicursos.getMinicurso(opcao));
        }
    } 
}
