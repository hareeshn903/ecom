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
    void testDoPost_success() throws Exception {

        addcustomer servlet = new addcustomer();

        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        HttpSession session = mock(HttpSession.class);
        RequestDispatcher dispatcher = mock(RequestDispatcher.class);

        // 🔹 Mock ALL request parameters used by servlet
        when(request.getParameter("name")).thenReturn("Hari");
        when(request.getParameter("email")).thenReturn("hari@test.com");
        when(request.getParameter("password")).thenReturn("pass123");
        when(request.getParameter("mobile")).thenReturn("9999999999");
        when(request.getParameter("address")).thenReturn("Bangalore");

        // 🔹 Mock session access
        when(request.getSession()).thenReturn(session);

        // 🔹 Mock JSP forward
        when(request.getRequestDispatcher(anyString()))
                .thenReturn(dispatcher);

        // 🔹 Execute servlet
        servlet.doPost(request, response);

        // 🔹 Verify behavior (NOT internal logic)
        verify(request, atLeastOnce()).getParameter("name");
        verify(request).getSession();
        verify(dispatcher).forward(request, response);
    }
}
