package com.db.assessment.controllers;

import com.db.assessment.models.SignalHandlerDTO;
import com.db.assessment.services.SignalHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/signal")
public class SignalHandlerController {
    @Autowired
    private SignalHandler signalHandler;

    @PostMapping("/handle")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void handle(@RequestBody SignalHandlerDTO signalHandlerDTO) {
        signalHandler.handleSignal(signalHandlerDTO.getSignal());
    }
}
