package retry;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {
	private static final Logger LOG = (Logger) LogManager.getLogger("Retry.class");

	private static final int maxTry = 2;//try number

	private int count = 0;//to track count of retry,count value should be less than retry.

	@Override

	public boolean retry(final ITestResult iTestResult) {//method belongs to iretryanalyzer interface

		if (!iTestResult.isSuccess()) {

			if (this.count < maxTry) {

				LOG.info("Retrying test " + iTestResult.getName() + " with status "

						+ getResultStatusName(iTestResult.getStatus()) + " for the " + (this.count + 1) + " time(s).");

				this.count++;

				return true;

			}

		}

		return false;

	}
	public String getResultStatusName(final int status) {

		String resultName = null;

		if (status == 1) {

			resultName = "SUCCESS";

		}

		if (status == 2) {

			resultName = "FAILURE";

		}

		if (status == 3) {

			resultName = "SKIP";

		}

		return resultName;

	}


}

//if the test cases failures due to surroundings, in these circumstances retry mechanism gives one or two execution try for the particular test case
//retry is an interface.
//
