package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import nl.altindag.log.LogCaptor;

public class ServiceTest {

    @Test
    public void testAppLogger() {
        LogCaptor logCaptor = LogCaptor.forClass(Service.class);
        Service.main(null);
        List<String> infoLogs = logCaptor.getInfoLogs();
        assertEquals(1, infoLogs.size());
        assertEquals("Hello World", infoLogs.get(0));
    }
}
