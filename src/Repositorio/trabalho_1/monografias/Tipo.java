
package Repositorio.trabalho_1.monografias;


public enum Tipo {

    graduacao("Graduacao"), especializacao("Especializacao"), mestrado("Mestrado"), doutorado("Doutorado");
    private String nome;

    Tipo(String nome) {
        this.nome = nome;

    }

    public String getNome() {
        return this.nome;
    }
    
    /**
     * Verifica o tipo com base numa string digitada pelo usuario
     * @param tipo
     * @return 
     */
    public static Tipo verifica(String tipo) {
        if (tipo.equalsIgnoreCase(graduacao.getNome())) {
            return graduacao;
        } else if (tipo.equalsIgnoreCase(especializacao.getNome())) {
            return especializacao;
        } else if (tipo.equalsIgnoreCase(doutorado.getNome())) {
            return doutorado;
        } else if (tipo.equalsIgnoreCase(mestrado.getNome())) {
            return mestrado;
        }
        return null;
    }

}
