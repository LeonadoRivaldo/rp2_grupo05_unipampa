/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositorio.trabalho_1;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author leona_000
 */
public class ListaSubmissao implements ListaSubmissoes {

    private List<Submissao> submissoes;

    /**
     * contrutor
     */
    public ListaSubmissao() {
        submissoes = new ArrayList();
    }

    public List<Submissao> getSubmissoes() {
        return submissoes;
    }

    /**
     * mêtodo que vai receber uma submissão e adciona-la na lista de submissões
     *
     * @param submissao um objeto submissao de qualquer tipo para ser adicionado
     * na lista
     * @return true se objeto foi incluido false para não
     */
    @Override
    public boolean incluir(Submissao submissao) {
        return submissoes.add(submissao);
    }

    /**
     * Envie um titulo para a consulta da submissao
     *
     * @param titulo da submissao a ser consultada
     * @return objeto sumissao se encontar e null se não encontrar ou existir
     * mais de uma submissao com o mesmo titulo
     */
    @Override
    public Submissao consultarTitulo(String titulo) {
        int nSubmissoesEncontradas = 0;
        int submissaoIndex = 0;
        for (Submissao submisao : submissoes) {
            if (submisao.getTituloSubmissao().equalsIgnoreCase(titulo)) {
                submissaoIndex = submissoes.indexOf(submisao);
                nSubmissoesEncontradas++;
            }
        }
        if (nSubmissoesEncontradas == 1) {
            return submissoes.get(submissaoIndex);
        }
        return null;
    }

    /**
     * Envie um autor para a consulta das submissões
     *
     * @param autor da pesquisa para encontar as submissoes relacionadas
     * @return lista de submissoes que tem relação com autor e null se não
     * encontrar
     */
    @Override
    public List<Submissao> consultarAutor(String autor) {
        List<Submissao> sub = new ArrayList<>();
        for (Submissao submisao : submissoes) {
            List<String> autores = submisao.getAutor();
            for (String autor1 : autores) {
                if (autor1.equalsIgnoreCase(autor)) {
                    sub.add(submisao);
                    break;
                }
            }
        }
        if (sub.size() > 0) {
            return sub;
        }
        return null;
    }

    /**
     * Enviar o titulo antigo, se o mesmo for alterado, e o objeto inteiro
     * modificado.
     *
     * @param titulo titulo da submissao, antigo(se for alterado), para
     * substitituir o elemento.
     * @param submissao um objeto que vai substituir o objeto antigo
     * @return true se encontrar o objeto e fizer a alteração, false caso haja
     * mais de um objeto com o mesmo titulo ou se a achão falhar
     */
    @Override
    public boolean editar(String titulo, Submissao submissao) {
        int nSubmissoesEncontradas = 0;
        int submissaoIndex = 0;
        for (Submissao submisao : submissoes) {
            if (submisao.getTituloSubmissao().equalsIgnoreCase(titulo)) {
                submissaoIndex = submissoes.indexOf(submisao);
                nSubmissoesEncontradas++;
            }
        }
        if (nSubmissoesEncontradas == 1) {
            submissoes.set(submissaoIndex, submissao);
            return true;
        }
        return false;
    }

    /**
     * Enviar o titulo da submissao que vai ser excluida
     *
     * @param titulo titulo da submissao
     * @return true se encontrar o objeto e excluir false caso haja mais 
     * de um objeto com o mesmo titulo ou se ação falhar
     */
    @Override
    public boolean excluir(String titulo) {
        int nSubmissoesEncontradas = 0;
        int submissaoIndex = 0;
        for (Submissao submisao : submissoes) {
            if (submisao.getTituloSubmissao().equalsIgnoreCase(titulo)) {
                submissaoIndex = submissoes.indexOf(submisao);
                nSubmissoesEncontradas++;
            }
        }

        if (nSubmissoesEncontradas == 1) {
            submissoes.remove(submissaoIndex);
            return true;
        }
        return false;
    }

}
