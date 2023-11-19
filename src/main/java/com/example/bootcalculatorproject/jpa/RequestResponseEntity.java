package com.example.bootcalculatorproject.jpa;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.redis.core.RedisHash;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@AllArgsConstructor
@ToString
//@RedisHash(timeToLive = 60L)
public class RequestResponseEntity implements  Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public RequestResponseEntity(){};
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String request;
	private String response;
	private String operation;
	private Long sqlTimestamp;

}
