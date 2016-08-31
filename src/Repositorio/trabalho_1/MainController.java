package Repositorio.trabalho_1;

import java.util.Scanner;
import Repositorio.trabalho_1.minicurso.*;
import Repositorio.trabalho_1.artigos.*;
import Repositorio.trabalho_1.monografias.*;
import Repositorio.trabalho_1.palestra.*;
import Repositorio.trabalho_1.resumo.*;

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

    public static int menu() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("##############################################");
        System.out.println("Bem vindo ao sistema de envio de publicações!");
        System.out.println("-------------------");
        System.out.println("0 - sair");
        System.out.println("1 - Monografia");
        System.out.println("2 - Resumo");
        System.out.println("3 - Palestra");
        System.out.println("4 - minucurso");
        System.out.println("5 - Artigo");
        System.out.println("------------------");
        System.out.print("Opção: ");
        return entrada.nextInt();
    }
    
    
    
    /**
     * main
     * @param args 
     */
    public static void main(String[] args) {
        ExecutorDeMonografias exeMonografias = new ExecutorDeMonografias();
       
        Executor palestra = new Executor();
        PMinicurso minicurso = new PMinicurso();
        ExecutarArtigos artigos = new ExecutarArtigos();
        Scanner entrada = new Scanner(System.in);
        ControladorResumo resumo = new ControladorResumo();
        int opcao = -1;

        do {
            opcao = menu();
            switch (opcao) {
                case 0:
                    break;
                case 1:
                    exeMonografias.menu();
                    break;
                case 2:
                    ClassePrincipalResumo.principal();
                    break;
                case 3:
                    palestra.menu();
                    break;
                case 4:
                    minicurso.principal();
                    break;
                case 5:
                    artigos.menu();
                    break;
                default:
                    msg("OPÇÃO INVALIDA!!");
            }
        } while (opcao != 0);

    }

}
