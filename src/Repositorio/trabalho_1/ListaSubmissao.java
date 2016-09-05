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

    /**
     * mêtodo que vai receber uma submissão e adciona-la na lista de submissões
     *
     * @param submissao um objeto submissao de qualquer tipo para ser adicionado na lista
     * @return
     */
    @Override
    public boolean incluir(Submissao submissao) {
        return submissoes.add(submissao);
    }
    
    @Override
    public Submissao consultarTitulo(String titulo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Submissao> consultarAutor(String autor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean editar(String titulo, Submissao submissao) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean excluir(String titulo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
