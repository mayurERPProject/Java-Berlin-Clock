package com.ubs.opsit.interviews;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ubs.opsit.interviews.constant.CommonConstants;
import com.ubs.opsit.interviews.utils.TimeConverterUtility;

public class TimeConverter {

	private static final Logger logger = LoggerFactory.getLogger(TimeConverter.class);
	
	public String convertTime(String inputTime) {
		StringBuilder convertTime = new StringBuilder();
		logger.info("START TimeConverterImpl.convertTime :- " + inputTime);
		if (!TimeConverterUtility.validateInputTime(inputTime)) {
			return CommonConstants.INVALID_TIME;
		}
		String[] splitTime = inputTime.split(CommonConstants.SEMI_COLON);
		if (splitTime != null && splitTime.length == 3) {
			convertTime.append(getSecondsCount(Integer.parseInt(splitTime[2]))).append(CommonConstants.LINE_SEPARATOR);
			convertTime.append(getHoursDivisibleByFiveCount(Integer.parseInt(splitTime[0])))
					.append(CommonConstants.LINE_SEPARATOR);
			convertTime.append(getHoursModulusOfFive(Integer.parseInt(splitTime[0])))
					.append(CommonConstants.LINE_SEPARATOR);
			convertTime.append(getMinutesDivisibleByFive(Integer.parseInt(splitTime[1])))
					.append(CommonConstants.LINE_SEPARATOR);
			convertTime.append(getMinutesModulusOfFive(Integer.parseInt(splitTime[1])));
		}
		logger.info("END TimeConverterImpl.convertTime :- " + convertTime.toString());
		return convertTime.toString();
	}

	protected String getSecondsCount(int number) {
		if (number % 2 == 0)
			return "Y";
		else
			return "O";
	}

	protected String getHoursDivisibleByFiveCount(int number) {
		return getOnOffLamp(4, getValueDivisibleByFive(number));
	}

	protected String getHoursModulusOfFive(int number) {
		return getOnOffLamp(4, number % 5);
	}

	protected String getMinutesDivisibleByFive(int number) {
		return TimeConverterUtility.getCountOfRedOrYellowLamps(getValueDivisibleByFive(number),
				CommonConstants.RED_LAMP, CommonConstants.YELLOW_LAMP).replaceAll("YYY", "YYR");
	}

	protected String getMinutesModulusOfFive(int number) {
		return TimeConverterUtility.getFourOffLamps(number % 5, CommonConstants.YELLOW_LAMP);
	}

	private int getValueDivisibleByFive(int number) {
		return (number - (number % 5)) / 5;
	}

	private String getOnOffLamp(int lamps, int onSigns) {
		return TimeConverterUtility.getFourOffLamps(onSigns, "R");
	}

}
