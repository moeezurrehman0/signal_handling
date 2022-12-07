package com.db.assessment;

import com.db.assessment.models.SignalHandlerDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.system.CapturedOutput;
import org.springframework.boot.test.system.OutputCaptureExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.stream.Stream;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@ExtendWith(OutputCaptureExtension.class)
@SpringBootTest
class AssessmentApplicationTests {
    @Autowired
    private MockMvc mvc;

    @ParameterizedTest
    @MethodSource("sendSignalParameters")
    public void sendSignal(int signal, String log, CapturedOutput output) throws Exception {
        mvc.perform(MockMvcRequestBuilders
                        .post("/api/signal/handle")
                        .content(asJsonString(new SignalHandlerDTO(signal)))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful());

        Assertions.assertTrue(output.getOut().contains(log));
    }

    private static Stream<Arguments> sendSignalParameters() {
        return Stream.of(
                Arguments.of(1, "SIGNAL1_STARTED"),
                Arguments.of(2, "SIGNAL2_STARTED"),
                Arguments.of(3, "SIGNAL3_STARTED"),
                Arguments.of(5, "DEFAULT_EXECUTED")
        );
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
