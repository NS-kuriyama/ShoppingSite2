package jp.co.aforce.model;

import java.io.Serializable;

public class Book implements Serializable{
	private String id;
	private String name;
	private int price;
	private String genre;

	public Book() {}

	public Book(String name, int price, String genre) {
		this.name = name;
		this.price = price;
		this.genre = genre;
	}

	public Book(String id, String name, int price, String genre) {
		this(name,price,genre);
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}
}

