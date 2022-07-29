package org.sid.gestapprobackend.entities;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.web.bind.annotation.CrossOrigin;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

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
	@JsonProperty(access = Access.WRITE_ONLY)
	@ManyToOne
	private Walkin cwalkin;
	@JsonProperty(access = Access.WRITE_ONLY)
    @ManyToOne
    private Walkout cwalkout;
	
}
