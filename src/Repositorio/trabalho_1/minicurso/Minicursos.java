package Repositorio.trabalho_1.minicurso;

import java.util.ArrayList;
import java.util.List;
import Repositorio.trabalho_1.Situacao;
import Repositorio.trabalho_1.Submissao;

/**
 * Classe que cria e modela objetos do tipo Minicurso
 */
public class Minicursos {
    
    private final ArrayList<Minicurso> lista;
    private Minicurso minicurso;

    /**
     * Construtor da classe Minicursos
     *
     * Cria o ArrayList lista que guarda todos os minicursos criados
     */
    public Minicursos() {
        lista = new ArrayList();
    }

    /**
     * Metodo responsavel por criar objetos do tipo Minicurso
     *
     * Seta todos os atributos do objeto criado
     *
     * Todos os parâmetros recebidos são do tipo String
     *
     * O numero maximo de autores é 3
     *
     * A situação deve ser: Sob avaliação, Aprovado, Não aprovado
     *
     * @param titulo Titulo do minicurso
     * @param autores Autores do minicurso
     * @param resumo Resumo do minicurso
     * @param situacao Situação do minicurso
     * @param abstrac Abstract do minicurso
     * @param metodologia Metodologia do minicurso
     * @param recursos Recursos do minicurso
     * @param duracao Duração do minicurso
     */
    public void criar(String titulo, List autores, String resumo, int situacao,
            String abstrac, String metodologia, String recursos, int duracao) {
        
        String pSituacao = situacaoToString(situacao);
        Situacao s;
        s = Submissao.verificaSituacao(pSituacao);
        minicurso = new Minicurso(titulo, autores, resumo, s,
                abstrac, metodologia, recursos, duracao);
        
        lista.add(minicurso);
    }

    /**
     * Metodo responsavel por buscar e exibir informações sobre um minicurso
     *
     * @param index Recebido para saber a posição do minicurso a ser buscado
     * @return Retorna um Arraylist pronto para ser exibido contendo todas as
     * informações do minicurso selecionado
     */
    public String getMinicurso(int index) {
        return (lista.get(index).toString());
    }

    /**
     * Metodo para excluir um minicurso informado
     *
     * @param index Index do minicurso que será deletado
     */
    public void excluir(int index) {
        lista.remove(index);
    }

    /**
     * Metodo responsavel por busca e exibir a lista de minicursos
     *
     * @return Retorna um ArrayList pronto para ser exibido contendo o autor e
     * titulo de todos os minicursos
     */
    public String getListaMinicursos() {
        String dados = "";
        
        for (int i = 0; i < lista.size(); i++) {
            dados += i + " - Titulo: " + lista.get(i).getTituloSubmissao()
                    + "     \tAutor(es): " + autoresToString(i);
        }
        return dados;
    }

    /**
     * Metodo responsavel por buscar e exibir minicursos que correspondam com os
     * dados desejados
     *
     * @param desejado Recebe o dado que deseja buscar, autor ou titulo
     * @param tipo Recebe o tipo da busca: por autor(1) ou por titulo(2)
     * @return Retorna um ArrayList pronto para exibir contrendo a lista de
     * minicursos encontrados na busca, contendo titulo e autor
     */
    public String buscar(String desejado, int tipo) {
        String dados = "";
        
        if (tipo == 1) {
            for (int i = 0; i < lista.size(); i++) {
                Minicurso m = lista.get(i);
                for (String e : m.getAutor()) {
                    if (e.equals(desejado)) {
                        dados += i + " - Titulo: " + lista.get(i).getTituloSubmissao()
                                + "      \tAutor(es): " + autoresToString(i);
                    }
                }
            }
            return dados;
        } else {
            for (int i = 0; i < lista.size(); i++) {
                if (lista.get(i).getTituloSubmissao().equals(desejado)) {
                    dados += i + " - Titulo: " + lista.get(i).getTituloSubmissao()
                            + "      \tAutor(es): " + autoresToString(i);
                }
            }
            return dados;
        }
    }


    public void editarTitulo(int index, String titulo) {
        lista.get(index).setTituloSubmissao(titulo);
    }
    
    public void editarAutores(int index, List autores) {
        lista.get(index).setAutor(autores);
    }
    
    public void editarSituacao(int index, int situacao) {
        String pSituacao = situacaoToString(situacao);
        Situacao s;
        s = Submissao.verificaSituacao(pSituacao);
        lista.get(index).setSituacaoSubmissao(s);
    }
    
    public void editarResumo(int index, String resumo) {
        lista.get(index).setResumo(resumo);
    }
    
    public void editarAbstract(int index, String abstac) {
        lista.get(index).setAbstrac(abstac);
    }
    
    public void editarRecursos(int index, String recursos) {
        lista.get(index).setRecursos(recursos);
    }
    
    public void editarMetodologia(int index, String metodologia) {
        lista.get(index).setMetodologia(metodologia);
    }
    
    public void editarDuracao(int index, int duracao) {
        lista.get(index).setDuracao(duracao);
    }
    
    public String autoresToString(int index) {
        String dados = "";
        List<String> autores;
        
        autores = lista.get(index).getAutor();
        
        for (String s : autores) {
            dados += s + ", ";
            
        }
        return dados;
    }
    
    public String situacaoToString(int situacao) {
        String pSituacao;
        switch (situacao) {
            case 1:
                pSituacao = "sob avaliacao";
                break;
            case 2:
                pSituacao = "aprovado";
                break;
            case 3:
                pSituacao = "reprovado";
                break;
            default:
                pSituacao = "sob avaliacao";
        }
        return pSituacao;
    }
}
