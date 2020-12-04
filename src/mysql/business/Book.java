package mysql.business;

import java.io.Serializable;

public class Book implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;
    private String name;
    private String text;
    private int year;

    public Book(){ }
    public Book(String name, int year, String text){

        this.name = name;
        this.year = year;
        this.text = text;
    }
    public Book(int id, String name, int year, String text){

        this.id = id;
        this.name = name;
        this.year = year;
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}