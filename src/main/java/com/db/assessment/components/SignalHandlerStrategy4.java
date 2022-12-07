package com.db.assessment.components;

import com.db.assessment.services.Algo;
import com.db.assessment.services.SignalHandlerStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SignalHandlerStrategy4 implements SignalHandlerStrategy {
    private Logger logger = LoggerFactory.getLogger(SignalHandlerStrategy4.class);
    @Autowired
    private Algo algo;

    @Override
    public void handleSignal(int signal) {
        logger.info("SIGNAL4_STARTED");
        algo.setUp();
        algo.setAlgoParam(1, 60);
        algo.performCalc();
        algo.submitToMarket();
        algo.doAlgo();
        logger.info("SIGNAL4_FINISHED");
    }

    @Override
    public int getSignal() {
        return 4;
    }
}
