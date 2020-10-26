package com.hengyunsoft.sso.util;

public class CasUtils {
	
	/**
	 * Removes the previously attached GET parameters "lt" and "error_message"
	 * to be able to send new ones.
	 * 
	 * @param casUrl
	 * @return
	 */
	public static String resetUrl(String casUrl) {
		String cleanedUrl;
		String[] paramsToBeRemoved = new String[] { "lt", "error_message",
				"get-lt" };
		cleanedUrl = removeHttpGetParameters(casUrl, paramsToBeRemoved);
		return cleanedUrl;
	}

	/**
	 * Removes selected HTTP GET parameters from a given URL
	 * 
	 * @param casUrl
	 * @param paramsToBeRemoved
	 * @return
	 */
	public static String removeHttpGetParameters(String casUrl,
			String[] paramsToBeRemoved) {
		String cleanedUrl = casUrl;
		if (casUrl != null) {
			// check if there is any query string at all
			if (casUrl.indexOf("?") == -1) {
				return casUrl;
			} else {
				// determine the start and end position of the parameters to be
				// removed
				int startPosition, endPosition;
				boolean containsOneOfTheUnwantedParams = false;
				for (String paramToBeErased : paramsToBeRemoved) {
					startPosition = -1;
					endPosition = -1;
					if (cleanedUrl.indexOf("?" + paramToBeErased + "=") > -1) {
						startPosition = cleanedUrl.indexOf("?"
								+ paramToBeErased + "=") + 1;
					} else if (cleanedUrl.indexOf("&" + paramToBeErased + "=") > -1) {
						startPosition = cleanedUrl.indexOf("&"
								+ paramToBeErased + "=") + 1;
					}
					if (startPosition > -1) {
						int temp = cleanedUrl.indexOf("&", startPosition);
						endPosition = (temp > -1) ? temp + 1 : cleanedUrl
								.length();
						// remove that parameter, leaving the rest untouched
						cleanedUrl = cleanedUrl.substring(0, startPosition)
								+ cleanedUrl.substring(endPosition);
						containsOneOfTheUnwantedParams = true;
					}
				}

				// wenn nur noch das Fragezeichen vom query string √ºbrig oder
				// am
				// schluss ein "&", dann auch dieses entfernen
				if (cleanedUrl.endsWith("?") || cleanedUrl.endsWith("&")) {
					cleanedUrl = cleanedUrl.substring(0,
							cleanedUrl.length() - 1);
				}
				// parameter mehrfach angegeben wurde...
				if (!containsOneOfTheUnwantedParams)
					return casUrl;
				else
					cleanedUrl = removeHttpGetParameters(cleanedUrl,
							paramsToBeRemoved);
			}
		}
		return cleanedUrl;
	}
	
}
