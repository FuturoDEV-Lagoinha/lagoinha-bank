import dao.MokedDataBase;
import entity.Account;
import entity.Customer;
import entity.Pix;
import service.AccountServiceImpl;
import service.CustomerServiceImpl;
import service.interfaces.AccountService;
import service.interfaces.CustomerService;
import utils.ObjectBuilder;

import java.math.BigDecimal;
import java.util.Scanner;
import java.util.UUID;

public class LagoinhaBankMain {
    public static void main(String[] args) {
        MokedDataBase dataBase = new MokedDataBase();
        AccountService accountService = new AccountServiceImpl();
        CustomerService customerService = new CustomerServiceImpl();
        Scanner scanner = new Scanner(System.in);
        final double OPERATION_FEE = 3.5;

        while (true) {
            System.out.println(
                    "---- Bem Vindo(a) ao Lagoinha Bank ---- \nDigite: \n1 - Abrir conta \n2 - Depósito \n3 - Saque \n4 - Consultar saldo\n5 - Transferência \n6 - Listar contas\n7 - PIX\n8 - Cancelar Conta \n0 - Encerrar");
            int opcaoSelecionada = scanner.nextInt();

            switch (opcaoSelecionada) {
                case 1:
                    Customer customer = ObjectBuilder.customer();
                    Customer customerSaved = customerService.save(dataBase.getCustomerTable(),customer);
                    Account account = ObjectBuilder.account(UUID.randomUUID());
                    account.setCustomerId(customerSaved.getUuid());
                    accountService.save(dataBase.getAccountTable(), account);
                    break;
                case 2:
                    System.out.println("Depósito selecionado");
                    break;
                case 3:
                    System.out.println("Saque selecionado");
                    System.out.println("Informe o número da conta: ");
                    String conta = scanner.next();

                    for(int contador = 0; contador < dataBase.getAccountTable().size(); contador++ ){
                        if(conta.equals(dataBase.getAccountTable().get(contador).getNumber())){
                            System.out.println("Informe o valor do saque: R$");
                            BigDecimal valorSaque = scanner.nextBigDecimal();

                            if(valorSaque.compareTo(dataBase.getAccountTable().get(contador).getBalance()) == 1 ||
                                    valorSaque.compareTo(dataBase.getAccountTable().get(contador).getBalance()) == 0){
                                dataBase.getAccountTable().get(contador).setBalance(valorSaque);
                                System.out.println("Saque realizado com sucesso! Saldo atual: R$ " + dataBase.getAccountTable().get(contador).getBalance());
                        } else {
                                System.out.println("Saldo insuficiente.");
                            }
                        }
                    }
                        break;
                case 4:
                    System.out.println( "Informe o número da conta para consulta: "  );
                    String contaInformadaConsulta = scanner.next();

                    for(int contador = 0; contador < dataBase.getAccountTable().size(); contador++ ){
                        if(contaInformadaConsulta.equals(dataBase.getAccountTable().get(contador).getNumber())){
                            System.out.println("O saldo da conta é: R$ "+dataBase.getAccountTable().get(contador).getBalance());
                        }else {
                            System.out.println("Conta não encontrada!");
                        }
                    }
                    break;
                case 5:
                    System.out.println("Informe o número da conta de origem: ");
                    String sourceAccount = scanner.next();
                    System.out.println("Informe o número da conta de destino: ");
                    String destinationAccount = scanner.next();
                    System.out.println("Informe o valor da transferência : R$ ");
                    BigDecimal transferValue = scanner.nextBigDecimal();

                    for(int contador = 0; contador < dataBase.getAccountTable().size(); contador++ ){
                        if(sourceAccount.equals(dataBase.getAccountTable().get(contador).getNumber()) &&
                                (dataBase.getAccountTable().get(contador).getBalance().compareTo(transferValue) == 1 ||
                                        dataBase.getAccountTable().get(contador).getBalance().compareTo(transferValue) == 0)){
                            BigDecimal operationTotalValue = BigDecimal.valueOf(transferValue.doubleValue() + OPERATION_FEE);
                            dataBase.getAccountTable().get(contador).getBalance().subtract(operationTotalValue);
                            for(int contador1 = 0; contador1 < dataBase.getAccountTable().size(); contador1++ ){
                                if(destinationAccount.equals(dataBase.getAccountTable().get(contador1).getNumber())){
                                    dataBase.getAccountTable().get(contador1).getBalance().add(transferValue);
                                }
                            }

                            System.out.println("Operação concluída com sucesso.");

                        } else {
                            System.out.println("A Operação não pode ser concluída.");
                        }
                    }
                    break;
                case 6:
                    System.out.println("Lista das contas:");
                    dataBase.getAccountTable().forEach(accountList -> {
                        System.out.println(accountList.toString());
                    });
                    break;
                case 7:
                    System.out.println("Escolha uma Opçao: \n 1 - Cadastrar Chave\n 2 - Editar Chave\n 3 - Exclusao");
                    int opcao = scanner.nextInt();
                    switch (opcao){

                        case 1:
                            System.out.println("Informe a Chave");
                            String chave = scanner.next();
                            System.out.println("Informe Numero Da Conta");
                            String numeroDaConta = scanner.next();

                            for(Account account1: dataBase.getAccountTable()) {

                                if (account1.getNumber().equals(numeroDaConta)){

                                    account1.setPix(new Pix(UUID.randomUUID(),chave));

                                }


                            }


                            break;

                        case 2:

                            System.out.println("Informe a nova Chave");
                            String newChave = scanner.next();
                            System.out.println("Informe Numero Da Conta");
                            numeroDaConta = scanner.next();

                            for(Account account1: dataBase.getAccountTable()) {

                                if (account1.getNumber().equals(numeroDaConta)) {

                                    account1.getPix().setKey(newChave);

                                }

                            }

                            break;

                        case 3:

                            System.out.println("Informe Numero Da Conta");
                            numeroDaConta = scanner.next();

                            for(Account account1: dataBase.getAccountTable()) {

                                if (account1.getNumber().equals(numeroDaConta)) {

                                    account1.setPix(null);

                                }

                            }

                            break;

                        default:
                            System.out.println("Opçao Invalida");



                    }
                    break;
                case 8:
                    System.out.println("Cancelar conta");
                    break;
                case 0:
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
