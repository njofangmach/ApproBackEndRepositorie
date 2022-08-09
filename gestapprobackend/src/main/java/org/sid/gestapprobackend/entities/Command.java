package org.sid.gestapprobackend.entities;

import java.io.Serializable;
import java.sql.Date;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.web.bind.annotation.CrossOrigin;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@CrossOrigin("*")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Command implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long oid;
	private String asknum;
	private Date askdate;
	private String numcmd;
	private Date datecmd;
	private Integer delevrytime;
	private Integer reduction;
	@ManyToOne
	private Coastcenter coastcenter;
	@ManyToOne
	private Company company;
	@ManyToOne
	private Warehouse warehouse;
	@ManyToOne
	private State state;
	@ManyToOne
	private Provider provider;
	@OneToMany(mappedBy = "command")
	private Collection<CommandLines> commandLine;
	@OneToMany(mappedBy = "command")
	private Collection<Walkin> cwalkin;
}
