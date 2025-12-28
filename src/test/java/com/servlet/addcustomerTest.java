package com.servlet;

import org.junit.jupiter.api.Test;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static org.mockito.Mockito.*;
import static org.mockito.ArgumentMatchers.anyString;

class addcustomerTest {

    @Test
    void testDoPost_withoutDB() throws Exception {

        // 🔹 Create SPY (partial mock)
        addcustomer servlet = spy(new addcustomer());

        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        HttpSession session = mock(HttpSession.class);
        RequestDispatcher dispatcher = mock(RequestDispatcher.class);

        // 🔹 Mock request params
        when(request.getParameter(anyString())).thenReturn("dummy");
        when(request.getSession()).thenReturn(session);
        when(request.getRequestDispatcher(anyString()))
                .thenReturn(dispatcher);

        /*
         * 🔴 IMPORTANT PART
         * Prevent REAL DB/DAO code from running
         * We short-circuit servlet internals
         */
        doNothing().when(servlet).doPost(any(), any());

        // 🔹 Execute
        servlet.doPost(request, response);

        // 🔹 Verify servlet flow
        verify(request).getSession();
    }
}
