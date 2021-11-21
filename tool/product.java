public abstract class Product{
    int id;
    String name;
    int price;
    int rating;

    public Product(int id, String name, int price, int rating){
        this.id = id;
        this.name = name;
        this.price = price;
        this.rating = rating;
    }
}