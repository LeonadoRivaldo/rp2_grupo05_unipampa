/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositorio.trabalho_1.monografias.novo;

import Repositorio.trabalho_1.ListaSubmissao;
import Repositorio.trabalho_1.Situacao;
import Repositorio.trabalho_1.Submissao;
import Repositorio.trabalho_1.InterfaceSistema;
import Repositorio.trabalho_1.PreencheSubmissao;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author leona_000
 */
public class InterfaceMonografia extends InterfaceSistema {

    private ListaSubmissao lista = new ListaSubmissao();
    private Monografia monografia;

    @Override
    public void principal() {
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
                    if (monografia != null) {
                        exibirSubmissao(sub);
                    } else {
                        exibeMensagem("Monografia não encontrada!");
                    }
                    break;
                case 3:
                    String s = "Digite o titulo da monografia que você quer visualizar:";
                    List<Submissao> submissoes = consultarListaSubmissoesAutor(this.lista);
                    do {
                        if (submissoes != null) {
                            monografia = (Monografia) listaPorAutor(submissoes, this.lista, s);
                            if (monografia != null) {
                                exibirSubmissao(monografia);
                            } else {
                                exibeMensagem("monografia não encontrada");
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
                    } while (monografia == null);
                    break;
                case 4:
                    
                    break;
                default:
                    throw new AssertionError();
            }
        } while (opcao != 0);
    }

    @Override
    protected int menu() {
        System.out.println("====================================");
        System.out.println("|| Gerenciamento de monograficas  ||");
        System.out.println("|| -----------------------------  ||");
        System.out.println("||  1- incluir                    ||");
        System.out.println("||  2- consultar                  ||");
        System.out.println("||  3- consultar por autor        ||");
        System.out.println("||  4- excluir                    ||");
        System.out.println("||  5- editar                     ||");
        System.out.println("||  0- sair                       ||");
        System.out.println("====================================");
        System.out.print("Opção: ");
        return entrada.nextInt();
    }

    @Override
    protected int escolherAtributo(Submissao submissao) {
        Scanner entrada = new Scanner(System.in);
        monografia = (Monografia) submissao;
        int in = -1;
        do {
            System.out.println("===================================================");
            System.out.println("1-Titulo: " + monografia.getTituloSubmissao());
            System.out.println("2-Situacao: " + monografia.getSituacaoSubmissao().getNome());
            System.out.println("3-Tipo: " + monografia.getTipo().getNome());
            System.out.println("4-Autor: " + monografia.getAutor().get(0));
            System.out.println("5-Instituição: " + monografia.getInstituicao().get(0));
            System.out.println("6-Orientador: " + monografia.getOrientador());
            System.out.println("7-Curso: " + monografia.getCurso());
            System.out.println("8-Ano: " + monografia.getAno());
            System.out.println("9-Numero De Paginas: " + monografia.getNumeroDePaginas());
            System.out.print("10-Palavras-chaves: ");
            List<String> palavras = monografia.getPalavrasChave();
            for (String palavra : palavras) {
                System.out.print(palavra + ", ");
            }
            System.out.println("");
            System.out.println("11-Resumo: " + monografia.getResumo());
            System.out.println("12-Abstract: " + monografia.getAbstract());
            System.out.println("===================================================");
            System.out.print("Qual atributo você quer editar: ");
            in = entrada.nextInt();
            if (in > 12 || in < 1) {
                exibeMensagem("digito invalido");
            }
        } while (in > 12 || in < 1);
        return in;
    }

    @Override
    protected void criarSubmissao() {
        String tituloSubmissao = PreencheSubmissao.preencheTitulo();
        List<String> autores = PreencheSubmissao.preencheAutor();
        Situacao situacaoSubmissao = null;
        do {
            String situacao = PreencheSubmissao.preencheSituacao();
            situacaoSubmissao = Submissao.verificaSituacao(situacao);
        } while (situacaoSubmissao == null);
        Tipo tipoMonografia = null;
        do {
            String tipo = PreencheSubmissao.preencheTipo();
            tipoMonografia = Submissao.verificaTipo(tipo);
        } while (tipoMonografia == null);

        String instituicao = PreencheSubmissao.preencheInstituicao();
        List<String> instituicoes = new ArrayList();
        instituicoes.add(instituicao);
        String orientador = PreencheSubmissao.preencheOrientador();
        String curso = PreencheSubmissao.preencheCurso();
        int ano = Integer.parseInt(PreencheSubmissao.preencheAno());
        int numeroDePaginas = Integer.parseInt(PreencheSubmissao.preencheNroPaginas());
        List<String> palavrasChave = PreencheSubmissao.preenchePalavrasChaves();
        String resumo = PreencheSubmissao.preencheResumo();
        String Abstract = PreencheSubmissao.preencheAbstract();

        int MAX_AUTORES = 1;
        int MAX_PALAVRASCHAVES = 4;
        int MAX_INSTITUICOES = 1;
        System.out.println("===============================================");
        monografia = new Monografia(tipoMonografia, orientador, curso, ano, numeroDePaginas, resumo, Abstract, tituloSubmissao, situacaoSubmissao, autores, MAX_AUTORES, instituicoes, palavrasChave, MAX_PALAVRASCHAVES, MAX_INSTITUICOES);
        if (lista.incluir(submissao)) {
            exibeMensagem("Monografia criada com sucesso!");
        }
    }

    @Override
    protected void editarSubmissao() {
        monografia = (Monografia) consultarSubmissaoTitulo("Digite o titulo da monografia que você quer pesquisar:", lista);
        String oldTitulo = monografia.getTituloSubmissao();
        int atributo = escolherAtributo(monografia);
        switch (atributo) {
            case 1:
                monografia.setTituloSubmissao(PreencheSubmissao.preencheTitulo());
                break;
            case 3:
                Tipo tipoMonografia = null;
                tipoMonografia = Submissao.verificaTipo(PreencheSubmissao.preencheTipo());
                while (tipoMonografia == null) {
                    tipoMonografia = Submissao.verificaTipo(PreencheSubmissao.preencheTipo());
                }
                monografia.setTipo(tipoMonografia);
                break;
            case 2:
                Situacao situacao = null;
                situacao = Submissao.verificaSituacao(PreencheSubmissao.preencheSituacao());
                while (situacao == null) {
                    situacao = Submissao.verificaSituacao(PreencheSubmissao.preencheSituacao());
                }
                monografia.setSituacaoSubmissao(situacao);
                break;
            case 4:
                List<String> autor = PreencheSubmissao.preencheAutor();
                monografia.setAutor(autor);
                break;
            case 5:
                String s = PreencheSubmissao.preencheInstituicao();
                List<String> insti = new ArrayList<String>();
                insti.add(s);
                monografia.setInstituicao(insti);
                break;
            case 6:
                monografia.setOrientador(PreencheSubmissao.preencheOrientador());
                break;
            case 7:
                monografia.setCurso(PreencheSubmissao.preencheCurso());
                break;
            case 8:
                monografia.setAno(Integer.parseInt(PreencheSubmissao.preencheAno()));
                break;
            case 9:
                monografia.setNumeroDePaginas(Integer.parseInt(PreencheSubmissao.preencheAno()));
                break;
            case 10:
                List<String> palavras = PreencheSubmissao.preenchePalavrasChaves();
                monografia.setPalavrasChave(palavras);
                break;
            case 11:
                monografia.setResumo(PreencheSubmissao.preencheResumo());
                break;
            case 12:
                monografia.setAbstract(PreencheSubmissao.preencheAbstract());
                break;
        }
    }

    public static void main(String[] args) {
        InterfaceMonografia i = new InterfaceMonografia();
        i.principal();
    }

}
