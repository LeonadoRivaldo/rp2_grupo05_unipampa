package Repositorio.trabalho_1.resumo;

import Repositorio.trabalho_1.InterfaceSistema;
import Repositorio.trabalho_1.ListaSubmissao;
import Repositorio.trabalho_1.Situacao;
import Repositorio.trabalho_1.Submissao;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

 

public class InterfaceResumo extends InterfaceSistema {
         public static void main(String[] args) {
        InterfaceResumo resumo = new InterfaceResumo();
        resumo.principal();
    }

    private ListaSubmissao lista = new ListaSubmissao();
    private Resumo resumo;

    /**
     * Metodo principal que carrega todos os metodos do sistema 
     */
    @Override
    
    public void principal() {
        String titulo = null;
        int situacao;
        String autor;
        String instituicao;
        String palavrachave;
        Scanner e = new Scanner(System.in);

        int n = -1;
        do {
            System.out.println("===============================================");
            System.out.println("Índice  de resumos");
            System.out.println("===============================================");
            System.out.println("1)Cadastrar resumo");
            System.out.println("2)Pesquisar resumo");
            System.out.println("3)pesquisar resumo por autor");
            System.out.println("4)deletar resumo");
            System.out.println("5)editar resumo");
            System.out.println("0)sair do programa");
            System.out.print("Opção: ");
            n = e.nextInt();
            e.nextLine();
            switch (n) {
                case 1:
                    criarSubmissao();
                    break;
                case 2:
                   
                    Submissao sub = super.consultarSubmissaoTitulo("Digite o titulo que você quer pesquisar:", lista);
                    if (sub != null) {
                        exibirSubmissao(sub);
                    } else {
                        exibeMensagem("Resumo não encontrado!");
                    }
                    break;
                case 3:
                    String s = "Digite o titulo do resumo que você quer visualizar:";
                    List<Submissao> submissoes = consultarListaSubmissoesAutor(this.lista);
                    do {
                        if (submissoes != null) {
                            resumo = (Resumo) listaPorAutor(submissoes, this.lista, s);
                            if (resumo != null) {
                                exibirSubmissao(resumo);
                            } else {
                                exibeMensagem("resumo não encontrado");
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
                    } while (resumo == null);
                    break;

                case 4:
                    System.out.println("Digite o titulo do resumo  a ser deletado:");
                    titulo = e.nextLine();
                    if (lista.excluir(titulo)) {
                          exibeMensagem("Resumo excluido com sucesso");
                    } else {
                          exibeMensagem("Resumo não encontrado");
                    }
                    break;
                case 5:
                    editarSubmissao();
                case 0:
                    break;
            }
        } while (n != 0);
    }
/**
 * Metodo que exibe o menu da classe resumo
 * @return 
 */
    @Override
    protected int menu() {
        System.out.println("====================================");
        System.out.println("|| Gerenciamento de Resumo  ||");
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

    /**
     * 
     * @param submissao
     * @return 
     * Metodo que recebe o objeto que contem na lista de submissões
     */
    
    @Override
    protected int escolherAtributo(Submissao submissao) {
        Scanner e = new Scanner(System.in);
        resumo = (Resumo) submissao;
        System.out.println("---------------------------------------------------");
        System.out.println("DADOS");
        System.out.println("1-Titulo: " + resumo.getTituloSubmissao());
        System.out.print("2-Autor: ");
        for (String autor : resumo.getAutor()) {
            System.out.print(autor + " ,");
        }
        System.out.println("");
        System.out.print("3-Instituição: ");
        for (String instituicao : resumo.getInstituicao()) {
            System.out.print(instituicao + " ,");
        }
        System.out.println("");
        System.out.println("4-Situação: " + resumo.getSituacaoSubmissao().getNome());
        System.out.print("5-palavra chave: ");
        for (String palavrachave : resumo.getPalavrasChave()) {
            System.out.print(palavrachave + ", ");
        }
        System.out.println("");
        System.out.println("Opcao: ");
        return e.nextInt();
    }
    
    /**
     * Metodo que cria um novo resumo, pedindo os dados necessarios ao usuario final do sistema
     * como por exemplo , o titulo , a situação , os autores, as instituições e as palavras-chave
     */

    @Override
    protected void criarSubmissao() {

        String titulo = null;
        String situacao;
        String autor;
        String instituicao;
        String palavrachave;
        Situacao s = null;
        Scanner e = new Scanner(System.in);

        System.out.println("Titulo do resumo :");
        titulo = e.nextLine();

        do {
            System.out.println("Situação do resumo (Aprovado/Reprovado/sob avaliacao): ");
            s = Submissao.verificaSituacao(e.nextLine());
        } while (s == null);

        int o;
        ArrayList<String> autores = new ArrayList();
        do {
            System.out.println("Autores do resumo");
            autor = e.nextLine();
            System.out.println("Deseja adicionar mais um autor? (1-SIM 2-NÃO)");
            o = e.nextInt();
            autores.add(autor);
            e.nextLine();
        } while (o != 2);

        int op;
        ArrayList<String> instituicoes = new ArrayList();

        do {
            System.out.println("Insttituições do resumo");
            instituicao = e.nextLine();
            System.out.println("Deseja adicionar mais uma ? (1- SIM , 2-NÃO)");
            op = e.nextInt();
            instituicoes.add(instituicao);
            e.nextLine();
        } while (op != 2);

        int opcao;
        ArrayList<String> palavraschave = new ArrayList();
        do {
            System.out.println("Palavras-chaves do resumo: ");
            palavrachave = e.next();
            System.out.println("Deseja digitar outras palavras-chave?(1-SIM 2-NÃO)");
            opcao = e.nextInt();
            palavraschave.add(palavrachave);

        } while (opcao != 2);
        lista.incluir(new Resumo(titulo, s, autores, 8, instituicoes, palavraschave, 4, 8));
    }

    /**
     * Metodo que edita informações do resumo , podendo adicionar informações ou até mesmo as refazer
     */
    @Override
    protected void editarSubmissao() {
        Scanner e = new Scanner(System.in);
        System.out.println("Qual titulo vc quer editar ?");
        String titulo = e.nextLine();
        Resumo r = (Resumo) lista.consultarTitulo(titulo);

        if (r != null) {

            int atributo = escolherAtributo(r);
            String situacao;
            String autor;
            String instituicao;
            String palavrachave;
            String titulo1 = r.getTituloSubmissao();

            switch (atributo) {
                case 1:
                    System.out.println("Titulo do resumo :");
                    r.setTituloSubmissao(e.nextLine());
                    break;
                case 2:
                    int o;
                    System.out.println("Voce quer adicionar ou refazer a lista de autores ?");

                    if (e.nextLine().equalsIgnoreCase("add")) {
                        System.out.println("novo autor: ");
                        r.addAutor(e.nextLine());
                    } else {
                        ArrayList<String> autores = new ArrayList();
                        do {
                            System.out.println("Autores do resumo: ");
                            autores.add(e.nextLine());
                            System.out.println("Deseja adicionar mais um autor? (1-SIM 2-NÃO)");
                            o = e.nextInt();
                            e.nextLine();
                        } while (o != 2);
                        r.setAutor(autores);
                    }

                    break;
                case 3:
                    System.out.println("Voce quer adicionar ou refazer a lista de instituicoes?");
                    if (e.nextLine().equalsIgnoreCase("add")) {
                        System.out.println("nova instituicao:");
                        r.addInstituicao(e.nextLine());
                    } else {
                        int op;
                        ArrayList<String> instituicoes = new ArrayList();

                        do {
                            System.out.println("Insttituições do resumo: ");
                            instituicoes.add(e.nextLine());
                            System.out.println("Deseja adicionar mais uma ? (1- SIM , 2-NÃO)");
                            op = e.nextInt();
                            e.nextLine();
                        } while (op != 2);
                        r.setInstituicao(instituicoes);
                    }
                    break;
                case 4:
                    Situacao s = null;
                    do {
                        System.out.println("Situação do resumo (Aprovado/Reprovado/sob avaliacao): ");
                        situacao = e.nextLine();
                        s = Submissao.verificaSituacao(situacao);
                        r.setSituacaoSubmissao(s);
                    } while (s == null);
                    break;
                case 5:
                    System.out.println("Voce quer adicionar ou refazer a lista de palavras chaves?");
                    String escolha = e.nextLine();
                    if (escolha.equalsIgnoreCase("add")) {
                        System.out.println("Nova palavra chave:");
                        r.addPalavraChave(e.nextLine());
                    } else {
                        int opcao;
                        ArrayList<String> palavraschave = new ArrayList();
                        do {
                            System.out.println("Palavras-chaves do resumo: ");
                            palavraschave.add(e.nextLine());
                            System.out.println("Deseja digitar outras palavras-chave?(1-SIM 2-NÃO)");
                            opcao = e.nextInt();
                            e.nextLine();
                        } while (opcao != 2);
                        r.setPalavrasChave(palavraschave);
                    }
                    break;

            }
            lista.editar(titulo1, r);
        }else{
            exibeMensagem("Resumo não encontrado");
        }

    }
}
