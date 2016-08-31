/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositorio.trabalho_1.monografias;
import java.util.ArrayList;
/**
 *
 * @author leona_000
 */
public class ControllerDeMonografias {

    ArrayList<Monografia> monografias = new ArrayList<Monografia>();
    /**
     * inclui uma monografia na biblioteca
     * @param m
     * @return 
     */
    public boolean incluir(Monografia m) {
        monografias.add(m);
        return true;
    }
    /**
     * faz consulta utilizando uma lista enumerada, e seleciona qual item da
     * lista quer mostrar
     * @param indice
     * @return 
     */
    public Monografia consultar(int indice) {
        return monografias.get(indice);
    }
    /**
     * funçao para exlcuir uma monografia
     * @param indice
     * @return 
     */
    public boolean excluir(int indice) {
        monografias.remove(indice);
        return true;
    }
    /**
     * <p>metodo que recebe um inteiro que representa um atributo da classe,
     * o valor para modificar o objeto e o objeto a ser modificado</p>
     * <i>
     * Titulo = 1<br/>
     * tipo = 2<br/>
     * autor = 3<br/>
     * Instituicao = 4 <br/>
     * orientador = 5<br/>
     * curso = 6<br/>
     * ano = 7<br/>
     * numeroDePaginas = 8<br/>
     * palavrasChaves = 9<br/>
     * resumo = 10<br/>
     * Abstract = 11<br/>
     * </i>
     * @param atributo
     * @param valor
     * @param monografia 
     */
    public boolean editar(int atributo, String valor, Monografia monografia) {
        switch (atributo) {
            case 1:
                monografia.setTitulo(valor);
                break;
            case 2:
                monografia.setTipo(valor);
                break;
            case 3:
                monografia.setAutor(valor);
                break;
            case 4:
                monografia.setInstituicao(valor);
                break;
            case 5:
                monografia.setOrientador(valor);
                break;
            case 6:
                monografia.setCurso(valor);
                break;
            case 7:
                monografia.setAno(Integer.parseInt(valor));
                break;
            case  8:
                monografia.setNumeroDePaginas(Integer.parseInt(valor));
                break;
            case  9:
                String[] palavras = valor.split(" ");
                monografia.setPalavrasChaves(palavras);
                break;
            case  10:
                monografia.setResumo(valor);
                break;
            case  11:
                monografia.setAbstract(valor);
                break;
        }
        return true;
    }
    /**
     * Função para criar o objeto monografia
     * @param monografia
     * @return 
     */
    public boolean criar(Monografia monografia) {
        incluir(monografia);
        return true;
    }



}
