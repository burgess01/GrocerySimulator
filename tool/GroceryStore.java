// This is a Java program which inputs a file and outputs

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Random;

public class GroceryStore{
    public static void suggestions(){
    // create function for generating suggestions, choose 2-4 suggestions?
    // top 3 most bought items, inputs purchasehistory.txt
    // read in file
    BufferedReader br = new BufferedReader(new FileReader("purchasehistory.txt"));
    // grab ONLY second column and add to an array
    String line = br.readLine();
    String splitBy = ",";
    String[] boughtItems;
    int count = 0;
    while((line = br.readLine()) !=null){
        // for amount of rows second val in grab
        String[] b = line.split(splitBy);
        boughtItems.append(b[1]);
        count++;
    }
    // randomly select two suggestions
    Random r = new Random();
    String item1;
    String item2;

    item1 = boughtItems[r.nextInt(count)];
    item2 = boughtItems[r.nextInt(count)];

    System.out.println("We recommend that you buy more" + item1 + "based on your purchase history.");
    System.out.println("We also recommend that you buy more" + item2 + "based on your purchase history.");
    
    }
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        // input input file
        BufferedReader br = new BufferedReader(new FileReader("itemlist.txt"));
        // put itemlist.txt contents into an array of objects
        String line;
        String splitBy = ",";
        String[] boughtItems;
        int count = 0;
        while((line = br.readLine()) !=null){
            // for amount of rows second val in grab
            String[] b = line.split(splitBy);
            boughtItems.append(b[1]);
            count++;
        }
        // newline twice and then give suggestions using suggestions function
        System.out.println("\n\n");
        suggestions();
        // ask user how much money they brought to the store
        System.out.println("How much money did you bring to the store? (Dollar amounts only)");
        int money = scan.nextInt(); 

        System.out.println("What do you want to buy? Enter the item ID. (if done shopping, enter 'x')");
        int item = scan.nextInt();
        // ask user what item they want to buy
            // if not enough money or not enough quantity, tell to enter another item
            // if works, add to cart and subtract from item quantity and money total
            // when user says they are done, break

        // when break, create file (output.txt) holding cart details and some computations
        // append to file, not override
    }
}