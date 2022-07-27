package ciphers;

import java.io.*;

public class RailFence {
    static int l = 0; //stores length of cipher text

    public static void main(String[] args) throws IOException {

        RailFence ob = new RailFence();

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int choice = 0;

        do{

            System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
            System.out.println("                RAIL FENCE");
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
                    System.out.print("\tEnter depth : ");
                    int depth = Integer.parseInt(in.readLine()); //stores key coming from the user
                    String cipherText = ob.encrypt(plainText, depth); // stores cipher text returned from encrypt()
                    String cipherTextString = "";
                    System.out.println("\tPLAIN TEXT  : " + s); // prints plain text

                    System.out.println("\tCIPHER TEXT : " + cipherTextString); // prints cipher text
                }
                case 2 -> {
                    System.out.print("\tEnter your string : ");
                    String s = in.readLine();
                    l = s.length();
                    String[] cipherText = s.split(""); //splits and stores plain text coming from the user
                    System.out.print("\tEnter depth : ");
                    int depth = Integer.parseInt(in.readLine()); //stores key coming from the user
                    System.out.println("\tCIPHER TEXT : " + s); // prints cipher text
                    String plainText = ob.decrypt(cipherText, depth);
                    System.out.println("\tPLAIN TEXT  :  " + plainText.replace("#","")); // prints plain text
                }
                case 3 -> {
                    System.out.println("\tTERMINATING");
                }
            }

        }while(choice!=3);
    }

//    public String[][] encrypt(String []s, int d){
//
//        String[][] cp = new String[d][(l/d)+1]; //stores cipher text
//        int k = 0; // iteration variable
//
//        for(int i=0; i<d+1; i++){
//           for(int j=0; j<(l/d); j++){
//               if(k>=l)
//                   cp[j][i] = "#";
//               else {
//                   cp[j][i] = s[k];
//                   k++;
//               }
//           }
//        }
//        return cp;
//    }


    public String encrypt(String []s, int d){

        String cp = "";
        int z = 0; // for iteration purposes
        for(int i=z; ; i=i+(d+1)){
            if(i>=s.length){
                z++;
                i=z;
            }

            cp = cp.concat(s[i]);
            if(cp.length() == l)
                break;
        }

        System.out.println(cp);
        return cp;
    }
    public String decrypt(String[] s, int d){

        String cp = "";
        int z = 0; // for iteration purposes
        for(int i=z; ; i=i+((l/d))){
            if(i>=s.length){
                z++;
                i=z;
            }

            cp = cp.concat(s[i]);
            if(cp.length() == l)
                break;
        }

        System.out.println(cp);
        return cp;
    }

}
