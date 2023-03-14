import dao.MokedDataBase;
import entity.Account;
import entity.Customer;
import service.AccountServiceImpl;
import service.CustomerServiceImpl;
import service.interfaces.AccountService;
import service.interfaces.CustomerService;
import utils.ObjectBuilder;

import java.util.Scanner;

public class LagoinhaBankMain {
    public static void main(String[] args) {
        MokedDataBase dataBase = new MokedDataBase();
        AccountService accountService = new AccountServiceImpl();
        CustomerService customerService = new CustomerServiceImpl();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println(
                    "---- Bem Vindo(a) ao Lagoinha Bank ---- \nDigite: \n1 - Abrir conta \n2 - Depósito \n3 - Saque \n4 - Consultar saldo\n5 - Transferência \n6 - PIX\n7 - Cancelar conta \n0 - Encerrar");
            int opcaoSelecionada = scanner.nextInt();

            switch (opcaoSelecionada) {
                case 1:
                    Customer customer = ObjectBuilder.customer();
                    Customer customerId = customerService.save(dataBase.getCustomerTable(),customer);
                    Account account = ObjectBuilder.account();
                    break;
                case 2:
                    System.out.println("Depósito selecionado");
                    break;
                case 3:
                    System.out.println("Saque selecionado");
                    break;
                case 4:
                    System.out.println("Transferência selecionada");
                    break;
                case 5:
                    System.out.println("Consultar saldo selecionado.");
                    break;
                case 6:
                    System.out.println("Obrigado pela preferência!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        }
    }
}
