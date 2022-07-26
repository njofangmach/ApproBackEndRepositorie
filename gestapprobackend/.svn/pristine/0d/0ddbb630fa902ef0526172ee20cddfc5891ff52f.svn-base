package org.sid.gestapprobackend.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Warehouse implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long oid;
	private String name;
	private String code;
	@ManyToOne
	@JsonProperty(access=Access.WRITE_ONLY)
	private Site site;
	@OneToMany(mappedBy = "warehouse")
	private Collection<Command> command;
	@OneToMany(mappedBy = "warehouse")
	private Collection<Walkout> cwalkout;

}
