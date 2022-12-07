package com.db.assessment.components;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.system.CapturedOutput;
import org.springframework.boot.test.system.OutputCaptureExtension;

@SpringBootTest
@ExtendWith(OutputCaptureExtension.class)
class SignalHandlerStrategy3Test {
    @Autowired
    private SignalHandlerStrategy3 signalHandlerStrategy3;

    private static final String MESSAGE = "SIGNAL3_STARTED";

    @Test
    void handleSignal(CapturedOutput output) {
        signalHandlerStrategy3.handleSignal(signalHandlerStrategy3.getSignal());
        Assertions.assertTrue(output.getOut().contains(MESSAGE));
    }

    @Test
    void getSignal() {
        Assertions.assertEquals(3, signalHandlerStrategy3.getSignal());
    }
}