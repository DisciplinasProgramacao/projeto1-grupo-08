package codigo.src; //corrigido por mim

import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Creating new Storage object
        Storage Storage = new Storage();

        int op;

        do {
            System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            System.out.println("=-=-=-=-=-=MERCEARIA=-=-=-=-=-=");
            System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            System.out.println("Digite uma das opções abaixo: ");
            System.out.println("[1] Comprar produto");
            System.out.println("[2] Vender produto");
            System.out.println("[3] Consultar dados de produtos individuais");
            System.out.println("[4] Consultar dados totais do estoque");
            System.out.println("[5] Calcular balanço da empresa");
            System.out.println("[0] Finalizar programa");
            System.out.print(">> ");
            op = MyIO.readInt();
            switch (op) {

                case 1:

                    String name, description;
                    double cost, price;
                    int quantity, minimumQuantity;

                    System.out.print("Nome: ");
                    name = MyIO.readString();
                    System.out.print("Descrição: ");
                    description = MyIO.readString();
                    System.out.print("Custo: ");
                    cost = MyIO.readDouble();
                    System.out.print("Preço: ");
                    price = MyIO.readDouble();
                    System.out.print("Quantidade: ");
                    quantity = MyIO.readInt();
                    System.out.print("Quantidade mínima: ");
                    minimumQuantity = MyIO.readInt();

                    Product newProduct = new Product(name, description, cost, price, quantity, minimumQuantity);
                    Storage.AddToStorage(newProduct);

                    System.out.println("Produto adicionado ao estoque.");

                    break;
                case 2:
                    int op1;
                    System.out.println("Escolha o produto: ");
                    List<Product> products = Storage.getProducts();
                    for (int i = 0; i < products.size(); i++) {
                        Product product = products.get(i);
                        System.out.println(i + ": " + product.getName());
                        System.out.println("  Descrição: " + product.getDescription());
                        System.out.println("  Preço: " + product.getPrice());
                        System.out.println("  Quantidade em estoque: " + product.getQuantity());
                    }
                    System.out.print(">> ");
                    op1 = MyIO.readInt();
                    Product productToRemove = products.get(op1);
                    Storage.RemoveFromStorage(productToRemove);
                    System.out.println("Produto removido.");

                    break;

                case 3:
                    int op3;
                    System.out.println("Escolha o produto: ");
                    List<Product> products3 = Storage.getProducts();
                    for (int i = 0; i < products3.size(); i++) {
                        System.out.println(i + ": " + products3.get(i).getName());
                    }
                    System.out.print(">> ");
                    op3 = MyIO.readInt();

                    Product productToCheck = products3.get(op3);
                    if (Storage.getProductMinimum(productToCheck)) {
                        System.out.println(
                                "O produto especificado tem a quantidade mínima necessária para funcionamento da mercearia.");
                    } else {
                        System.out.println(
                                "O produto especificado não tem quantidade mínima necessária para funcionamento da mercearia.");
                        System.out.println("Quantidade em estoque: " + productToCheck.getQuantity());
                        System.out.println("Quantidade mínima: " + productToCheck.getMinimumQuantity());
                    }

                    break;
                case 4:
                    System.out.println("ALERTA! Os seguintes produtos possuem quantidade abaixo do mínimo: ");
                    List<Product> productsBelowMinimum = Storage.getAllMinimum();
                    for (Product product : productsBelowMinimum) {
                        System.out.println(product.getName());
                    }
                    System.out.println("Total de " + Storage.getTotalAmountInStorage() + " produtos no estoque.");
                    System.out.printf("Valor total do estoque: R$%.2f\n", Storage.StorageTotalValue());

                    break;

                case 5:
                    System.out.println("Valor do estoque atual: " + Storage.StorageTotalValue());
                    System.out.println("Valor vendido: " + Storage.getValueSold());
                    System.out.println("Valor gasto em compras: " + Storage.getAmountSpent());
                    break;
                case 0:
                    System.out.println("Finalizando programa.");
                    break;
                default:
                    System.out.println("Digite uma opção válida.");
            }
        } while (op != 0);
    }
}