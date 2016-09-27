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
 * @author Giliardi Schmidt
 */
/**
 * Classe responsável pela parte do Minicurso
 *
 * @author Giliardi Schmidt
 */
public class InterfaceMinicurso extends InterfaceSistema {

    private ListaSubmissao lista = new ListaSubmissao();

    /**
     * Menu que deve ser chamado para acessar as opções dos minicursos
     */
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
                    deletar();
                    break;
                case 5:
                    editarSubmissao();
                    break;
                default:
                    break;
            }

        } while (opcao != 0);
    }

    /**
     * Menu principal contendo todas as opções para modificar a lista de
     * minicursos
     *
     * @return int da opção selecionada pelo usuario:
     *
     * 1 - incluir, 2 - exibir todos os minicursos, 3 - pesquisar, 4 - excluir,
     * 5 - editar, 0 - sair
     */
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

    /**
     * Metodo que exibe um minicurso e pede ao usuario para digitar um int
     * correspondente ao atributo do minicurso, usando o metodo .toString
     *
     * @param submissao Submissão que será exibida
     * @return int do atributo selecionado:
     *
     * 1 - titulo, 2 - situação, 3 - autores, 4 - resumo, 5 - abstract, 6 -
     * duração, 7 - recursos, 8 - metodologia
     */
    @Override
    protected int escolherAtributo(Submissao submissao) {
        int aux = -1;
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

    /**
     * Metodo responsavel por criar uma submissao. Pede ao usuario para inserir
     * todas as informações, cria e salva o minicurso na lista
     */
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

    /**
     * Metodo responsavel pela edição de um minicurso. Pede ao usuario qual
     * atributo deseja editar, edita e salva as mudanças na lista.
     */
    @Override
    protected void editarSubmissao() {
        int atributo, nroAutores = 0;
        String oldTitulo;

        exibir();
        div();
        Minicurso e = (Minicurso) lista.consultarTitulo(inString("Digite o titulo do minicurso que deseja editar"));

        if (e != null) {
            do {
                oldTitulo = e.getTituloSubmissao();
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
                        break;
                }
                lista.editar(oldTitulo, e);
            } while (atributo != 0);

        } else {
            System.out.println("Nao existe nenhum minicurso cadastrado com este titulo!");
        }
    }

    /**
     * Metodo responsavel por exibir todos os minicursos cadastrados.
     */
    private void exibir() {
        List<Submissao> m = lista.getSubmissoes();

        div();
        System.out.println("Minicursos cadastrados:\n");

        if (m == null) {
            System.out.println("Nenhum minicurso cadastrado");
        } else {
            for (int i = 0; i < m.size(); i++) {
                Minicurso e = (Minicurso) m.get(i);
                System.out.println("\n" + i + " - Titulo: " + e.getTituloSubmissao()
                        + "      \tAutor(es): " + autoresToString(e.getTituloSubmissao()));
            }
        }
    }

    /**
     * Metodo responsavel pela pesquisa. A pesquisa pode ser por autor ou por
     * titulo, como o usuario escolher
     */
    private void pesquisar() {
        int tipo;

        do {
            div();
            tipo = inInt("Digite:"
                    + "\n 1 - Para pesquisar por autor"
                    + "\n 2 - Para pesquiasr por título");
            switch (tipo) {
                case 1:
                    List<Submissao> m = super.consultarListaSubmissoesAutor(lista);
                    if (m != null) {
                        int cont = 0;
                        for (Submissao s : m) {
                            Minicurso e = (Minicurso) s;
                            System.out.println("\n" + cont + " - Titulo: " + e.getTituloSubmissao()
                                    + "      \tAutor(es): " + autoresToString(e.getTituloSubmissao()));
                            cont++;
                        }
                        menuMinicurso();
                    } else {
                        System.out.println("Nenhum minicurso cadastrado");
                    }
                    break;
                case 2:
                    Minicurso resultadoBuscaTitulo = (Minicurso) super.consultarSubmissaoTitulo("Digite o titulo desejado", lista);
                    if (resultadoBuscaTitulo != null) {
                        System.out.println(resultadoBuscaTitulo.toString());
                    } else {
                        System.out.println("Nenhum minicurso encontrado");
                    }
                    break;
                default:
                    System.out.println("Você digitou uma opção incorreta!");
            }
        } while (tipo != 1 && tipo != 2);
    }

    /**
     * Metodo responsavel pelo menu de deletar
     */
    private void deletar() {
        int opcao = 0;

        div();
        while (opcao != 1 && opcao != 2) {
            opcao = inInt("Digite:"
                    + "\n 1 - Para exibir a lista de minicursos e selecionar qual deseja deletar"
                    + "\n 2 - Para inserir o titulo que deseja deletar");
        }
        switch (opcao) {
            case 1:
                exibir();
                div();
                super.excluirSubmissao(lista, "Digite o titulo do minicurso que deseja excluir:");
                break;
            case 2:
                super.excluirSubmissao(lista, "Digite o titulo do minicurso que deseja excluir");
                break;
            default:
                break;
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

    /**
     * Metodo responsavel por exibir um menu ao usuario nas listas de minicursos
     */
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
