/**
 * 
 */
package com.ubs.opsit.interviews.utils;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


/**
 * @author Mayur.Sharma
 *
 */
public class TimeConverterUtilityTest {

	@Test
	public void validateEmptyInputParameterTest(){
		String input = "";
		boolean isValidate = TimeConverterUtility.validateInputTime(input);
		assertEquals(false, isValidate);
	}
	
	@Test
	public void validateNullInputParameterTest(){
		String input = null;
		boolean isValidate = TimeConverterUtility.validateInputTime(input);
		assertEquals(false, isValidate);
	}
	
	@Test
	public void validateInvalidRegexInputParameterTest(){
		String input = "48:24:12";
		boolean isValidate = TimeConverterUtility.validateInputTime(input);
		assertEquals(false, isValidate);
	}
	
	@Test
	public void validateCharHourInvalidRegexInputParameterTest(){
		String input = "hh:00:00";
		boolean isValidate = TimeConverterUtility.validateInputTime(input);
		assertEquals(false, isValidate);
	}
	
	@Test
	public void validateCharMinInvalidRegexInputParameterTest(){
		String input = "12:MM:00";
		boolean isValidate = TimeConverterUtility.validateInputTime(input);
		assertEquals(false, isValidate);
	}
	
	@Test
	public void validateCharSecInvalidRegexInputParameterTest(){
		String input = "12:05:SS";
		boolean isValidate = TimeConverterUtility.validateInputTime(input);
		assertEquals(false, isValidate);
	}
	
	@Test
	public void validateInvalidHHMMSSRegexInputParameterTest(){
		String input = "HH:MM:SS";
		boolean isValidate = TimeConverterUtility.validateInputTime(input);
		assertEquals(false, isValidate);
	}
	
	@Test
	public void validateValidScenario1RegexInputParameterTest(){
		String input = "00:00:00";
		boolean isValidate = TimeConverterUtility.validateInputTime(input);
		assertEquals(true, isValidate);
	}
	
	@Test
	public void validateValidScenario2RegexInputParameterTest(){
		String input = "13:17:01";
		boolean isValidate = TimeConverterUtility.validateInputTime(input);
		assertEquals(true, isValidate);
	}
	
	@Test
	public void validateValidScenario3RegexInputParameterTest(){
		String input = "23:59:59";
		boolean isValidate = TimeConverterUtility.validateInputTime(input);
		assertEquals(true, isValidate);
	}
	
	@Test
	public void validateValidScenario4RegexInputParameterTest(){
		String input = "24:00:00";
		boolean isValidate = TimeConverterUtility.validateInputTime(input);
		assertEquals(false, isValidate);
	}
}
