package nyc.c4q.unit4finalprep.model;

/**
 * Created by joannesong on 1/10/18.
 */

public class BookModel {
    private String id;
    private String name;
    private String author;
    private double price;


    public BookModel(String id, String name, String author, int price) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }
}
