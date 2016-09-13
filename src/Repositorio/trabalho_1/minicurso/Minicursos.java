package Repositorio.trabalho_1.minicurso;

import Repositorio.trabalho_1.ListaSubmissao;
import java.util.List;
import Repositorio.trabalho_1.Situacao;
import Repositorio.trabalho_1.Submissao;

/**
 * Classe que cria e modela objetos do tipo Minicurso
 */
public class Minicursos {

    //private ArrayList<Minicurso> listaMinicursos;
    private ListaSubmissao listaMinicursos = new ListaSubmissao();
    private Minicurso minicurso;

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

        listaMinicursos.incluir(minicurso);
    }

    /**
     * Metodo responsavel por buscar e exibir informações sobre um minicurso
     *
     * @param titulo String titulo do minicurso a ser exibido
     * @return String contendo todos os dados, pronto para exibir
     */
    public String getMinicurso(String titulo) {
        Minicurso e = (Minicurso) listaMinicursos.consultarTitulo(titulo);
        if (e != null) {
            return e.toString();
        } else {
            return null;
        }
    }

    /**
     * Metodo para excluir um minicurso informado
     *
     * @param titulo Strint titulo do minicurso que será deletado
     * @return Boolean, true caso foi excluido, false caso nao foi
     */
    public boolean excluir(String titulo) {
        return listaMinicursos.excluir(titulo);
    }

    /**
     * Metodo responsavel por busca e exibir a listaMinicursos de minicursos
     *
     * @return ArrayList com titulo e autores de cada submissao: Nas posições
     * pares os titulos e nas ímpares os autores. EX: posiçao 0 = titulo do
     * minicurso A, posição 1 = autores do minicurso A. Caso não exista nenhum
     * minicurso cadastrado, retorna null.
     *
     */
    public String getListaMinicursos() {
        String dados = "";
        List<Submissao> m = listaMinicursos.getSubmissoes();

        for (int i = 0; i < m.size(); i++) {
            Minicurso e = (Minicurso) m.get(i);
            dados += "\n" + i + " - Titulo: " + e.getTituloSubmissao()
                    + "      \tAutor(es): " + autoresToString(e.getTituloSubmissao());
        }

        if (!dados.isEmpty()) {
            return dados;
        } else {
            return null;
        }
    }

    /**
     * Metodo que retorna os minicursos resultantes da busca, conforme os
     * parametros recebidos
     *
     * @param desejado String com o dado desejado
     * @param tipo int tipo, que deve ser: 1 - para pesquisa por autor, 2 - para
     * pesquisa por titulo
     *
     * Caso a busca seja por titulo, será retornado todas as informações do
     * Minicurso, em String. f
     * @return String contendo os minicursos econtrados
     */
    public String buscar(String desejado, int tipo) {
        String dados = "";
        List<Submissao> m = listaMinicursos.getSubmissoes();

        if (tipo == 1) {
            for (int i = 0; i < m.size(); i++) {
                Minicurso e = (Minicurso) m.get(i);
                for (String a : e.getAutor()) {
                    if (a.equalsIgnoreCase(desejado)) {
                        dados += "\n" + i + " - Titulo: " + e.getTituloSubmissao()
                                + "      \tAutor(es): " + autoresToString(e.getTituloSubmissao());
                    }
                }
            }
            if (!dados.isEmpty()) {
                return dados;
            } else {
                return "Nenhum minicurso encontrado!";
            }
        } else {
            for (int i = 0; i < m.size(); i++) {
                Minicurso e = (Minicurso) m.get(i);
                if (e.getTituloSubmissao().equalsIgnoreCase(desejado)) {
                    return e.toString();
                }
            }
            return "Nenhum minicurso encontrado!";
        }
    }

    /**
     * Metodo que edita o titulo do minicuros
     * 
     * @param titulo String do titulo do minicurso
     * @param novoTitulo String do novo titulo
     */
    public void editarTitulo(String titulo, String novoTitulo) {
        Minicurso e = (Minicurso) listaMinicursos.consultarTitulo(titulo);
        e.setTituloSubmissao(novoTitulo);
    }

    /**
     * Metodo que edita os autores do minicurso
     *
     * @param titulo String do titulo do minicurso
     * @param autores List dos novos autores, maximo 3
     */
    public void editarAutores(String titulo, List autores) {
        Minicurso e = (Minicurso) listaMinicursos.consultarTitulo(titulo);
        if (autores.size() <= 3) {
            e.setAutor(autores);
        }
    }

    /**
     * Metodo que edita a situação do minicurso
     *
     * @param titulo String do titulo do minicurso
     * @param situacao int da situação, que deve ser: 1 - para sob avaliação, 2
     * - para aprovado, 3 - para nao aprovado
     */
    public void editarSituacao(String titulo, int situacao) {
        Minicurso e = (Minicurso) listaMinicursos.consultarTitulo(titulo);
        String pSituacao = situacaoToString(situacao);
        Situacao s;
        s = Submissao.verificaSituacao(pSituacao);
        e.setSituacaoSubmissao(s);
    }

    /**
     * Metodo que edita o resumo do minicurso
     *
     * @param titulo String do titulo do minicurso
     * @param resumo String do resumo
     */
    public void editarResumo(String titulo, String resumo) {
        Minicurso e = (Minicurso) listaMinicursos.consultarTitulo(titulo);
        e.setResumo(resumo);
    }

    /**
     * Metodo que edita o abstract do minicurso
     *
     * @param titulo String do titulo do minicurso
     * @param abstac String do abstract
     */
    public void editarAbstract(String titulo, String abstac) {
        Minicurso e = (Minicurso) listaMinicursos.consultarTitulo(titulo);
        e.setAbstrac(abstac);
    }

    /**
     * Metodo que edita os recursos do minicurso
     *
     * @param titulo String do titulo do minicurso
     * @param recursos String dos recursos
     */
    public void editarRecursos(String titulo, String recursos) {
        Minicurso e = (Minicurso) listaMinicursos.consultarTitulo(titulo);
        e.setRecursos(recursos);
    }

    /**
     * Metodo que edita a metodologia do minicurso
     *
     * @param titulo String do titulo do minicurso
     * @param metodologia String da metodologia
     */
    public void editarMetodologia(String titulo, String metodologia) {
        Minicurso e = (Minicurso) listaMinicursos.consultarTitulo(titulo);
        e.setMetodologia(metodologia);
    }

    /**
     * Metodo que edita a duracao do minicurso
     *
     * @param titulo String do titulo do minicurso
     * @param duracao int duracao, que deve ser em minutos
     */
    public void editarDuracao(String titulo, int duracao) {
        Minicurso e = (Minicurso) listaMinicursos.consultarTitulo(titulo);
        e.setDuracao(duracao);
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

        autores = listaMinicursos.consultarTitulo(titulo).getAutor();

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
