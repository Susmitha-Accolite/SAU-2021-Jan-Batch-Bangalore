package com.accolite.restAssginment;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/stringoperations")
public class StringOperations {
	
	//string concatenation
	
	@GetMapping("/concatenation/{firstName}/{lastName}")
	public String generate(@PathVariable("firstName") String firstName, @PathVariable("lastName") String lastName)
	{
		return firstName+lastName;
	}
	
	//converting to uppercase

	@GetMapping("uppercase/{string}")
	public String upperCase(@PathVariable("string") String string)
	{
		return string.toUpperCase();
	}
	
	//converting to lowercase
	
	@GetMapping("lowercase/{string}")
	public String lowerCase(@PathVariable("string") String string)
	{
		return string.toLowerCase();
	}
	
	//length of the string 
	
	@GetMapping("length/{string}")
	public int length(@PathVariable("string") String string)
	{
		return string.length();
	}
	
	//string comparison
	
	@GetMapping("compare/{string1}/{string2}")
	public boolean compare(@PathVariable("string1") String string1, @PathVariable("string2") String string2)
	{
		return string1.equals(string2);
	}
}
