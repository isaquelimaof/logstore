package com.cingo.logstore.logfile;

import java.io.File;
import java.util.Objects;

public class LogWrapperFactory {
	
	private static final String LOG_FILE = "cingohc.log";

	public LogWrapper build() throws LogWrapperBuildException {
		try {
			return new LogFileWrapper(new File(Objects.requireNonNull(this.getClass().getClassLoader().getResource(LOG_FILE)).toURI()));
		} catch (Exception e) {
			throw new LogWrapperBuildException(e);
		}
	}
}
