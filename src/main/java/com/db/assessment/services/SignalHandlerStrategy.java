package com.db.assessment.services;

public interface SignalHandlerStrategy {
    void handleSignal(int signal);
    int getSignal();
}
