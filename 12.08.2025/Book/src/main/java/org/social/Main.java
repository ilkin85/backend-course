package org.social;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Book[] books = new Book[10];
        int nextId = 1;

        while (true) {
            System.out.println("\nNe etmek isteyirsiniz?");
            System.out.println("1 - Yeni kitab elave et");
            System.out.println("2 - Butun kitablar");
            System.out.println("3 - Kitab sil (id-ye gore)");
            System.out.println("0 - Proqrami bitir");
            System.out.print("Seciminizi edin: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 0) {
                System.out.println("Proqram dayandirildi.");
                break;
            }

            switch (choice) {
                case 1:
                    boolean added = false;
                    for (int i = 0; i < books.length; i++) {
                        if (books[i] == null) {
                            System.out.print("Kitabin adini daxil edin: ");
                            String name = scanner.nextLine();
                            books[i] = new Book(nextId++, name);
                            System.out.println("Kitab elave edildi: ID=" + books[i].getId() + ", Ad=" + books[i].getName());
                            added = true;
                            break;
                        }
                    }
                    if (!added) {
                        System.out.println("Kitablar doludur, daha elave etmek olmaz.");
                    }
                    break;

                case 2:
                    System.out.println("\nKitablar siyahisi:");
                    boolean hasBooks = false;
                    for (Book b : books) {
                        if (b != null) {
                            System.out.println("ID: " + b.getId() + ", Ad: " + b.getName());
                            hasBooks = true;
                        }
                    }
                    if (!hasBooks) {
                        System.out.println("Heç bir kitab yoxdur.");
                    }
                    break;

                case 3:
                    System.out.print("Silmek istediyiniz kitabin ID-sini daxil edin: ");
                    int delId = scanner.nextInt();
                    boolean deleted = false;
                    for (int i = 0; i < books.length; i++) {
                        if (books[i] != null && books[i].getId() == delId) {
                            books[i] = null;
                            System.out.println("Kitab silindi.");
                            deleted = true;
                            break;
                        }
                    }
                    if (!deleted) {
                        System.out.println("Belə ID-li kitab tapilmadi.");
                    }
                    break;

                default:
                    System.out.println("Yanlis secim, tekrar cehd edin.");
                    break;
            }
        }

        scanner.close();

    }
}