package Repositorio.trabalho_1;

import Repositorio.trabalho_1.artigos.InterfaceArtigo;
import java.util.Scanner;
import Repositorio.trabalho_1.minicurso.*;
import Repositorio.trabalho_1.monografias.InterfaceMonografia;
import Repositorio.trabalho_1.palestra.InterfacePalestra;
import Repositorio.trabalho_1.resumo.InterfaceResumo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author leona_000
 */
public class MainController {

    public static void msg(String s) {
        System.out.println("\n##############################################\n" + s + "\n##############################################\n");
    }

    /**
     * menu!
     *
     * @return
     */
    public static int menu() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("##############################################");
        System.out.println("Bem vindo ao sistema de envio de publicações!");
        System.out.println("======================");
        System.out.println("||  0 - Sair        ||");
        System.out.println("||  1 - Monografia  ||");
        System.out.println("||  2 - Resumo      ||");
        System.out.println("||  3 - Palestra    ||");
        System.out.println("||  4 - Minucurso   ||");
        System.out.println("||  5 - Artigo      ||");
        System.out.println("======================");
        System.out.print("Opção: ");
        return entrada.nextInt();
    }

    /**
     * main do sistema, aonde as classes são integradas
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        InterfaceResumo iResumo = new InterfaceResumo();
        InterfaceMonografia iMonografia = new InterfaceMonografia();
        InterfacePalestra iPalestra = new InterfacePalestra();
        InterfaceMinicurso iMinicurso = new InterfaceMinicurso();
        InterfaceArtigo iArtigo = new InterfaceArtigo();

        int opcao = -1;

        do {
            opcao = menu();
            switch (opcao) {
                case 0:
                    break;
                case 1:
                    iMonografia.principal();
                    break;
                case 2:
                    iResumo.principal();
                    break;
                case 3:
                    iPalestra.principal();
                    break;
                case 4:
                    iMinicurso.principal();
                    break;
                case 5:
                    iArtigo.principal();
                    break;
                default:
                    msg("OPÇÃO INVALIDA!!");
            }
        } while (opcao != 0);

    }

}
