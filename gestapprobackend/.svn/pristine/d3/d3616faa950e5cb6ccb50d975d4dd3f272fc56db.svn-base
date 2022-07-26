package org.sid.gestapprobackend.entities;
import java.io.Serializable;
//import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.NotNull;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class CommandLines implements Serializable{
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long oid;
	//@NotBlank
    //@NotNull
	private Integer quantity;
	//@NotBlank
    //@NotNull
	private Integer unitprice;
	//@NotBlank
    //@NotNull
	private Integer reduction;
	@ManyToOne
	private Command command;
   
}
