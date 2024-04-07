package com.tn;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        System.out.println("----- Product Management -----");
        System.out.println("1. Show All Product");
        System.out.println("2. Insert Product");
        System.out.println("3. Update Product");
        System.out.println("4. Delete Product");
        System.out.println("5. Exit");

        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập giá trị n:");
        int n = sc.nextInt();
        ProductFunction productFunction = new ProductFunction();

        if (n == 1){
            productFunction.showData();
        } else if (n == 2){
            sc = new Scanner(System.in);
            System.out.println("Enter Product Name:");
            String productName = sc.nextLine();

            System.out.println("Enter Price:");
            int price = sc.nextInt();

            sc = new Scanner(System.in);
            System.out.println("Enter Description:");
            String description = sc.nextLine();

            productFunction.insert(productName, price, description);

        } else if (n == 3){
            productFunction.showData();

            System.out.println("Enter ID:");
            int id = sc.nextInt();

            sc = new Scanner(System.in);
            System.out.println("Enter Product Name:");
            String productName = sc.nextLine();

            System.out.println("Enter Price:");
            int price = sc.nextInt();

            sc = new Scanner(System.in);
            System.out.println("Enter Description:");
            String description = sc.nextLine();

            productFunction.update(id, productName, price, description);

        } else if (n == 4){
            productFunction.showData();

            System.out.println("Enter ID:");
            int id = sc.nextInt();

            productFunction.delete(id);

        }
    }

}
