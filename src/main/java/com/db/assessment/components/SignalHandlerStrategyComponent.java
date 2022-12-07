package com.db.assessment.components;

import com.db.assessment.services.SignalHandlerStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Component
public class SignalHandlerStrategyComponent {
    private Map<Integer, SignalHandlerStrategy> strategies;

    @Autowired
    public SignalHandlerStrategyComponent(Set<SignalHandlerStrategy> strategySet) {
        createStrategy(strategySet);
    }

    public SignalHandlerStrategy findStrategy(Integer signal) {
        return strategies.get(signal);
    }

    private void createStrategy(Set<SignalHandlerStrategy> strategySet) {
        strategies = new HashMap<Integer, SignalHandlerStrategy>();
        strategySet.forEach(
                strategy -> strategies.put(strategy.getSignal(), strategy));
    }
}
