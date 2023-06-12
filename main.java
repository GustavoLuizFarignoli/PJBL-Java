import java.util.Scanner;
import static Automoveis.Caminhao.menuCaminhao;
import static Automoveis.Carro.menuCarro;
import static Automoveis.Moto.menuMoto;
import static Pessoas.Cliente.menuCliente;
import static Pessoas.Vendedor.menuVendedor;
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
        int op = 0;
        while (op != 7) {
            System.out.println("******MENU******\n" +
                    "1. Menu Carro \n" +
                    "2. Menu Moto\n" +
                    "3. Menu Caminhão\n" +
                    "4. Menu Cliente\n" +
                    "5. Menu Vendedor\n" +
                    "6. Menu Estoque\n" +
                    "7. Finalizar\n");
            boolean valido = false;
            while (!valido) {
                try {
                    System.out.print("Digite o comando desejado: ");
                    op = Integer.parseInt(teclado.nextLine());
                    valido = true;
                } catch (NumberFormatException e) {
                    System.out.println("Por favor responda apenas o número da opção desejada");
                }
            }


                switch (op) {
                case 1:
                    menuCarro(op);
                    break;
                case 2:
                    menuMoto(op);
                    break;
                case 3:
                    menuCaminhao(op);
                    break;
                case 4:
                    menuCliente(op);
                    break;
                case 5:
                    menuVendedor(op);
                    break;
                case 6:
                    // opções estoque
                    break;
                case 7:
                    System.out.println("Finalizando aplicação...");
                    break;
            }
        }
    }
}
