import Automoveis.Carro;
import Formulario.FormRefactored;

import javax.swing.*;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        System.out.println("******PJBL-POO******\n" +
                "Concessionária de Automóveis\n" +
                "Feito por: Gabriel Molec\n" +
                "           Gabriel Vink\n" +
                "           Gustavo Luiz\n" +
                "           João Gabriel Trigo\n" +
                "           Vittorio Caprioli");

        Scanner teclado = new Scanner(System.in);
        System.out.println("***MENU***\n" +
                "1. Menu Carro \n" +
                "2. Menu Moto\n" +
                "3. Menu Caminhão\n" +
                "4. Menu Cliente\n" +
                "5. Menu Vendedor\n" +
                "6. Menu Estoque\n" +
                "7. Finalizar");
        int op = teclado.nextInt();
        switch (op){
            case 1:
                // Opções carros
                break;
            case 2:
                // Opções motos
                break;
            case 3:
                // Opções caminhão
                break;
            case 4:
                // opções cliente
                break;
            case 5:
                // opções vendedor
                break;
            case 6:
                // opções estoque
                break;
            case 7:
                break;
            default:
                System.out.println("Opção de menu inválida");
        }
    }
}
