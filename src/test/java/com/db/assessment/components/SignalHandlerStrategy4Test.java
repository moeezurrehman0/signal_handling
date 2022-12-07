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
class SignalHandlerStrategy4Test {
    @Autowired
    private SignalHandlerStrategy4 signalHandlerStrategy4;

    private static final String MESSAGE = "SIGNAL4_STARTED";

    @Test
    void handleSignal(CapturedOutput output) {
        signalHandlerStrategy4.handleSignal(signalHandlerStrategy4.getSignal());
        Assertions.assertTrue(output.getOut().contains(MESSAGE));
    }

    @Test
    void getSignal() {
        Assertions.assertEquals(4, signalHandlerStrategy4.getSignal());
    }
}