package jp.co.aforce.bean;

import java.io.Serializable;

public class ProductBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;
	private String name;
	private int price;
	private String words;
	private String genre;

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
	public String getWords() {
		return words;
	}
	public void setWords(String words) {
		this.words = words;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
