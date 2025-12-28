package com.dao;

import org.junit.jupiter.api.*;
import java.sql.*;

import static org.junit.jupiter.api.Assertions.*;

class DAOTest {

    private static Connection connection;

    @BeforeAll
    static void setupDB() throws Exception {
        connection = DriverManager.getConnection(
                "jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1");

        Statement stmt = connection.createStatement();
        stmt.execute("""
            CREATE TABLE product (
                pid INT PRIMARY KEY,
                pname VARCHAR(100),
                price INT
            )
        """);
    }

    @Test
    void testInsertProduct() throws Exception {
        PreparedStatement ps = connection.prepareStatement(
                "INSERT INTO product VALUES (?, ?, ?)");
        ps.setInt(1, 1);
        ps.setString(2, "Mobile");
        ps.setInt(3, 20000);
        ps.executeUpdate();

        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM product");

        assertTrue(rs.next());
        assertEquals("Mobile", rs.getString("pname"));
    }

    @AfterAll
    static void closeDB() throws Exception {
        connection.close();
    }
}
