package com.tmd.caf2;


import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tmd.caf2.dao.*;

/**
 * Servlet implementation class getAllShops
 * will be called with the url ending with /createAllShops
 * this will trigger the DAO to createAllShops
 */

public class createAllShops extends HttpServlet {
	private static final Long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public createAllShops() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

		ShopDAO dao = ShopDAO.INSTANCE;
		
		 dao.createAllShops();
		
	}


}
