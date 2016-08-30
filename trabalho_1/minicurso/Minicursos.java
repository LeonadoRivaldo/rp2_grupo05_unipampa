package trabalho_1.minicurso;

import java.util.ArrayList;

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
     * @param situação Situação do minicurso
     * @param abstrac Abstract do minicurso
     * @param metodologia Metodologia do minicurso
     * @param recursos Recursos do minicurso
     * @param duracao Duração do minicurso
     */
    public void setMinicurso(String titulo, String autores, String resumo, String situação,
            String abstrac, String metodologia, String recursos, String duracao) {

        minicurso = new Minicurso();

        minicurso.setTitulo(titulo);
        minicurso.setAutor(autores);
        minicurso.setResumo(resumo);
        minicurso.setSituacao(situação);
        minicurso.setAbstrac(abstrac);
        minicurso.setMetodologia(metodologia);
        minicurso.setRecursos(recursos);
        minicurso.setDuracao(duracao);

        lista.add(minicurso);
    }

    /**
     * Metodo responsavel por buscar e exibir informações sobre um minicurso
     *
     * @param index Recebido para saber a posição do minicurso a ser buscado
     * @param minicursoSelecionado Recebido para preencher com os dados do
     * minicurso selecionado
     * @return Retorna um Arraylist pronto para ser exibido contendo todas as
     * informações do minicurso selecionado
     */
    public ArrayList getMinicurso(int index, ArrayList minicursoSelecionado) {
        minicursoSelecionado.add("Titulo: " + lista.get(index).getTitulo());
        minicursoSelecionado.add("Autor: " + lista.get(index).getAutor());
        minicursoSelecionado.add("Situação: " + lista.get(index).getSituacao());
        minicursoSelecionado.add("Resumo: " + lista.get(index).getResumo());
        minicursoSelecionado.add("Abstract: " + lista.get(index).getAbstrac());
        minicursoSelecionado.add("Metodologia: " + lista.get(index).getMetodologia());
        minicursoSelecionado.add("Recursos: " + lista.get(index).getRecursos());
        minicursoSelecionado.add("Duração: " + lista.get(index).getDuracao());

        return minicursoSelecionado;
    }

    /**
     * Metodo para deletar um minicurso informado
     *
     * @param index Index do minicurso que será deletado
     */
    public void deleteMinicurso(int index) {
        lista.remove(index);
    }

    /**
     * Metodo responsavel por busca e exibir a lista de minicursos
     *
     * @param minicursosCadastrados Recebido para preencher com a lista dos
     * minicursos cadastrados
     * @return Retorna um ArrayList pronto para ser exibido contendo o autor e
     * titulo de todos os minicursos
     */
    public ArrayList getMinicursos(ArrayList minicursosCadastrados) {
        for (int i = 0; i < lista.size(); i++) {
            minicursosCadastrados.add(i + " - " + lista.get(i).getTitulo()
                    + "    \t Autor(es): "
                    + lista.get(i).getAutor());
        }
        return minicursosCadastrados;
    }

    /**
     * Metodo responsavel por buscar e exibir minicursos que correspondam com os
     * dados desejados
     *
     * @param desejado Recebe o dado que deseja buscar, autor ou titulo
     * @param tipo Recebe o tipo da busca: por autor(1) ou por titulo(2)
     * @param resultadoBusca Recebe o ArrayList para preencher
     * @return Retorna um ArrayList pronto para exibir contrendo a lista de
     * minicursos encontrados na busca, contendo titulo e autor
     */
    public ArrayList search(String desejado, int tipo, ArrayList resultadoBusca) {
        if (tipo == 1) {
            for (int i = 0; i < lista.size(); i++) {
                if (lista.get(i).getAutor().toUpperCase().contains(desejado.toUpperCase())) {
                    resultadoBusca.add(i + " - " + lista.get(i).getAutor() + "    \tAutor(es): "
                            + lista.get(i).getAutor());
                }
            }
        } else {
            for (int i = 0; i < lista.size(); i++) {
                if (lista.get(i).getTitulo().toUpperCase().contains(desejado.toUpperCase())) {
                    InOut.outL(i + " - " + lista.get(i).getTitulo() + "    \tAutor(es): "
                            + lista.get(i).getTitulo());
                }
            }
        }
        return resultadoBusca;
    }

    /**
     * Metodo responsavel por editar um minicurso selecionado
     *
     * @param opcao Recebe qual dado deseja editar (opção): 1 - titulo, 2 -
     * autor, 3 - situação, 4 - resumo, 5 - abstract, 6 - recursos, 7 -
     * metodologia, 8 - duração
     *
     * O numero máximo de autores é 3
     *
     * A situação deve ser: Sob avaliação, Aprovado ou Não aprovado
     *
     * @param index Recebe o index do minicurso que será alterado
     * @param novoDado Recebe o novo valor do atributo que será alterado
     */
    public void edit(int opcao, int index, String novoDado) {
        switch (opcao) {
            case 1:
                lista.get(index).setTitulo(novoDado);
                break;
            case 2:
                lista.get(index).setAutor(novoDado);
                break;
            case 3:
                lista.get(index).setSituacao(novoDado);
                break;
            case 4:
                lista.get(index).setResumo(novoDado);
                break;
            case 5:
                lista.get(index).setAbstrac(novoDado);
                break;
            case 6:
                lista.get(index).setRecursos(novoDado);
                break;
            case 7:
                lista.get(index).setMetodologia(novoDado);
                break;
            case 8:
                lista.get(index).setDuracao(novoDado);
                break;
            default:
                break;
        }
    }
}
