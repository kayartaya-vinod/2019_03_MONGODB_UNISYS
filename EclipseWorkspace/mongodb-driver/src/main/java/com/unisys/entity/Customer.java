package com.unisys.entity;

import org.bson.types.ObjectId;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class Customer {

	private ObjectId id;
	private String name;
	private String email;
	private Long phone;
	private String city;
	private String state;
	private String country;

}
