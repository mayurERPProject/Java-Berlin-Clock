/**
 * 
 */
package com.ubs.opsit.interviews;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.ubs.opsit.interviews.constant.CommonConstants;

/**
 * @author Mayur.Sharma
 *
 */
public class TimeConverterTest {

	private TimeConverter timeConverter = new TimeConverter();

	@Test
	public void yellowLampShouldBlinkOnOffEveryTwoSecondsTests() {
		assertEquals("Y", timeConverter.getSecondsCount(0));
		assertEquals("O", timeConverter.getSecondsCount(1));
		assertEquals("O", timeConverter.getSecondsCount(59));
	}

	@Test
	public void getHoursDivisibleByFiveCountTest() {
		assertEquals(4, timeConverter.getHoursDivisibleByFiveCount(7).length());
	}

	@Test
	public void getHoursModulusOfFiveTest() {
		assertEquals(4, timeConverter.getHoursModulusOfFive(5).length());
	}

	@Test
	public void getMinutesDivisibleByFiveTest() {
		assertEquals(11, timeConverter.getMinutesDivisibleByFive(34).length());
	}

	@Test
	public void getMinutesModulusOfFiveTest() {
		assertEquals(4, timeConverter.getMinutesModulusOfFive(0).length());
	}

	@Test
	public void hoursDivisibleByFiveShouldLightRedLampForEvery5HoursTest() {
		assertEquals("OOOO", timeConverter.getHoursDivisibleByFiveCount(0));
		assertEquals("RROO", timeConverter.getHoursDivisibleByFiveCount(13));
		assertEquals("RRRR", timeConverter.getHoursDivisibleByFiveCount(23));
		assertEquals("RRRR", timeConverter.getHoursDivisibleByFiveCount(24));
	}

	@Test
	public void hoursModulusOfFiveShouldLightRedLampTest() {
		assertEquals("OOOO", timeConverter.getHoursModulusOfFive(0));
		assertEquals("RRRO", timeConverter.getHoursModulusOfFive(13));
		assertEquals("RRRO", timeConverter.getHoursModulusOfFive(23));
		assertEquals("RRRR", timeConverter.getHoursModulusOfFive(24));
	}

	@Test
	public void minutesDivisibleByFiveShouldHave3rd6thAnd9thLampsInRedToIndicateFirstQuarterHalfAndLastQuarterTest() {
		String minutes32 = timeConverter.getMinutesDivisibleByFive(32);
		assertEquals("R", minutes32.substring(2, 3));
		assertEquals("R", minutes32.substring(5, 6));
		assertEquals("O", minutes32.substring(8, 9));
	}

	@Test
	public void minutesShouldLightYellowLampForEvery5MinutesUnlessItIsFirstQuarterHalfOrLastQuarter() {
		assertEquals("OOOOOOOOOOO", timeConverter.getMinutesDivisibleByFive(0));
		assertEquals("YYROOOOOOOO", timeConverter.getMinutesDivisibleByFive(17));
		assertEquals("YYRYYRYYRYY", timeConverter.getMinutesDivisibleByFive(59));
	}

	@Test
	public void minutesModulusOfFiveShouldLightYellowLampTest() {
		assertEquals("OOOO", timeConverter.getMinutesModulusOfFive(0));
		assertEquals("YYOO", timeConverter.getMinutesModulusOfFive(17));
		assertEquals("YYYY", timeConverter.getMinutesModulusOfFive(59));
	}

	@Test
	public void berlinClockShouldResultInArrayWith5Elements() {
		assertEquals(5, timeConverter.convertTime("13:17:01").split(CommonConstants.LINE_SEPARATOR).length);
	}

	@Test
	public void berlinClockShouldResultInCorrectSecondsHoursAndMinutes() {
		String[] berlinTime = timeConverter.convertTime("16:37:16").split(CommonConstants.LINE_SEPARATOR);
		String[] expected = new String[] { "Y", "RRRO", "ROOO", "YYRYYRYOOOO", "YYOO" };
		assertEquals(expected.length, berlinTime.length);
		for (int index = 0; index < expected.length; index++) {
			assertEquals(expected[index], berlinTime[index]);
		}
	}

	@Test
	public void berlinClockScenarioMidNight() {
		String[] berlinTime = timeConverter.convertTime("00:00:00").split(CommonConstants.LINE_SEPARATOR);
		String[] expected = new String[] { "Y", "OOOO", "OOOO", "OOOOOOOOOOO", "OOOO" };
		assertEquals(expected.length, berlinTime.length);
		for (int index = 0; index < expected.length; index++) {
			assertEquals(expected[index], berlinTime[index]);
		}
	}
	
	@Test
	public void berlinClockScenarioMiddleOfAfterNoon() {
		String[] berlinTime = timeConverter.convertTime("13:17:01").split(CommonConstants.LINE_SEPARATOR);
		String[] expected = new String[] { "O", "RROO", "RRRO", "YYROOOOOOOO", "YYOO" };
		assertEquals(expected.length, berlinTime.length);
		for (int index = 0; index < expected.length; index++) {
			assertEquals(expected[index], berlinTime[index]);
		}
	}
	
	@Test
	public void berlinClockScenarioJustBeforeMidNight() {
		String[] berlinTime = timeConverter.convertTime("23:59:59").split(CommonConstants.LINE_SEPARATOR);
		String[] expected = new String[] { "O", "RRRR", "RRRO", "YYRYYRYYRYY", "YYYY" };
		assertEquals(expected.length, berlinTime.length);
		for (int index = 0; index < expected.length; index++) {
			assertEquals(expected[index], berlinTime[index]);
		}
	}
	
	@Test
	public void berlinClockScenarioInvalidMidNight() {
		String[] berlinTime = timeConverter.convertTime("24:00:00").split(CommonConstants.LINE_SEPARATOR);
		String[] expected = new String[] { CommonConstants.INVALID_TIME };
		assertEquals(expected.length, berlinTime.length);
		for (int index = 0; index < expected.length; index++) {
			assertEquals(expected[index], berlinTime[index]);
		}
	}

}
