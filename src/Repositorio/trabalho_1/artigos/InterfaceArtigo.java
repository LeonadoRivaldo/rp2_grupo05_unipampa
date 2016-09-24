/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositorio.trabalho_1.artigos;

import Repositorio.trabalho_1.InterfaceSistema;
import Repositorio.trabalho_1.ListaSubmissao;
import Repositorio.trabalho_1.Situacao;
import Repositorio.trabalho_1.Submissao;
import Repositorio.trabalho_1.monografias.novo.Monografia;
import java.util.List;
import java.util.Scanner;

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
                        exibeMensagem("Artigo não encontrada!");
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
                        exibeMensagem("ARTIGO EXCLUIDA");
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
        System.out.println("4-Instituicoes:"+artigo.getInstituicao());   
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
        String tituloSubmissao = PreencheArtigo.preencheTitulo();
        List<String> autores = PreencheArtigo.preencheAutor();
        List<String> instituicoes = PreencheArtigo.preencheInstituicao();
        String resumo = PreencheArtigo.preencheResumo();
        String Abstract = PreencheArtigo.preencheAbstract();
        List<String> palavrasChave = PreencheArtigo.preenchePalavrachave();
        Situacao situacao = null;
        do {
            situacao = Submissao.verificaSituacao(PreencheArtigo.preencheSituacao());
        } while (situacao == null);
        Artigo artigo = new Artigo(resumo, Abstract, tituloSubmissao, situacao, autores, 8, instituicoes, palavrasChave, 4, 8);

        
    }

    @Override
    protected void editarSubmissao() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}




