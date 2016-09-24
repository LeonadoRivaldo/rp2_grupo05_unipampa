/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositorio.trabalho_1.minicurso;
import Repositorio.trabalho_1.ListaSubmissao;
import Repositorio.trabalho_1.InterfaceSistema;
import Repositorio.trabalho_1.Situacao;
import Repositorio.trabalho_1.Submissao;
import static Repositorio.trabalho_1.EntradasTeclado.*;
import static Repositorio.trabalho_1.PreencheSubmissao.*;
import java.util.List;
/**
 *
 * @author gilis
 */
public class InterfaceMinicurso extends InterfaceSistema {
    private ListaSubmissao lista = new ListaSubmissao();
    @Override
    public void principal() {
        int opcao;
        do {
            opcao = menu();
            switch (opcao) {
                case 0:
                    break;
                case 1:
                    criarSubmissao();
                    break;
                case 2:
                    exibir();
                    menuMinicurso();
                    break;
                case 3:
                    pesquisar();
                    break;
                case 4:
                    menuDeletar();
                    break;
                case 5:
                    editarSubmissao();
                    break;
                default:
                    break;
            }

        } while (opcao != 0);
    }
    @Override
    protected int menu() {
        int aux = 0;
        div();
        String mensagem = "Gerenciamento de minicursos"
                + "\nDigite:"
                + "\n 1- Para incluir"
                + "\n 2- Para exibir os minicursos cadastrados"
                + "\n 3- Para pesquisar"
                + "\n 4- Para excluir"
                + "\n 5- Para editar"
                + "\n 0- Para sair";

        while (aux < 1 || aux > 6) {
            aux = inInt(mensagem);
        }
        return aux;
    }
    @Override
    protected int escolherAtributo(Submissao submissao) {
        int aux = 0;
        Minicurso e = (Minicurso) submissao;
        String mensagem = "Digite o numero correspondente para editar:"
                + "\n" + e.toString()
                + "\n DIGITE 0 (ZERO) PARA SAIR)";

        while (aux < 0 || aux > 8) {
            div();
            aux = inInt(mensagem);
        }
        return aux;
    }
    @Override
    protected void criarSubmissao() {
        String titulo, resumo, abstrac, metodologia, recursos, situacaoString;
        int duracao, nroAutores = 0;
        List<String> autores;
        Situacao situacao;

        titulo = preencheTitulo();
        if (lista.consultarTitulo(titulo) == null) {
            while (nroAutores < 1 || nroAutores > 3) {
                nroAutores = inInt("Digite o numero de autores, NO MAXIMO 3:");
            }
            autores = preencheAutor(nroAutores);

            situacaoString = preencheSituacao();
            situacao = Situacao.verifica(situacaoString);
            resumo = preencheResumo();
            abstrac = preencheAbstract();
            metodologia = preencheMetodologia();
            recursos = preencheRecursos();
            duracao = preencheDuracao();

            Minicurso minicurso = new Minicurso(titulo, autores, resumo, situacao, abstrac,
                    metodologia, recursos, duracao);

            lista.incluir(minicurso);
            div();
            System.out.println("Minicurso criado com sucesso!");
        } else {
            System.out.println("Ja existe um minicurso com este nome, por favor tente novamente");
        }
    }
    @Override
    protected void editarSubmissao() {
        int atributo, nroAutores = 0;
        String oldTitulo;

        exibir();
        div();
        Minicurso e = (Minicurso) lista.consultarTitulo(inString("Digite o titulo do minicurso que deseja editar"));

        if (e == null) {
            System.out.println("Nao existe nenhum minicurso cadastrado com este titulo!");
        } else {
            oldTitulo = e.getTituloSubmissao();
            do {
                atributo = escolherAtributo(e);
                switch (atributo) {
                    case 0:
                        break;
                    case 1:
                        e.setTituloSubmissao(preencheTitulo());
                        break;
                    case 2:
                        String aux = preencheSituacao();
                        Situacao situacao = Situacao.verifica(aux);
                        e.setSituacaoSubmissao(situacao);
                        break;
                    case 3:
                        while (nroAutores < 1 || nroAutores > 3) {
                            nroAutores = inInt("Digite o numero de autores, NO MAXIMO 3:");
                        }
                        e.setAutor(preencheAutor(nroAutores));
                        break;
                    case 4:
                        e.setResumo(preencheResumo());
                        break;
                    case 5:
                        e.setAbstrac(preencheAbstract());
                        break;
                    case 6:
                        e.setDuracao(preencheDuracao());
                        break;
                    case 7:
                        e.setRecursos(preencheRecursos());
                        break;
                    case 8:
                        e.setMetodologia(preencheMetodologia());
                        break;
                    default:
                }
            } while (atributo != 0);
            lista.editar(oldTitulo, e);
        }

    }
    private void exibir() {
        List<Submissao> m = lista.getSubmissoes();

        div();
        System.out.println("Minicursos cadastrados:\n");

        if (m != null) {
            for (int i = 0; i < m.size(); i++) {
                Minicurso e = (Minicurso) m.get(i);
                System.out.println("\n" + i + " - Titulo: " + e.getTituloSubmissao()
                        + "      \tAutor(es): " + autoresToString(e.getTituloSubmissao()));
            }
        } else {
            System.out.println("Nenhum minicurso cadastrado");
        }
    }
    private void pesquisar() {
        String desejado = "";
        int tipo;

        do {
            div();
            tipo = inInt("Digite:"
                    + "\n 1 - Para pesquisar por autor"
                    + "\n 2 - Para pesquiasr por título");
            div();

            switch (tipo) {
                case 1:
                    desejado = inString("Digite o autor desejado:");
                    div();
                    System.out.println("Resultado da busca:");

                    List<Submissao> m = lista.consultarAutor(desejado);
                    if (m != null) {
                        for (int i = 0; i < m.size(); i++) {
                            Minicurso e = (Minicurso) m.get(i);
                            System.out.println("\n" + i + " - Titulo: " + e.getTituloSubmissao()
                                    + "      \tAutor(es): " + autoresToString(e.getTituloSubmissao()));
                        }
                        menuMinicurso();
                    } else {
                        System.out.println("Nenhum minicurso cadastrado");
                    }
                    break;

                case 2:
                    desejado = inString("Digite o título desejado:");
                    div();
                    System.out.println("Resultado da busca:");
                    if (lista.consultarTitulo(desejado) != null) {
                        System.out.println(lista.consultarTitulo(desejado).toString());
                    } else {
                        System.out.println("Nenhum minicurso encontrado");
                    }
                    break;
                default:
                    System.out.println("Você digitou uma opção incorreta!");
            }
        } while (tipo != 1 && tipo
                != 2);
    }
    private void menuDeletar() {
        int opcao = 0;

        div();
        while (opcao != 1 && opcao != 2) {
            opcao = inInt("Digite:"
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
    private void deletarPorTitulo() {
        String desejado;
        int opcao = 0;

        div();
        desejado = inString("Digite o título desejado:");
        if (lista.consultarTitulo(desejado) != null) {
            System.out.println(lista.consultarTitulo(desejado).toString());
            System.out.println("");
            div();
            while (opcao != 1 && opcao != 2) {
                opcao = inInt("Você tem certeza que deseja excluir este minicurso?"
                        + "Digite:"
                        + "\n 1 - Para excluir"
                        + "\n 2 - Para cancelar");
            }

            switch (opcao) {
                case 1:
                    if (lista.excluir(desejado)) {
                        System.out.println("Minicurso deletado com sucesso!");
                    } else {
                        System.out.println("Ocorreu algum erro. Verifique o que digitou");
                    }
                    div();
                    break;
                case 2:
                    break;
                default:
                    System.out.println("Opçao incorreta!");
                    break;
            }
        } else {
            System.out.println("Nenhum minicurso encontrado com este nome!");
        }
    }
    /**
     * Metodo responsavel pelo menu ao deletar um minicurso por lista
     */
    private void deletarPorLista() {
        int opcao = 0;
        String desejado;

        exibir();
        div();
        desejado = inString("Digite o titulo do minicurso que deseja excluir:");
        div();
        if (lista.consultarTitulo(desejado) != null) {
            System.out.println(lista.consultarTitulo(desejado).toString());
            System.out.println("");
            div();

            while (opcao != 1 && opcao != 2) {
                opcao = inInt("Você tem certeza que deseja excluir este minicurso?"
                        + "Digite:"
                        + "\n 1 - Para excluir"
                        + "\n 2 - Para cancelar");
            }

            switch (opcao) {
                case 1:
                    div();
                    if (lista.excluir(desejado)) {
                        System.out.println("Minicurso deletado com sucesso!");
                    } else {
                        System.out.println("Ocorreu algum erro. Verifique o que digitou");
                    }
                    break;
                case 2:
                    break;
                default:
                    System.out.println("Opçao incorreta!");
                    break;
            }
        } else {
            System.out.println("Nenhum minicurso encontrdo com este titulo!");
        }
    }
    /**
     * Metodo que transforma a List de autores do minicurso, na posição recebida
     * por parametro, em String
     *
     * @param titulo String titulo do minicurso
     * @return String dos autores
     */
    public String autoresToString(String titulo) {
        String dados = "";
        List<String> autores;

        autores = lista.consultarTitulo(titulo).getAutor();

        for (String s : autores) {
            dados += s + ", ";

        }
        return dados;
    }
    private void menuMinicurso() {
        String desejado;

        System.out.println("");
        desejado = inString("Digite:"
                + "\n Para exibir mais informações sobre um minicurso, digite o"
                + " titulo correspondente"
                + "\n DIGITE SAIR PARA SAIR");

        if (!desejado.equalsIgnoreCase("sair")) {
            System.out.println(desejado);
            Minicurso e = (Minicurso) lista.consultarTitulo(desejado);
            if (e == null) {
                System.out.println("Nenhum minicurso encontrado. Verifique o que voce digitou");
            } else {
                System.out.println(e.toString());
            }
        }
    }
}
