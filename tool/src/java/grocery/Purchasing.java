// This is a Java program which inputs a file and outputs
// Look at your code, they look at your class name. 
package grocery;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
public class Purchasing{
    public static void suggestions(){
        // create function for generating suggestions, choose 2-4 suggestions?
        // top 3 most bought items, inputs purchasehistory.txt
        // read in file
        try{
            BufferedReader br = new BufferedReader(new FileReader("../../data/purchasehistory.txt"));
            // grab ONLY second column and add to an array
            String line = br.readLine();
            String splitBy = ",";
            ArrayList<String> items = new ArrayList<String>();
            int count = 0;
            while((line = br.readLine()) != null){
                // for amount of rows second val in grab
                String[] b = line.split(splitBy);
                items.add(b[1]);
                count++;
            }
            // randomly select two suggestions
            Random r = new Random();
            String item1;
            String item2;

            item1 = items.get(r.nextInt(count));
            item2 = items.get(r.nextInt(count));

            System.out.println("We recommend that you buy more" + item1 + "based on your purchase history.");
            System.out.println("We also recommend that you buy more" + item2 + "based on your purchase history.");
            

        }
        catch(Exception ex){
            System.out.println(ex.toString());
        }
    
    }
    public static void main(String[] args){
        try{
            Scanner scan = new Scanner(System.in);
            // input input file
            BufferedReader br = new BufferedReader(new FileReader("../../data/itemlist.txt"));
            // put itemlist.txt contents into an array of objects
            String line;
            String splitBy = ",";
            Product[] items = new Product[10];

            int count = 0;
            while((line = br.readLine()) != null){
                // for amount of rows second val in grab
                String[] b = line.split(splitBy);
                // make sure that b[0], b[1] ....
                //System.out.println(b[0] + "\t" + b[1] + "\t" + b[2] + "\t" + b[3]);
                items[count] = new Product(Integer.parseInt(b[0].trim()),b[1].toString(),Double.parseDouble(b[2].trim()),Integer.parseInt(b[3].trim()));
                count++;
            }
            // newline twice and then give suggestions using suggestions function
            System.out.println("\n\n");
            suggestions();
            // ask user how much money they brought to the store
            System.out.println("How much money did you bring to the store?");
            double money = scan.nextDouble(); 
            // ask user what item they want to buy
            ArrayList<Product> boughtItems = new ArrayList<Product>();
            while(true){
                System.out.println("What do you want to buy? Enter the item ID. (If you are done shopping, enter '0'.");
                int item = scan.nextInt();
                if (item >= 100){
                    // ask user what item they want to buy
                    if(items[item - 100].getPrice() > money){
                        System.out.println("You don't have enough money to buy this item.");
                    }
                        // if not enough money tell to enter another item
                    else if(items[item - 100].getPrice() <= money){
                        // if works, add to cart and subtract from item quantity and money total
                        money = money - items[item - 100].getPrice();
                        System.out.println(items[item - 100].getName() + "was added to your cart. You have" + money + "left to spend.\n");
                        // add item bought
                        boughtItems.add(items[item - 100]);
                    }
                }
                // when user says they are done, break
                else { // prompt equals 0
                    System.out.println("Thank you for shopping with us!");
                    break;
                }
            }
            FileWriter fw = new FileWriter("../../data/purchasehistory.txt", true);
            PrintWriter pw = new PrintWriter(fw);
            // print all the purchased items into the purchase history
            // all purchased items should be in the items bought list
            // create as a csv file

            // for the length of boughtItems
            int amtBought = boughtItems.size();
            for(int i = 0; i < amtBought; i++){
                // append a line containing Product: ID, name, price, rating
                pw.write(boughtItems.get(i).getId() + "," + boughtItems.get(i).getName() + "," + boughtItems.get(i).getPrice() + "," + boughtItems.get(i).getRating() + "\n");
                //System.out.println(boughtItems.get(i).getId() + "," + boughtItems.get(i).getName() + "," + boughtItems.get(i).getPrice() + "," + boughtItems.get(i).getRating());
            }
            pw.close();
            //System.out.println("Array size: " + boughtItems.size());

        }
        catch(Exception ex){
            System.out.println(ex.toString());
        }
    }
}