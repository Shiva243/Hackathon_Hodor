/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hodor.rpm.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.atmosphere.cpr.AtmosphereResource;
import org.atmosphere.cpr.AtmosphereResourceEvent;
import org.atmosphere.cpr.AtmosphereResourceEventListenerAdapter;
import org.atmosphere.cpr.Broadcaster;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author NAP1051
 */
@Controller
public class PagesController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PagesController.class);

    private void suspend(final AtmosphereResource resource) {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        resource.addEventListener(new AtmosphereResourceEventListenerAdapter() {
            @Override
            public void onSuspend(AtmosphereResourceEvent event) {
                countDownLatch.countDown();
                resource.removeEventListener(this);
            }
        });
        resource.suspend();
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
        return "index";
    }

    @RequestMapping(value = "/twitter/concurrency")
    @ResponseBody
    public void twitterAsync(AtmosphereResource atmosphereResource) {
        final ObjectMapper mapper = new ObjectMapper();
        this.suspend(atmosphereResource);
        final Broadcaster bc = atmosphereResource.getBroadcaster();
        LOGGER.info("Atmo Resource Size: " + bc.getAtmosphereResources().size());
        bc.scheduleFixedBroadcast(new Callable<String>() {

            //@Override
            @Override
            public String call() throws Exception {
                return null;
            }

        }, 10, TimeUnit.SECONDS);
    }
}
