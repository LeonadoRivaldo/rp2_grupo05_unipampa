/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositorio.trabalho_1.artigos;

import Repositorio.trabalho_1.ListaSubmissao;
import Repositorio.trabalho_1.Situacao;
import Repositorio.trabalho_1.Submissao;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Amanda Gobus
 */
public class ControleDeArtigos {

    // ArrayList<Artigo> artigos = new ArrayList<Artigo>();
    private ListaSubmissao listaControle;

    public ControleDeArtigos() {
        this.listaControle = new ListaSubmissao();
    }

    /**
     * Método para incluir um objeto artigo dentro da lista
     */
    public void incluir(Artigo artigo) {
        listaControle.incluir(artigo);
    }

    /**
     * Método para consultar um artigo passando por parâmetro uma String titulo
     * Consulta por titulo
     */
    public Artigo consultar(String titulo) {
        return (Artigo) listaControle.consultarTitulo(titulo);

    }

    /**
     * Método para consultar um artigo por autor passando por parâmetro uma
     * String Consulta por autor
     */
    public List<Submissao> consultarAutor(String autor) {
        return listaControle.consultarAutor(autor);
    }

    /**
     * Método para editar uma artigo 1 - String titulo, 2 - String[] autor, 3 -
     * String[] instituicao, 4 - String[] palavrachave, 5 - String resumo, 6 -
     * String Abstract
     *
     * @param atributo
     * @param valor
     * @param artigo
     */
    public boolean editar(int atributo, String valor, Artigo artigo) {
        String oldTitulo = artigo.getTituloSubmissao();
        switch (atributo) {
            case 1:
                artigo.setTituloSubmissao(valor);
                break;
            case 2:
                String[] autor = valor.split("-");
                List<String> autores = new ArrayList();
                for (String a : autor) {
                    autores.add(a);
                }
                artigo.setAutor(autores);
                break;
            case 3:
                String[] instituicao = valor.split("-");
                List<String> instituicoes = new ArrayList();
                for (String inst : instituicao) {
                    instituicoes.add(inst);
                }
                artigo.setInstituicao(instituicoes);
                break;
            case 4:
                String[] palavrachave = valor.split("-");
                List<String> palavras = new ArrayList();
                for (String p : palavrachave) {
                    palavras.add(p);
                }
                artigo.setPalavrasChave(palavras);
                break;
            case 5:
                artigo.setResumo(valor);
                break;
            case 6:
                artigo.setAbstract(valor);
                break;
            case 7:
                Situacao situacao = null;
                situacao = Submissao.verificaSituacao(valor);
                while (situacao == null) {
                    situacao = Submissao.verificaSituacao(PreencheArtigo.preencheSituacao());
                }
                artigo.setSituacaoSubmissao(situacao);
                break;
        }
       return listaControle.editar(oldTitulo, artigo);
    }

    /**
     * @param titulo Método para excluir uma artigo passando por parâmentro uma
     * String e removendo da lista
     */
    public boolean excluir(String titulo) {
        return listaControle.excluir(titulo);

    }

}
