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
class SignalHandlerStrategy1Test {
    @Autowired
    private SignalHandlerStrategy1 signalHandlerStrategy1;

    private static final String MESSAGE = "SIGNAL1_STARTED";

    @Test
    void handleSignal(CapturedOutput output) {
        signalHandlerStrategy1.handleSignal(signalHandlerStrategy1.getSignal());
        Assertions.assertTrue(output.getOut().contains(MESSAGE));
    }

    @Test
    void getSignal() {
        Assertions.assertEquals(1, signalHandlerStrategy1.getSignal());
    }
}