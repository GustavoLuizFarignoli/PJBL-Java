import java.util.Scanner;
import static Automoveis.Caminhao.menuCaminhao;
import static Automoveis.Carro.menuCarro;
import static Automoveis.Moto.menuMoto;
import static Estoque.Estoque.menuEstoque;
import static Pessoas.Cliente.menuCliente;
import static Pessoas.Vendedor.menuVendedor;
public class main {
    public static void main(String[] args) {
        System.out.println("""
                ******PJBL-POO******
                Concessionária de Automóveis
                Feito por: Gabriel Molec
                           Gabriel Vink
                           Gustavo Luiz
                           João Trigo
                           Vittorio Caprioli
                           """);

        Scanner teclado = new Scanner(System.in);
        int op = 0;
        while (op != 7) {
            System.out.println("""
                    ******MENU******
                    1. Menu Carro
                    2. Menu Moto
                    3. Menu Caminhão
                    4. Menu Cliente
                    5. Menu Vendedor
                    6. Menu Estoque
                    7. Finalizar
                    """);
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
                    menuEstoque(op);
                    break;
                case 7:
                    System.out.println("Finalizando aplicação...");
                    break;
            }
        }
    }
}
