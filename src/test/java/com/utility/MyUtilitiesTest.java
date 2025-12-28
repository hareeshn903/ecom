package com.utility;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MyUtilitiesTest {

    @Test
    void testNotNull() {
        String value = "test";
        assertNotNull(value);
    }
}
