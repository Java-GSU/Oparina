package by.gsu.pms;

public class Runner {
    public static void main(String[] args) {
        Book book = new Book("stl.txt", "UTF8");


        System.out.println(book.toStringAsCollection());
    }
}
