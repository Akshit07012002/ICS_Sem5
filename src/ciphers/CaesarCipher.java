package ciphers;

import java.io.*;

public class CaesarCipher {
    static int l = 0; //stores length of cipher text

    public static void main(String[] args) throws IOException {

        CaesarCipher ob = new CaesarCipher();

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("\tEnter your string : ");
        String s = in.readLine();
        l = s.length();
        String[] plainText = s.split(""); //stores plain text coming from the user

        System.out.print("\tEnter key : ");
        int key = Integer.parseInt(in.readLine()); //stores key coming from the user

        String[] cipherText = ob.encrypt(plainText, key); // stores cipher text returned from encrypt()

        System.out.println("\tPLAIN TEXT  : " + s); // prints plain text
        System.out.print("\tCIPHER TEXT : "); // prints cipher text
        for (int i=0; i<l; i++) {
            System.out.print(cipherText[i]);
        }

    }

    public String[] encrypt(String []s, int k){

        String[] cp = new String[l]; //stores cipher text
        int t = 0; //temporary storage

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

}
