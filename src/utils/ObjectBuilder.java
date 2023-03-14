package utils;

import entity.Account;
import entity.Address;
import entity.Customer;
import entity.Phone;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class ObjectBuilder {
    public static Customer customer() {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Informações pessoais do cliente:");
        System.out.println("\nNome:");
        String name = userInput.nextLine();
        System.out.println("CPF:");
        String documentNumber = userInput.nextLine();
        System.out.println("E-mail:");
        String email = userInput.nextLine();
        Address address = addressBuilder(userInput);
        List<Phone> phones = phoneBuilder(userInput);
        return new Customer(name,documentNumber,email,address, phones);
    }

    private static Address addressBuilder(Scanner userInput) {
        System.out.println("---- Informaçãoes sobre a residência ----");
        System.out.println("Rua:");
        String street = userInput.nextLine();
        System.out.println("Bairro:");
        String neighborhood = userInput.nextLine();
        System.out.println("Cidade:");
        String city = userInput.nextLine();
        System.out.println("Estado:");
        String state = userInput.nextLine();
        System.out.println("País:");
        String country = userInput.nextLine();
        System.out.println("CEP:");
        String cep = userInput.nextLine();
        System.out.println("Number:");
        String number = userInput.nextLine();
        return new Address(street, neighborhood, city, state, country, cep, number);
    }

    private static List<Phone> phoneBuilder(Scanner userInput) {
        List<Phone> phones = new ArrayList<>();
        Integer optionSelected = 2;
        do {
            System.out.println("---- Informação para contato com o cliente ----\nEscolha uma opção: \n1 - Adicionar telefone \n2 - Sair");
            optionSelected = userInput.nextInt();
            switch (optionSelected) {
                case 1:
                    System.out.println("Código do país");
                    String zipCode = userInput.next();
                    System.out.println("DDD:");
                    String ddd = userInput.next();
                    System.out.println("Number:");
                    String number = userInput.next();
                    phones.add(new Phone(zipCode,ddd,number));
                    break;
            }
        }while(optionSelected != 2);
        return phones;
    }

    public static Account account(UUID customerId) {
        return  new Account(customerId);
    }
}
