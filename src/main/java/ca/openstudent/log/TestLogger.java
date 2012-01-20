package ca.openstudent.log;

//import org.apache.log4j.Logger;
//import java.util.logging.Logger;   

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

public class TestLogger {

	 private final Logger log =   
	          LoggerFactory.getLogger(this.getClass().getName());   
	    
	    public void xyzzy() {   
	    	log.info("Starting xyxxy");   
	    	
			//Parameratized logging
	  		String bigObject = "Big Object";
	  		Object[] anotherBigObject = {"Another Big Object"};
	  		
	  		log.debug("Message: {}, {}", bigObject, anotherBigObject);
			
	    	log.trace("Trace");
	  		log.debug("Debug");
	  		log.info("Info");
	  		log.warn("Warn");
	  		log.error("Error");
	  		//log.fatal("Fatal");
	  		
	  		Marker fatal = MarkerFactory.getMarker("FATAL");    
	  		Logger logger = LoggerFactory.getLogger("aLogger"); 
	  		logger.error(fatal, "Failed to ...", "ERROR CODE");   
	  		try 
	  		{     
	  			//get JDBC connection or ... ???
	  		} 
	  		catch (Exception e) 
	  		{      
	  			logger.error(fatal, "Failed to or ...", "ERROR CODE");   
	  		}
	  		// do something    
	    	log.info("Completed xyzzy");   
	    }   
	/**
	 * @param args
	 */
	public static void main(String[] args) {	
		TestLogger testlog = new TestLogger();
		testlog.xyzzy();
	}
}


