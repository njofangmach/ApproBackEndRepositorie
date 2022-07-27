package org.sid.gestapprobackend.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Product implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long oid;
	private String name;
	private String description;
	private String barrecode;
	private Integer buyingprice;
	private Integer sellingprice;
	private Integer qtystock;
	private Integer qtyalert;
	private Integer qtyreapro;
	private Integer qtyinv;
	private Long tva;
	@ManyToOne
	private Location location;
	@ManyToOne
	private Category category;
	@OneToMany(mappedBy = "product")
	private Collection<CommandLines> commandLine;

}
