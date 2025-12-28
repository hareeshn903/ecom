package com.servlet;

import javax.servlet.http.*;
import javax.servlet.RequestDispatcher;

import org.junit.jupiter.api.Test;


import static org.mockito.Mockito.*;
import static org.mockito.Mockito.*;
import static org.mockito.ArgumentMatchers.anyString;


class addcustomerTest {

    @Test
    void testDoPost() throws Exception {

        addcustomer servlet = new addcustomer();

        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        RequestDispatcher dispatcher = mock(RequestDispatcher.class);

        when(request.getParameter("name")).thenReturn("Hari");
        when(request.getParameter("email")).thenReturn("hari@test.com");
        when(request.getRequestDispatcher(anyString()))
                .thenReturn(dispatcher);

        servlet.doPost(request, response);

        verify(request, atLeastOnce()).getParameter("name");
        verify(dispatcher).forward(request, response);
    }
}
