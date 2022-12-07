package com.db.assessment.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SignalHandlerImplementation implements SignalHandler {
    private Logger logger = LoggerFactory.getLogger(SignalHandlerImplementation.class);

    @Autowired
    private Algo algo;

    @Override
    public void handleSignal(int signal) {
    }
}
