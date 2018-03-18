/**
 * 
 */
package com.ubs.opsit.interviews.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ubs.opsit.interviews.constant.CommonConstants;
/**
 * @author Mayur.Sharma
 *
 */
public class TimeConverterUtility {
	
	private static final Logger logger = LoggerFactory.getLogger(TimeConverterUtility.class);

	/**
	 * @param time
	 *            Time in the form of hh:mm:ss.
	 * @return true if input is correct and false if input is not correct.
	 */
	public static boolean validateInputTime(String time) {
		logger.info("START TimeConverterUtility: validateInputTime :- "+time);
		boolean isValidate = false;
		if(StringUtils.isEmpty(time)){
			return isValidate;
		}
		Pattern timeRegexPattern = Pattern.compile(CommonConstants.REGEX_PATTERN);
		Matcher timeMatcher = timeRegexPattern.matcher(time);
		if (!timeMatcher.matches()) {
			return isValidate;
		}
		isValidate=true;
		logger.info("END TimeConverterUtility: validateInputTime :- "+isValidate);
		return isValidate;
	}
	
	/**
	 * @param numeric
	 * @param redLamp
	 * @param yellowLamp
	 * @return
	 */
	public static String getCountOfRedOrYellowLamps(int numeric, String redLamp, String yellowLamp) {
		StringBuilder lamps = new StringBuilder(
				CommonConstants.ELEVEN_OFF_LAMPS);
		for (int i = 0; i < numeric; i++) {
			if ((i + 1) % CommonConstants.COUNT_THREE != 0) {
				lamps.replace(i, i + 1, yellowLamp);
			} else {
				lamps.replace(i, i + 1, redLamp);
			}
		}
		return lamps.toString();
	}
	
	public static String getFourOffLamps(int numericValue, String strLamp) {
		StringBuilder lamps = new StringBuilder(
				CommonConstants.FOUR_OFF_LAMPS);
		for (int i = 0; i < numericValue; i++) {
			lamps.replace(i, i + 1, strLamp);
		}
		return lamps.toString();
	}
}
