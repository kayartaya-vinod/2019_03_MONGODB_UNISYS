package com.unisys.entity;

import org.bson.types.ObjectId;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import xyz.morphia.annotations.Entity;
import xyz.morphia.annotations.Id;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity("customers")
public class Customer {

	@Id
	private ObjectId id;
	private String name;
	private String email;
	private Long phone;
	private String city;
	private String state;
	private String country;

}
