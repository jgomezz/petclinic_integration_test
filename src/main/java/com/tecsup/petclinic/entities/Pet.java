package com.tecsup.petclinic.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * 
 * @author jgomezm
 *
 */
@NoArgsConstructor
@Entity(name = "pets")
@Data
public class Pet {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "name")
	private String name;

	@Column(name = "type_id")
	private int typeId;

	@Column(name = "owner_id")
	private int ownerId;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "birth_date")
	private Date birthDate;


	@OneToMany(mappedBy = "pet", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@ToString.Exclude
	//@EqualsAndHashCode.Exclude
	private Set<Visit> visits;

//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "type_id")
//	@ToString.Exclude
//	private PetType type;

//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "owner_id")
//	@ToString.Exclude
//	private Owner owner;

	public Pet(Integer id, String name, int type_id, int owner_id, Date birthDate) {
		super();
		this.id = id;
		this.name = name;
		this.typeId = type_id;
		this.ownerId = owner_id;
		this.birthDate = birthDate;

	}

	public Pet(String name, int type_id, int owner_id, Date birthDate) {
		super();
		this.name = name;
		this.typeId = type_id;
		this.ownerId = owner_id;
		this.birthDate = birthDate;
	}
}