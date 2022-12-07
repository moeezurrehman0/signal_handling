package com.db.assessment.components;

import com.db.assessment.services.Algo;
import com.db.assessment.services.SignalHandlerStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SignalHandlerStrategy3 implements SignalHandlerStrategy {
    private Logger logger = LoggerFactory.getLogger(SignalHandlerStrategy3.class);

    @Autowired
    private Algo algo;

    @Override
    public void handleSignal(int signal) {
        logger.info("SIGNAL3_STARTED");
        algo.setAlgoParam(1, 90);
        algo.setAlgoParam(2, 15);
        algo.performCalc();
        algo.submitToMarket();
        algo.doAlgo();
        logger.info("SIGNAL3_FINISHED");
    }

    @Override
    public int getSignal() {
        return 3;
    }
}
