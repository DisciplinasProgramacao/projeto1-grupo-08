package org.example;

import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) {

        //Creating new Storage object
        Storage newStorage = new Storage();

        int op;

        do {
            System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            System.out.println("=-=-=-=-=-=MERCEARIA=-=-=-=-=-=");
            System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            System.out.println("Digite uma das opções abaixo: ");
            System.out.println("[1] Vender produto");
            System.out.println("[2] Fazer pedido");
            System.out.println("[3] Consultar dados de produtos individuais");
            System.out.println("[4] Consultar dados totais do estoque");
            System.out.println("[5] Calcular balanço da empresa");
            System.out.println("[0] Finalizar programa");
            System.out.print(">> ");
            op = MyIO.readInt();
            switch (op){
                case 1:
                    int op1;
                    System.out.println("Escolha o produto: ");
                    newStorage.getProducts();
                    System.out.print(">> ");
                    op1 = MyIO.readInt();
                    newStorage.RemoveFromStorage(op1);
                    System.out.println("Produto removido.");

                    break;
                case 2:
                    String name, description;
                    double cost, price;
                    int quantity, minimumQuantity;

                    System.out.print("Nome>> ");
                    name = MyIO.readString();
                    System.out.print("Descrição>> ");
                    description = MyIO.readString();
                    System.out.print("Custo>> ");
                    cost = MyIO.readDouble();
                    System.out.print("Preço>> ");
                    price = MyIO.readDouble();
                    System.out.print("Quantidade>> ");
                    quantity = MyIO.readInt();
                    System.out.print("Quantidade mínima>> ");
                    minimumQuantity = MyIO.readInt();

                    Product newProduct = new Product(name, description, cost, price, quantity, minimumQuantity);
                    newStorage.AddToStorage(newProduct);

                    System.out.println("Produto adicionado ao estoque.");

                    break;
                case 3:
                    int op3;

                    System.out.println("Escolha o produto: ");
                    newStorage.getProducts();
                    System.out.print(">> ");

                    op3 = MyIO.readInt();

                    newStorage.getProductInfo(op3);

                    if(newStorage.getProductMinimum(op3) == true){
                        System.out.println("O produto especificado tem quantidade o mínimo necessário para funcionamento da mercearia.");
                    }else{
                        System.out.println("O produto especificado não tem quantidade o mínimo necessário para funcionamento da mercearia.");
                    }

                    break;
                case 4:

                    System.out.println("Produtos em quantidade abaixo do mínimo: " + newStorage.getAllMinimum());
                    System.out.println("Total de " + newStorage.getTotalAmountInStorage() + " produtos no estoque.");
                    System.out.printf("Valor total do estoque: R$%.2f\n",newStorage.StorageTotalValue());

                    break;
                case 5:
                    System.out.println("Valor do estoque atual: " + newStorage.StorageTotalValue());
                    System.out.println("Valor vendido: " + newStorage.getValueSold());
                    System.out.println("Valor gasto em reposição: " + newStorage.getAmountSpent());
                    break;
                case 0:
                    System.out.println("Finalizando programa.");
                    break;
                default:
                    System.out.println("Digite uma opção válida.");
            }

        }while (op!=0);

        /*//Creating new Storage object
        Storage newStorage = new Storage();

        //Creating product n1
        Product detergent = new Product("detergent","cleaning product", 2, 5, 50,10);

        //Stocking product n1 in the Storage
        newStorage.AddToStorage(detergent);

        //Checking the total amount of products in Storage
        System.out.println("Total de " + newStorage.getTotalAmountInStorage() + " produtos no estoque.");

        //Getting the total value of products in the Storage
        System.out.printf("Valor total do estoque: R$%.2f\n",newStorage.StorageTotalValue());

        //Creating product n2
        Product juice = new Product("juice","fruit drink",1, 5, 30,15);

        //Stocking product n2 in the Storage
        newStorage.AddToStorage(juice);

        //Checking if the quantity of the specific product is the minimum necessary
        if(newStorage.getProductMinimum(juice) == true){
            System.out.println("O produto especificado tem quantidade o mínimo necessário para funcionamento da mercearia.");
        }else{
            System.out.println("O produto especificado não tem quantidade o mínimo necessário para funcionamento da mercearia.");
        }

        //Checking if the quantity of each product is the minimum necessary
        System.out.println("Produtos em quantidade abaixo do mínimo: " + newStorage.getAllMinimum());

        //Removing product n1 from Storage
        newStorage.RemoveFromStorage(detergent);


        //Checking the total amount of products in Storage
        System.out.println("Total de " + newStorage.getTotalAmountInStorage() + " produtos no estoque.");*/

    }
}