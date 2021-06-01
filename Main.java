package search;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Main {
    static Scanner scanner = new Scanner(System.in);
    static Scanner scannerString = new Scanner(System.in);

    public static void main(String[] args) {
        String[] allpeoplecopy = new String[9999];
        int count = 0;
        if (args[0].equals("--data")) {
            File file = new File(args[1]);
            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNext()) {
                    allpeoplecopy[count] = scanner.nextLine();
                    count++;
                }
            } catch (FileNotFoundException e) {
                System.out.println("File not found");
            }

        }
        String[] allpeople = new String[count];
        System.arraycopy(allpeoplecopy, 0, allpeople, 0, allpeople.length);
        Menu(allpeople);
    }


    public static void Menu(String[] allpeople) {
        while (true) {
            System.out.println("=== Menu ===\n" +
                    "1. Find a person\n" +
                    "2. Print all people\n" +
                    "0. Exit");
            int menu = scanner.nextInt();
            switch (menu) {
                case 1:
                    System.out.println("Select a matching strategy: ALL, ANY, NONE");
                    String strategy = scannerString.nextLine();
                    System.out.println("Enter a name or email to search all suitable people.");
                    String search = scannerString.nextLine();
                    String a = "";
                    String b = "";
                    String c = "";
                    String[] subStr1;
                    switch (strategy) {
                        case "ANY":
                            subStr1 = search.split(" ");
                            for (String allperson : allpeople) {
                                String[] subStr;
                                subStr = allperson.split(" ");
                                for (String text : subStr) {
                                    if (text.equalsIgnoreCase(subStr1[0]) || text.equalsIgnoreCase(subStr1[1])) {
                                        a = allperson;
                                        System.out.println(a);
                                        if (a.equals("")) {
                                            System.out.println("No matching people found.");
                                        }
                                    }
                                }
                            }
                            break;
                        case "ALL":
                            for (String allperson : allpeople) {
                                String[] subStr;
                                subStr = allperson.split(" ");
                                for (String text : subStr) {
                                    if (text.equalsIgnoreCase(search)) {
                                        b = allperson;
                                        System.out.println(b);
                                        if (b.equals("")) {
                                            System.out.println("No matching people found.");
                                        }
                                    }
                                }
                            }
                            break;
                        case "NONE":
                            subStr1 = search.split(" ");
                            for (String allperson : allpeople) {
                                    if (allperson.toLowerCase().contains(subStr1[0].toLowerCase()) || allperson.toLowerCase().contains(subStr1[1].toLowerCase())) {
                                        continue;
                                    }
                                    c = allperson;
                                    System.out.println(c);
                                    if (c.equals("")) {
                                        System.out.println("No matching people found.");
                                    }
                                }
                    }
                    break;
                        case 2:
                            for (String s : allpeople) {
                                System.out.println(s);
                            }
                            break;
                        case 0:
                            exitAccount();
                            break;
                        default:
                            System.out.println("Incorrect option! Try again.");
                            break;

                    }
            }
        }


        public static void exitAccount() {
            System.out.println("Bye!");
            System.exit(0);
        }
    }







