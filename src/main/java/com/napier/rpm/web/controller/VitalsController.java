package com.napier.rpm.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.napier.rpm.web.support.ClientScriptCaller;

/**
 * @author NAP1057
 *
 *
 */
@RestController
@RequestMapping("/app")
public class VitalsController extends BaseRestController {

    private static final Logger LOGGER = LoggerFactory.getLogger(VitalsController.class);
    @Autowired
    private ClientScriptCaller alerter;

    @RequestMapping(value="/receive/panic", method = RequestMethod.GET)
    public void receivePanicAlert(@RequestParam String msg) {
        LOGGER.debug(">> received panic alert: " + msg);
        //Get patient information using panic alert information
        //Pass the necessary arguments to the alerter
        alerter.addMessage(new String[]{msg, "John E"});
    }

}
