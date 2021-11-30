package grocery;
public class Product{
    int id;
    String name;
    double price;
    int rating;
    // ^ this is a constructor, should not be abstract because of the way it is used
    public Product(int id, String name, double price, int rating){
        this.id = id;
        this.name = name;
        this.price = price;
        this.rating = rating;
    }

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public double getPrice(){
        return price;
    }

    public int getRating(){
        return rating;
    }

}