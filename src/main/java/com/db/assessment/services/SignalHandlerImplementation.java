package com.db.assessment.services;

import com.db.assessment.components.SignalHandlerStrategyComponent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SignalHandlerImplementation implements SignalHandler {
    private Logger logger = LoggerFactory.getLogger(SignalHandlerImplementation.class);

    @Autowired
    private SignalHandlerStrategyComponent component;

    @Autowired
    private Algo algo;

    @Override
    public void handleSignal(int signal) {
        SignalHandlerStrategy signalHandlerStrategy = component.findStrategy(signal);
        if (signalHandlerStrategy != null) {
            signalHandlerStrategy.handleSignal(signal);
        } else {
            logger.info("DEFAULT_EXECUTED");
            algo.cancelTrades();
        }
    }
}
