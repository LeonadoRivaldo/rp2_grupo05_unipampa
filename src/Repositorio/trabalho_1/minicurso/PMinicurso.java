package Repositorio.trabalho_1.minicurso;

import java.util.ArrayList;

/**
 * Classe principal, cria e manipula um objeto do tipo Minicursos e o que será
 * exibido ao usuario
 */
public class PMinicurso {

    private static Minicursos minicursos = new Minicursos();

    /**
     * Metodo main, chama o menu principal
     *
     * 
     */
    public static void principal() {
        InOut.outL("MINICURSOS");
        minicursosPreDefinidos();
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
        String titulo, autores, resumo, abstrac, metodologia, duracao, recursos;
        String situacao = "";
        int nAutores = 0, nSituacao = 0;

        InOut.div();

        while (nAutores < 1 || nAutores > 3) {
            nAutores = InOut.inInt("Digite o numero de autores (maximo 3):");
        }
        InOut.div();
        while (nSituacao < 1 || nSituacao > 3) {
            nSituacao = InOut.inInt("Digite a situação do minicurso:"
                    + "\n 1 - Sob Avaliação"
                    + "\n 2 - Aprovado"
                    + "\n 3 - Não aprovado");
        }
        InOut.div();

        titulo = InOut.inString("Digite o título:");
        autores = InOut.inString("Digite o nome do autor: ") + " ";
        if (nAutores >= 2) {
            autores += ", " + InOut.inString("Digite o nome do autor 2:");
        }
        if (nAutores == 3) {
            autores += ", " + InOut.inString("Digite o nome do autor 3:");
        }
        resumo = InOut.inString("Digite o resumo:");
        abstrac = InOut.inString("Digite o abstract:");
        metodologia = InOut.inString("Digite a metodologia:");
        recursos = InOut.inString("Digite os recursos:");
        duracao = InOut.inString("Digite a duração:");

        if (nSituacao == 1) {
            situacao = "Sob avaliação";
        }
        if (nSituacao == 2) {
            situacao = "Aprovado";
        }
        if (nSituacao == 3) {
            situacao = "Não aprovado";
        }

        minicursos.setMinicurso(titulo, autores, resumo, situacao, abstrac,
                metodologia, recursos, duracao);
        InOut.div();
        InOut.outL("Minicurso criado com sucesso!");

    }

    /**
     * Metodo responsavel por exibir os minicursos existentes
     */
    private static void exibir() {
        ArrayList minicursosCadastrados = new ArrayList();

        minicursosCadastrados = minicursos.getMinicursos(minicursosCadastrados);
        InOut.div();
        InOut.outL("Minicursos cadastrados:\n");
        InOut.outArrayList(minicursosCadastrados);
    }

    /**
     * Metodo responsavel pela pesquisa de minicursos
     */
    private static void pesquisar() {
        ArrayList resultadoBusca = new ArrayList();
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

        resultadoBusca = minicursos.search(desejado, tipo, resultadoBusca);
        InOut.div();
        InOut.outL("Resultado da busca:");
        System.out.println("");
        InOut.outArrayList(resultadoBusca);
    }

    /**
     * Metodo responsavel por deletar um minicurso
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
                    minicursos.deleteMinicurso(minicursoSelecionado);
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
        int nAutores, nSituacao, indexMinicursoSelecionado;

        exibir();
        InOut.div();
        indexMinicursoSelecionado = InOut.inInt("Digite o numero do minicurso que deseja editar:");
        InOut.div();

        do {
            ArrayList minicursoSelecionado = new ArrayList();
            InOut.outL("Minicurso selecionado: ");
            System.out.println("");
            minicursos.getMinicurso(indexMinicursoSelecionado, minicursoSelecionado);
            InOut.outArrayList(minicursoSelecionado);
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
                    novoDado = (InOut.inString("Digite o título:"));
                    minicursos.edit(opcao, indexMinicursoSelecionado, novoDado);
                    break;
                case 2:
                    nAutores = 0;
                    while (nAutores < 1 || nAutores > 3) {
                        nAutores = InOut.inInt("Digite o numero de autores (maximo 3):");
                    }
                    novoDado = InOut.inString("Digite o nome do autor: ");
                    if (nAutores >= 2) {
                        novoDado += ", " + InOut.inString("Digite o nome do autor 2:");
                    }
                    if (nAutores == 3) {
                        novoDado += ", " + InOut.inString("Digite o nome do autor 3:");
                    }
                    minicursos.edit(opcao, indexMinicursoSelecionado, novoDado);
                    break;
                case 3:
                    novoDado = "";
                    nSituacao = 0;
                    while (nSituacao < 1 || nSituacao > 3) {
                        nSituacao = InOut.inInt("Digite a situação do minicurso:"
                                + "\n 1 - Sob Avaliação"
                                + "\n 2 - Aprovado"
                                + "\n 3 - Não aprovado");
                    }

                    if (nSituacao == 1) {
                        novoDado = "Sob aprovação";
                    } else if (nSituacao == 2) {
                        novoDado = "Aprovado";
                    } else if (nSituacao == 3) {
                        novoDado = "Não Aprovado";
                    }

                    minicursos.edit(opcao, indexMinicursoSelecionado, novoDado);
                    break;
                case 4:
                    novoDado = InOut.inString("Digite o resumo:");
                    minicursos.edit(opcao, indexMinicursoSelecionado, novoDado);
                    break;
                case 5:
                    novoDado = InOut.inString("Digite o abstract:");
                    minicursos.edit(opcao, indexMinicursoSelecionado, novoDado);
                    break;
                case 6:
                    novoDado = InOut.inString("Digite os recursos");
                    minicursos.edit(opcao, indexMinicursoSelecionado, novoDado);
                    break;
                case 7:
                    novoDado = InOut.inString("Digite a metodologia:");
                    minicursos.edit(opcao, indexMinicursoSelecionado, novoDado);
                    break;
                case 8:
                    novoDado = InOut.inString("Digite a duração:");
                    minicursos.edit(opcao, indexMinicursoSelecionado, novoDado);
                    break;
                default:
                    InOut.outL("Opção incorreta!");
                    break;
            }

        } while (opcao != 0);
    }

    /**
     * Metodo responsavel pelo menu que é exibido na busca e na exibição de
     * todos os minicursos
     */
    private static void menuMinicurso() {
        ArrayList minicursoSelecionado = new ArrayList();
        int opcao;

        System.out.println("");
        opcao = InOut.inInt("Digite:"
                + "\n Para exibir mais informações sobre um minicurso, digite o"
                + " numero correspondente"
                + "\n DIGITE -1 PARA SAIR");

        if (opcao != -1) {
            System.out.println("");
            minicursoSelecionado = minicursos.getMinicurso(opcao, minicursoSelecionado);
            InOut.outArrayList(minicursoSelecionado);
        }
    }

    /**
     * Metodo que cria 2 objetos do tipo Minicurso pré definidos
     * 
     * TEMPORARIA
     */
    private static void minicursosPreDefinidos() {
        String titulo, autores, resumo, abstrac, metodologia, duracao, recursos, situacao;

        //Minicurso 1
        situacao = "Sob avaliação";
        titulo = "Titulo legal";
        autores = "Fulano";
        resumo = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. ";
        abstrac = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. ";
        metodologia = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. ";
        duracao = "3 horas";
        recursos = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. ";
        minicursos.setMinicurso(titulo, autores, resumo, situacao, abstrac, metodologia, recursos, duracao);

        //Minicurso 2
        situacao = "Sob avaliação";
        titulo = "Aulas gratis";
        autores = "Ciclano";
        resumo = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. ";
        abstrac = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. ";
        metodologia = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. ";
        duracao = "2 tardes, 2 horas por tarde";
        recursos = "Lorem ips um dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. ";
        minicursos.setMinicurso(titulo, autores, resumo, situacao, abstrac, metodologia, recursos, duracao);
    }
}
