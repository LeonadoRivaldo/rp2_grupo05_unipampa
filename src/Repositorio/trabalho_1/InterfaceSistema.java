/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositorio.trabalho_1;

import java.util.List;
import java.util.Scanner;

/**
 * @author leona_000
 */
public abstract class InterfaceSistema {
    protected Submissao submissao;
    protected static final Scanner entrada = new Scanner(System.in);
    /**
     * Metodo que carega todos os outros metodos da sessao do sistema
     */
    public abstract void principal();
    /**
     * Metodo para o menu
     *
     * @return retonar o inteiro com a opção escolhida
     */
    protected abstract int menu();
    /**
     * metodo vai receber uma submissao e mostrar os atributos enumerando eles
     *
     * @param submissao
     * @return retorna o inteiro com o valor escolhido
     */
    protected abstract int escolherAtributo(Submissao submissao);
    /**
     * Metodo que recebe o objeto que contem a lista de submissoes relacionada
     *
     * @param lista
     * @return
     */
    protected abstract void criarSubmissao();
    /**
     * metodo que deve receber o objeto da lista de submissoes e pedir para o usuario pesquisar
     * a submissao pelo titulo, pedir qual atributo o usuario quer excluir utilizando o 
     * metodo escolherAtributo, com base no atributo pegar o novo valor e atualizar a submissao,
     * e enviar para a lista utilizando a o metodo editar da classe ListaSubmissao, enviando o titulo antigo
     * e o objeto da submissao que deve ser editado.
     * 
     * @param lista que contem as submissoes que vao ser consultadas, com base
     * na classe ListaSubmissao 
     */
    protected abstract void editarSubmissao();
    /**
     * Metodo que recebe a lista de cada uma das submissoes (artigo, monografia,
     * etc), e faz a consulta com base no titulo
     * @param mensagem a ser mostrada para o usuario para diferenciar quem ta
     * chamando EX: "Digite o titulo da monografia que você quer consultar"
     * @param lista que contem as submissoes que vao ser consultadas, com base
     * na classe ListaSubmissao
     * @return retorna uma submissao
     */
    protected Submissao consultarSubmissaoTitulo(String mensagem, ListaSubmissoes lista) {
        System.out.println("====================================================");
        System.out.println(mensagem);
        return lista.consultarTitulo(entrada.nextLine());
    }
    /**
     * Faz consulta utilizando uma string de autor
     * @param mensagem a ser mostrada para o usuario para diferenciar quem ta
     * chamando EX: "Digite o nome do autor que você quer pesquisar"
     * @param lista que contem as submissoes que vao ser consultadas, com base
     * na classe ListaSubmissao
     * @return lista das submissoes relacionadas aquele autor ou null se não
     * houver nenhuma submissao daquele autor
     */
    public List<Submissao> consultarListaSubmissoesAutor(ListaSubmissoes lista){
        System.out.println(entrada.nextLine());
        System.out.println("====================================================");
        System.out.println("Digite o nome do autor que você quer pesquisar: ");
        return lista.consultarAutor(entrada.nextLine());
    }
    /**
     * metodo vai receber uma submissao e exibila utilizando
     * @param submissao objeto de submissao a ser exibido
     */
    protected void exibirSubmissao(Submissao submissao) {
        String  sub = submissao.toString();
        String sss = "";
        String[] submissaoVetor = sub.split("\n");
        for( String s : submissaoVetor ){
            if( s.contains("-") ){
                String[] ss = s.split("-");
                sss += "\n"+ss[1].substring(1);
            }else{
                sss += "\n"+s;
            }
        }
        System.out.print("====================================================");
        System.out.print(sss);
        System.out.println("====================================================");
    }
    /**
     * faz uma lista por autor
     *
     * @param submissoes lista que contem todas as sumissoes relacionadas a ao
     * autor
     * @param lista objeto da classe listaSubmissao
     * @param tipo de sumissao que esta sendo consultada
     *
     * @return retorna o objeto que o usuario escolheu
     */
    protected Submissao listaPorAutor(List<Submissao> submissoes, ListaSubmissoes lista, String tipo) {
        System.out.println("====================================================");
        for (Submissao submissao : submissoes) {
            System.out.println(submissao.getTituloSubmissao());
        }
        System.out.println("----------------------------------------------------");
        System.out.println("Digite o titulo da " + tipo + " a ser exibida: ");
        return lista.consultarTitulo(entrada.nextLine());
    }
    /**
     * função para exibir mensagens no sistema
     * @param mensagem mensagem que vai ser exibida para o usuario
     */
    protected void exibeMensagem(String mensagem) {
        System.out.println("\n===========================================================");
        System.out.println(mensagem.toUpperCase());
        System.out.println("===========================================================\n");
    }
    /**
     * funçao para exlcuir uma submissao usando o titulo como base
     * @param lista objeto da classe listaSubmissao
     * @param frase Ex.: "Qual é o titulo da monografia que você deseja excluir"
     * @return true se exlcuir corretamente, false se não conseguir
     */
    protected boolean excluirSubmissao(ListaSubmissoes lista,String frase) {
        boolean excluida = false;
        do {
            System.out.println("================================================");
            System.out.println(frase);
            excluida = lista.excluir(entrada.nextLine());
            if (excluida) {
                exibeMensagem("Submissao excluida com sucesso");
            } else {
                exibeMensagem("Submissao nao encontrada");
                System.out.print("Pesquisar novamente? sim/nao");
                if (!entrada.nextLine().equalsIgnoreCase("sim")) {
                    excluida = true;
                }
            }
        } while (!excluida);
        return excluida;
    }
}
