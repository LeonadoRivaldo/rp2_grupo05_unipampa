/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositorio.trabalho_1.artigos;

import Repositorio.trabalho_1.InterfaceSistema;
import Repositorio.trabalho_1.ListaSubmissao;
import Repositorio.trabalho_1.PreencheSubmissao;
import Repositorio.trabalho_1.Situacao;
import Repositorio.trabalho_1.Submissao;
import java.util.List;

/**
 *
 * @author Amanda Gobus
 */
public class InterfaceArtigo extends InterfaceSistema {

    private ListaSubmissao lista = new ListaSubmissao();
    private Artigo artigo;

    @Override
    public void principal() {

        System.out.print("Opção :");
        int opcao = 0;
        do {
            opcao = menu();
            switch (opcao) {
                case 0:
                    break;
                case 1:
                    criarSubmissao();
                    break;
                case 2:
                    entrada.nextLine();
                    Submissao sub = super.consultarSubmissaoTitulo("Digite o titulo que você quer pesquisar:", lista);
                    if (artigo != null) {
                        exibirSubmissao(sub);
                    } else {
                        exibeMensagem("Artigo não encontrado!");
                    }

                    break;
                case 3:
                    String s = "Digite o titulo da artigo que você quer visualizar:";
                    List<Submissao> submissoes = consultarListaSubmissoesAutor(this.lista);
                    do {
                        if (submissoes != null) {
                            artigo = (Artigo) listaPorAutor(submissoes, this.lista, s);
                            if (artigo != null) {
                                exibirSubmissao(artigo);
                            } else {
                                exibeMensagem("Artigo não encontrada");
                                System.out.println("Deseja pesquisar novamente?");
                                if (!entrada.nextLine().equalsIgnoreCase("sim")) {
                                    break;
                                }
                            }
                        } else {
                            exibeMensagem("Autor não encontrado");
                            System.out.println("Deseja pesquisar novamente?");
                            if (!entrada.nextLine().equalsIgnoreCase("sim")) {
                                break;
                            }
                        }
                    } while (artigo == null);
                    break;
                case 4:
                    System.out.println("Qual titulo do artigo vocë quer excluir: ");
                    String t = entrada.nextLine();
                    if (lista.excluir(t)) {
                        exibeMensagem("ARTIGO EXCLUIDO");
                    } else {
                        exibeMensagem("NAO FOI ENCONTRAD0 NENHUM ARTIGO");
                    }
                    break;
                case 5:
                    editarSubmissao();
                    break;
            }

        } while (opcao != 0);

    }

    @Override
    protected int menu() {
        System.out.println("====================================");
        System.out.println("||   Gerenciamento de Artigos     ||");
        System.out.println("|| -----------------------------  ||");
        System.out.println("||  1- Incluir                    ||");
        System.out.println("||  2- Consultar                  ||");
        System.out.println("||  3- Consultar por autor        ||");
        System.out.println("||  4- Excluir                    ||");
        System.out.println("||  5- Editar                     ||");
        System.out.println("||  0- Sair                       ||");
        System.out.println("====================================");
        System.out.print("Opção: ");
        return entrada.nextInt();
    }

    @Override
    protected int escolherAtributo(Submissao submissao) {
        Artigo artigo = (Artigo) submissao;
        System.out.println("==================================");
        System.out.println("1-Titulo: " + artigo.getTituloSubmissao());
        System.out.println("2-Autor: " + artigo.getAutor().get(0));
        System.out.println("3-Situacao: " + artigo.getSituacaoSubmissao().getNome());
        System.out.println("4-Instituicoes:" + artigo.getInstituicao());
        System.out.println("5-Resumo: " + artigo.getResumo());
        System.out.println("6-Abstract: " + artigo.getAbstract());
        System.out.print("7-Palavras-chaves: ");
        List<String> palavras = artigo.getPalavrasChave();
        for (String palavra : palavras) {
            System.out.print(palavra + ", ");
        }
        System.out.println("");
        System.out.println("==================================");
        return (entrada.nextInt());
    }

    @Override
    protected void criarSubmissao() {
        String tituloSubmissao = PreencheSubmissao.preencheTitulo();
        List<String> autores = PreencheSubmissao.preencheAutor(8);
        List<String> instituicoes = PreencheSubmissao.preencheInstituicaoArtigo(8);
        String resumo = PreencheSubmissao.preencheResumo();
        String Abstract = PreencheSubmissao.preencheAbstract();
        List<String> palavrasChave = PreencheSubmissao.preenchePalavrasChaves();
        Situacao situacao = null;
        do {
            situacao = Submissao.verificaSituacao(PreencheSubmissao.preencheSituacao());
        } while (situacao == null);
        Artigo artigo = new Artigo(resumo, Abstract, tituloSubmissao, situacao, autores, 8, instituicoes, palavrasChave, 4, 8);

        lista.incluir(artigo);

    }

    @Override
    protected void editarSubmissao() {
        System.out.println("Qual titulo do artigo vocë quer editar: ");
        String t = entrada.nextLine();
        artigo = (Artigo) lista.consultarTitulo(t);
        if (artigo != null) {
            int atributo = escolherAtributo(artigo);
            String oldTitulo = artigo.getTituloSubmissao();
            switch (atributo) {
                case 1:
                    artigo.setTituloSubmissao(PreencheSubmissao.preencheTitulo());
                    break;
                case 2:

                    List<String> autores = PreencheSubmissao.preencheAutor(8);

                    artigo.setAutor(autores);
                    break;
                case 3:

                    List<String> instituicoes = PreencheSubmissao.preencheInstituicaoArtigo(8);

                    artigo.setInstituicao(instituicoes);
                    break;
                case 4:

                    List<String> palavras = PreencheSubmissao.preenchePalavrasChaves();

                    artigo.setPalavrasChave(palavras);
                    break;
                case 5:
                    artigo.setResumo(PreencheSubmissao.preencheResumo());
                    break;
                case 6:
                    artigo.setAbstract(PreencheSubmissao.preencheAbstract());
                    break;
                case 7:
                    Situacao situacao = null;
                    situacao = Submissao.verificaSituacao(PreencheSubmissao.preencheSituacao());
                    while (situacao == null) {
                        situacao = Submissao.verificaSituacao(PreencheSubmissao.preencheSituacao());
                    }
                    artigo.setSituacaoSubmissao(situacao);
                    break;
            }
            lista.editar(oldTitulo, artigo);
        }

    }

    public static void main(String[] args) {
        InterfaceArtigo a = new InterfaceArtigo();
        a.principal();
    }
}
