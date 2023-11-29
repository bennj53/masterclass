package com.octo.masterclass.domain.exceptions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PlatNotFoundException extends  Exception{
    Logger logger = LogManager.getLogger(PlatNotFoundException.class);
    public PlatNotFoundException(String id) {
        logger.warn("Le plat " + id + " n'a pas été trouvé");
    }
}
