package mysql.business;
import java.sql.*;
import java.util.ArrayList;

public class BookDB {

    private static String url = "jdbc:mysql://localhost/store?serverTimezone=Europe/Moscow&useSSL=false";
    private static String username = "root";
    private static String password = "jhj5655565";

    public static ArrayList<Book> select() {

        ArrayList<Book> products = new ArrayList<Book>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){

                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM book");
                while(resultSet.next()){

                    int id = resultSet.getInt(1);
                    String authorName = resultSet.getString(2);
                    int year = resultSet.getInt(3);
                    String text = resultSet.getString(4);

                    Book book = new Book(id, authorName, year, text);
                    products.add(book);
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return products;
    }

    public static Book selectOne(int id) {

        Book books = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){

                String sql = "SELECT * FROM book WHERE Id=?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setInt(1, id);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    if(resultSet.next()){

                        int booId = resultSet.getInt(1);
                        String authorName = resultSet.getString(2);
                        int year = resultSet.getInt(3);
                        String text = resultSet.getString(4);
                        books = new Book(booId, authorName, year, text);
                    }
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return books;
    }

    public static int insert(Book book) {

        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){

                String sql = "INSERT INTO book(AuthorName,YearOfBook,Text) Values (?, ?, ?)";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setString(1, book.getName());
                    preparedStatement.setInt(2, book.getYear());
                    preparedStatement.setString(3, book.getText());

                    return  preparedStatement.executeUpdate();
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return 0;
    }

    public static int update(Book book) {

        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){

                String sql = "UPDATE book SET AuthorName = ?, YearOfBook = ?, Text = ? WHERE Id = ?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setString(1, book.getName());
                    preparedStatement.setInt(2, book.getYear());
                    preparedStatement.setString(3, book.getText());
                    preparedStatement.setInt(4, book.getId());

                    return  preparedStatement.executeUpdate();
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return 0;
    }

    public static int delete(int id) {

        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){

                String sql = "DELETE FROM book WHERE Id = ?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setInt(1, id);

                    return  preparedStatement.executeUpdate();
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return 0;
    }
}