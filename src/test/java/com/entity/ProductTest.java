package com.entity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    @Test
    void testProductGettersSetters() {
        Product p = new Product();
        p.setPid(1);
        p.setPname("Laptop");
        p.setPprice(55000);

        assertEquals(1, p.getPid());
        assertEquals("Laptop", p.getPname());
        assertEquals(55000, p.getPprice());
    }
}
