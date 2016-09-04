package Repositorio.trabalho_1.minicurso;

import java.util.ArrayList;
import java.util.List;
import Repositorio.trabalho_1.Situacao;
import Repositorio.trabalho_1.Submissao;

/**
 * Classe que cria e modela objetos do tipo Minicurso
 */
public class Minicursos {

    private ArrayList<Minicurso> lista;
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
     * Metodo que cria um novo minicurso
     *
     * @param titulo String do titulo
     * @param autores List dos autores
     * @param resumo String do resumo
     * @param situacao int da situação, que deve ser: 1 - para sob avaliação, 2
     * - para aprovado, 3 - para nao aprovado
     * @param abstrac String do abstract
     * @param metodologia String da metodologia
     * @param recursos String dos recursos
     * @param duracao int da duração, que deve ser em minutos, ou seja,
     * transformar as horas em minutos
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
     * @param index int index do minicurso a ser buscado
     * @return String contendo todos os dados, pronto para exibir
     */
    public String getMinicurso(int index) {
        return (lista.get(index).toString());
    }

    /**
     * Metodo para excluir um minicurso informado
     *
     * @param index int index do minicurso que será deletado
     */
    public void excluir(int index) {
        lista.remove(index);
    }

    /**
     * Metodo responsavel por busca e exibir a lista de minicursos
     *
     * @return String contendo todos os minicursos
     */
    public String getListaMinicursos() {
        String dados = "";

        for (int i = 0; i < lista.size(); i++) {
            dados += "\n" + i + " - Titulo: " + lista.get(i).getTituloSubmissao()
                    + "     \tAutor(es): " + autoresToString(i);
        }
        if (!dados.isEmpty()) {
            return dados;
        } else {
            return "Nenhum minicurso encontrado!";
        }
    }

    /**
     * Metodo que retorna os minicursos resultantes da busca, conforme os
     * parametros recebidos
     *
     * @param desejado String com o dado desejado
     * @param tipo int tipo, que deve ser: 1 - para pesquisa por autor, 2 - para
     * pesquisa por titulof
     * @return String contendo os minicursos econtrados
     */
    public String buscar(String desejado, int tipo) {
        String dados = "";

        if (tipo == 1) {
            for (int i = 0; i < lista.size(); i++) {
                Minicurso m = lista.get(i);
                for (String e : m.getAutor()) {
                    if (e.equalsIgnoreCase(desejado)) {
                        dados += "\n" + i + " - Titulo: " + lista.get(i).getTituloSubmissao()
                                + "      \tAutor(es): " + autoresToString(i);
                    }
                }
            }
            if (!dados.isEmpty()) {
                return dados;
            } else {
                return "Nenhum minicurso encontrado!";
            }
        } else {
            for (int i = 0; i < lista.size(); i++) {
                if (lista.get(i).getTituloSubmissao().equalsIgnoreCase(desejado)) {
                    dados += "\n" + i + " - Titulo: " + lista.get(i).getTituloSubmissao()
                            + "      \tAutor(es): " + autoresToString(i);
                }
            }
            if (!dados.isEmpty()) {
                return dados;
            } else {
                return "Nenhum minicurso encontrado!";
            }
        }
    }

    public void editarTitulo(int index, String titulo) {
        lista.get(index).setTituloSubmissao(titulo);
    }

    /**
     * Metodo que edita os autores do minicurso
     *
     * @param index int index do minicurso
     * @param autores List dos novos autores, maximo 3
     */
    public void editarAutores(int index, List autores) {
        if (autores.size() <= 3) {
            lista.get(index).setAutor(autores);
        }
    }

    /**
     * Metodo que edita a situação do minicurso
     *
     * @param index int index do minicurso
     * @param situacao int da situação, que deve ser: 1 - para sob avaliação, 2
     * - para aprovado, 3 - para nao aprovado
     */
    public void editarSituacao(int index, int situacao) {
        String pSituacao = situacaoToString(situacao);
        Situacao s;
        s = Submissao.verificaSituacao(pSituacao);
        lista.get(index).setSituacaoSubmissao(s);
    }

    /**
     * Metodo que edita o resumo do minicurso
     *
     * @param index int index do minicurso
     * @param resumo String do resumo
     */
    public void editarResumo(int index, String resumo) {
        lista.get(index).setResumo(resumo);
    }

    /**
     * Metodo que edita o abstract do minicurso
     *
     * @param index in index do minicurso
     * @param abstac String do abstract
     */
    public void editarAbstract(int index, String abstac) {
        lista.get(index).setAbstrac(abstac);
    }

    /**
     * Metodo que edita os recursos do minicurso
     *
     * @param index int index do minicurso
     * @param recursos String dos recursos
     */
    public void editarRecursos(int index, String recursos) {
        lista.get(index).setRecursos(recursos);
    }

    /**
     * Metodo que edita a metodologia do minicurso
     *
     * @param index int index do minicurso
     * @param metodologia String da metodologia
     */
    public void editarMetodologia(int index, String metodologia) {
        lista.get(index).setMetodologia(metodologia);
    }

    /**
     * Metodo que edita a duracao do minicurso
     *
     * @param index int index
     * @param duracao int duracao, que deve ser em minutos
     */
    public void editarDuracao(int index, int duracao) {
        lista.get(index).setDuracao(duracao);
    }

    /**
     * Metodo que transforma a List de autores do minicurso, na posição recebida
     * por parametro, em String
     *
     * @param index int index do minicurso
     * @return String dos autores
     */
    public String autoresToString(int index) {
        String dados = "";
        List<String> autores;

        autores = lista.get(index).getAutor();

        for (String s : autores) {
            dados += s + ", ";

        }
        return dados;
    }

    /**
     * Metodo que recebe a situacao em int por parametro e devolve uma String da
     * situacao
     *
     * @param situacao int da situação, que deve ser: 1 - para sob avaliação, 2
     * - para aprovado, 3 - para nao aprovado
     * @return String da situação (sob avaliacao, aprovado ou reprovado
     */
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
