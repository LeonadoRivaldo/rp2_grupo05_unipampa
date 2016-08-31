package Repositorio.trabalho_1.minicurso;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Classe que auxilia na captura de informações inseridas pelo usuário
 *
 * @author Giliardi Schmidt
 */
public class InOut {

    /**
     * Metodo que exibie uma mensagem recebida por parâmetro para o usuario e
     * captura o proximo int que será digitado
     *
     * @param mensagem Recebe a mensagem que será exibida ao usuário
     * @return Retorna o int inserido pelo usuário
     */
    public static int inInt(String mensagem) {
        Scanner input = new Scanner(System.in);
        System.out.println(mensagem);
        int in = input.nextInt();
        input.nextLine();
        return in;
    }

    /**
     * Metodo que exibie uma mensagem recebida por parâmetro para o usuario e
     * captura a proxima String que será digitado
     *
     * @param mensagem Recebe a mensagem que será exibida ao usuário
     * @return Retorna a String inserido pelo usuário
     */
    public static String inString(String mensagem) {
        Scanner input = new Scanner(System.in);
        System.out.println(mensagem);
        String in = input.nextLine();
        return in;
    }

    /**
     * Metodo que exibie uma mensagem recebida por parâmetro para o usuario
     *
     * @param mensagem Recebe a mensagem que será exibida ao usuário
     */
    public static void outL(String mensagem) {
        System.out.println(mensagem);
    }

    /**
     * Metodo que exibie um separador (####) para o usuario
     */
    public static void div() {
        System.out.println("\n###################################################"
                + "#####################################\n");
    }

    /**
     * Metodo que exibibe um ArrayList recebido para o usuario
     *
     * @param arrayList Recebe o ArrayList que será exibido
     */
    public static void outArrayList(ArrayList arrayList) {
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i));
        }
    }
}
