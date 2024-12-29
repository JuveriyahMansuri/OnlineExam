package com.eg.demo.models;



import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="category")
public class Category {
	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long category_id;

	
	@Column
	private String category_name;
	
//	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
//    @JoinColumn(name = "category_id") // This tells JPA to use a foreign key in the Question table
//    private List<Question> questionObj;
	
	public Category() {}
	public Category(Long category_id, String category_name) {
		super();
		this.category_id = category_id;
		this.category_name = category_name;
	}

	public Long getCategory_id() {
		return category_id;
	}
	public void setCategory_id(Long category_id) {
		this.category_id = category_id;
	}
	public String getCategory_name() {
		return category_name;
	}
	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}
	
	}
