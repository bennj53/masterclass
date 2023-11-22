package com.octo.masterclass.exceptions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PlatNotFoundException extends  RuntimeException{
    Logger logger = LogManager.getLogger(PlatNotFoundException.class);
    public PlatNotFoundException(String id) {
        logger.warn("Le plat " + id + " n'a pas été trouvé");
    }
}
