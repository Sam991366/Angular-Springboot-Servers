package com.model;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

import com.enumeration.Status;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 *	@ author Samarth Ladani
 *	@since 26/08/2022
 *
 **/

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Server 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(unique = true)
	@NotEmpty(message = "IP Address cannot be null or empty")
	private String ipAddress;
	private String name;
	private String memory;
	private String type;
	private String 	imageUrl;
	private Status status;
	
	

}
