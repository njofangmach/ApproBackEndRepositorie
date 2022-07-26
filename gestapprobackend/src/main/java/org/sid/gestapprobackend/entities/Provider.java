package org.sid.gestapprobackend.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class Provider implements Serializable{

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long oid;
	private String name;
	private String code;
	private String company;
	private String adress;
	private String phone;
	private String email;
	private String observation;
	private String town;
	@JsonIgnore
	@OneToMany(mappedBy="provider")
	private Collection<Command> command;

}
