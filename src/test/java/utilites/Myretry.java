package utilites;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Myretry implements IRetryAnalyzer  {
	int counter=0;
	int retrylimit=2;
		@Override
		public boolean retry(ITestResult result) {
			if(counter<retrylimit)
			{
				counter++;
				return true ;
				
			}
			else
			{
			return false;
			}
		}

	}