package JavaOOp.L04Inheritance.Exercises.p07BookShop;

public class Book {
    private String title;
    private String author;
    private double price;

    public Book(String author, String title, double price) {
        this.setTitle(title);
        this.setAuthor(author);
        this.setPrice(price);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) throws IllegalArgumentException {
        if (title.length() < 3) {
            throw new IllegalArgumentException("Title not valid!");
        }
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) throws IllegalArgumentException {
        if (author.contains(" ")) {
            int indexOfFirstLetherOFSecondName = author.indexOf(" ") + 1;
            if (Character.isDigit(author.charAt(indexOfFirstLetherOFSecondName))) {
                throw new IllegalArgumentException("Author not valid!");
            }
        }
        // if (author.matches("[a-zA-Z]+ \\d+[a-zA-Z]+")){
        //     throw new IllegalArgumentException("Author not valid!");
        // }
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) throws IllegalArgumentException {
        if (price < 1) {
            throw new IllegalArgumentException("Price not valid!");
        }
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("Type: %s\n" +
                        "Title: %s\n" +
                        "Author: %s\n" +
                        "Price: %.1f\n"
                , this.getClass().getSimpleName()
                , this.getTitle()
                , this.getAuthor()
                , this.getPrice());
    }
}
