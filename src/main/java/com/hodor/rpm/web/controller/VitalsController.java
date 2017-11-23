package com.hodor.rpm.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hodor.rpm.web.support.ClientScriptCaller;

/**
 *
 *
 */
@RestController
@RequestMapping("/app")
public class VitalsController extends BaseRestController {

    private static final Logger LOGGER = LoggerFactory.getLogger(VitalsController.class);
    @Autowired
    private ClientScriptCaller alerter;

    @RequestMapping(value="/receive/changeprice", method = RequestMethod.GET)
    public void receiveChangeName(@RequestParam String price) {
        LOGGER.debug(">> received panic alert: " + price);
        //Get patient information using panic alert information
        //Pass the necessary arguments to the alerter
        alerter.addMessage(new String[]{price});
    }

}
