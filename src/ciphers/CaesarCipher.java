package ciphers;

import java.io.*;

public class CaesarCipher {
    static int l = 0; //stores length of cipher text

    public static void main(String[] args) throws IOException {

        CaesarCipher ob = new CaesarCipher();

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int choice = 0;

        do{

            System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
            System.out.println("                CAESAR CIPHER");
            System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
            System.out.println("                1) Encrypt");
            System.out.println("                2) Decrypt");
            System.out.println("                3) End");
            System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");

            System.out.print("\tEnter your choice : ");
            choice = Integer.parseInt(in.readLine());


            switch (choice) {
                case 1 -> {
                    System.out.print("\tEnter your string : ");
                    String s = in.readLine();
                    l = s.length();
                    String[] plainText = s.split(""); //splits and stores plain text coming from the user
                    System.out.print("\tEnter key : ");
                    int key = Integer.parseInt(in.readLine()); //stores key coming from the user
                    String[] cipherText = ob.encrypt(plainText, key); // stores cipher text returned from encrypt()
                    System.out.println("\tPLAIN TEXT  : " + s); // prints plain text
                    System.out.print("\tCIPHER TEXT : "); // prints cipher text
                    for (int i = 0; i < l; i++) {
                        System.out.print(cipherText[i]);
                    }
                    System.out.println();
                }
                case 2 -> {
                    System.out.print("\tEnter your string : ");
                    String s = in.readLine();
                    l = s.length();
                    String[] cipherText = s.split(""); //splits and stores plain text coming from the user
                    System.out.print("\tEnter key : ");
                    int key = Integer.parseInt(in.readLine()); //stores key coming from the user
                    String[] plainText = ob.decrypt(cipherText, key); // stores cipher text returned from encrypt()
                    System.out.println("\tPLAIN TEXT  : " + s); // prints plain text
                    System.out.print("\tCIPHER TEXT : "); // prints cipher text
                    for (int i = 0; i < l; i++) {
                        System.out.print(plainText[i]);
                    }
                    System.out.println();
                }
                case 3 -> {
                    System.out.println("\tTERMINATING");
                }
            }

        }while(choice!=3);
    }

    public String[] encrypt(String []s, int k){

        String[] cp = new String[l]; //stores cipher text
        int t; //temporary storage

        for(int i=0; i<l; i++){
            if( (s[i].charAt(0)) != ' '){
                t = ((int) s[i].charAt(0) + k);
                cp[i] = Character.toString(t);
            }else {
                cp[i] = " ";
            }
//            System.out.println(t + ", " + cp[i]);
        }
        return cp;
    }

    public String[] decrypt(String []s, int k){

        String[] cp = new String[l]; //stores cipher text
        int t; //temporary storage

        for(int i=0; i<l; i++){
            if( (s[i].charAt(0)) != ' '){
                t = ((int) s[i].charAt(0) - k);
                cp[i] = Character.toString(t);
            }else {
                cp[i] = " ";
            }
//            System.out.println(t + ", " + cp[i]);
        }
        return cp;
    }

}
