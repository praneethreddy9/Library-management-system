package com.dxc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="books")
public class Books {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int bookid;
	private String name;
	private String author;
	private String category;
	private int price;
	private int rackno;
	private String status;
	public Books() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Books(int bookid, String name, String author, String category, int price, int rackno, String status) {
		super();
		this.bookid = bookid;
		this.name = name;
		this.author = author;
		this.category = category;
		this.price = price;
		this.rackno = rackno;
		this.status = status;
	}
	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getRackno() {
		return rackno;
	}
	public void setRackno(int rackno) {
		this.rackno = rackno;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Books [bookid=" + bookid + ", name=" + name + ", author=" + author + ", category=" + category+", price=" + price
				+ ", rackno=" + rackno + ", status=" + status + "]";
	}
	
	
}