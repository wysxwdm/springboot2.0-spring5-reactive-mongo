package com.ishare888.web.mvc;

import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController("/api/v1")
public class TestSpringMVC {

	@RequestMapping("/test/mvc")
	public String test() {
		return "hello mvc";
	}
	
	// GET /test1/42;q=11;r=22
	@GetMapping("/test1/{testId}")
	public String findPet1(@PathVariable String testId, @MatrixVariable int q) {
	    // petId == 42
	    // q == 11
		System.out.println("testId=" + testId + ": q=" + q);
		return "testId=" + testId + ": q=" + q;
	}
	
	// GET /test2/42;q=11/test1/21;q=22
	@GetMapping("/test2/{test2Id}/test1/{test1Id}")
	public void findPet2(
	        @MatrixVariable(name="q", pathVar="test2Id") int q1,
	        @MatrixVariable(name="q", pathVar="test1Id") int q2) {

	    // q1 == 11
	    // q2 == 22
	}
	
	// GET /owners/42;q=11;r=12/pets/21;q=22;s=23
	@GetMapping("/owners/{ownerIds}/pets/{petId}")
	public void findPet4(
	        @MatrixVariable MultiValueMap<String, String> matrixVars,
	        @MatrixVariable(pathVar="petId") MultiValueMap<String, String> petMatrixVars) {

	    // matrixVars: ["q" : [11,22], "r" : 12, "s" : 23]
	    // petMatrixVars: ["q" : 22, "s" : 23]
	}
	
}
