package com.ishare888.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TestReactive implements Serializable {
	
	private Long id;
	private String user;

	
}