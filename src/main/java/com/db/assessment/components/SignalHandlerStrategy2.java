package com.db.assessment.components;

import com.db.assessment.services.Algo;
import com.db.assessment.services.SignalHandlerStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SignalHandlerStrategy2 implements SignalHandlerStrategy {
    private Logger logger = LoggerFactory.getLogger(SignalHandlerStrategy2.class);
    @Autowired
    private Algo algo;

    @Override
    public void handleSignal(int signal) {
        logger.info("SIGNAL2_STARTED");
        algo.reverse();
        algo.setAlgoParam(1, 80);
        algo.submitToMarket();
        algo.doAlgo();
        logger.info("SIGNAL2_FINISHED");
    }

    @Override
    public int getSignal() {
        return 2;
    }
}
