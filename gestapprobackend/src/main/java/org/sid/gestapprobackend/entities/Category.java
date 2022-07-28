package org.sid.gestapprobackend.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.web.bind.annotation.CrossOrigin;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@CrossOrigin("*")
@Entity 
@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class Category implements Serializable{
  
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long oid;
	@Column(length=25)
	private String name;
	@Column(length=10)
	private String code;
	@JsonIgnore
	@OneToMany(mappedBy="category")
	private Collection<Product> product;
	
}
