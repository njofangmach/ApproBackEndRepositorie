package org.sid.gestapprobackend.entities;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.web.bind.annotation.CrossOrigin;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@CrossOrigin("*")
@Entity 
@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class Mvtstock implements Serializable{
  
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long oid;
	private Date quandite;
	@ManyToOne
	private Walkin cwalkin;
    @ManyToOne
    private Walkout cwalkout;
	
}
