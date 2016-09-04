package Repositorio.trabalho_1.minicurso;

import Repositorio.trabalho_1.Situacao;
import Repositorio.trabalho_1.SubmissaoApresentacao;
import java.util.List;

/**
 * Classe para objetos do tipo Minicurso que contem os atributos e operações do
 * mesmo
 *Situacao.getNome()
 */
public class Minicurso extends SubmissaoApresentacao {

    private String recursos;
    private String metodologia;

    public Minicurso(String titulo, List autores, String resumo, Situacao situacao,
            String abstrac, String metodologia, String recursos, int duracao) {
        super(resumo, abstrac, duracao, titulo, situacao, autores, 3);
        this.recursos = recursos;
        this.metodologia = metodologia;
    }

    /**
     * @return the recursos
     */
    public String getRecursos() {
        return recursos;
    }

    /**
     * @param recursos the recursos to set
     */
    public void setRecursos(String recursos) {
        this.recursos = recursos;
    }

    /**
     * @return the metodologia
     */
    public String getMetodologia() {
        return metodologia;
    }

    /**
     * @param metodologia the metodologia to set
     */
    public void setMetodologia(String metodologia) {
        this.metodologia = metodologia;
    }

    @Override
    public String toString() {
        String string;
            string = (super.toString()
                + "\nRecursos: "+ recursos
                + "\nMetodologia: "+ metodologia);
        return string;
    }
}
