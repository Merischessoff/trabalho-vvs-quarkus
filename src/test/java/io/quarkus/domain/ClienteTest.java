package io.quarkus.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.logging.Logger;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

class ClienteTest {

    private static Logger logger = Logger.getLogger("ClienteTest");

    @Test
    @Order(1)
    void ehCpfValido() {
        Cliente c = new Cliente();
        boolean ehCpfValido = c.isCPF("85002998003");
        logger.info("first");
        assertEquals(true, ehCpfValido);
    }

    @Test
    @Order(2)
    void naoEhCpfValido() {
        Cliente c = new Cliente();
        boolean ehCpfValido = c.isCPF("8500299800");
        logger.info("first");
        assertEquals(false, ehCpfValido);
    }

}
