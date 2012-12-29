package com.cmq.module.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cmq.module.util.JsonParser;

public class FormServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7993494837221870139L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("req========================>>>>"+JsonParser.encode(req.getInputStream()));
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
}
