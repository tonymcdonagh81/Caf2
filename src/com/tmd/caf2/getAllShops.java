package com.tmd.caf2;


import java.util.List;
import java.io.IOException;



import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tmd.caf2.dao.*;
import com.tmd.caf2.model.*;


/**
 * Servlet implementation class getAllShops
 * will be called with the url ending with /getAllShops
 * this will trigger the DAO to getAllShops which will return the full list of shops
 * This will be a string in json form
 */

public class getAllShops extends HttpServlet {
	private static final Long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public getAllShops() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws IOException, ServletException {
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Pragma", "no-cache");
		String format = request.getParameter("format");
		String outputPage;
		
		ShopDAO dao = ShopDAO.INSTANCE;

		List<Shop> fList = dao.getAllShops();
		request.setAttribute("shops", fList);
		response.setContentType("application/json");
		outputPage = "/WEB-INF/viewers/shop-json.jsp";

		RequestDispatcher dispatcher =
				request.getRequestDispatcher(outputPage);

		dispatcher.forward(request, response);
	}



}
