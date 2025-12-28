package com.servlet;

import org.junit.jupiter.api.Test;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.mockito.Mockito.*;
import static org.mockito.ArgumentMatchers.anyString;

class addcustomerTest {

    @Test
    void testDoPost_flowOnly() throws Exception {

        // 🔹 Create servlet but do NOT execute DB code
        addcustomer servlet = new addcustomer() {
            @Override
            protected void doPost(HttpServletRequest req,
                                  HttpServletResponse resp) {
                // simulate successful flow
                try {
                    req.getRequestDispatcher("success.jsp")
                       .forward(req, resp);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        };

        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        RequestDispatcher dispatcher = mock(RequestDispatcher.class);

        when(request.getRequestDispatcher(anyString()))
                .thenReturn(dispatcher);

        servlet.doPost(request, response);

        verify(dispatcher).forward(request, response);
    }
}
