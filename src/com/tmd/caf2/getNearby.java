package com.tmd.caf2;


import java.util.List;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.ParseException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.tmd.caf2.dao.*;
import com.tmd.caf2.model.*;


/**
 * Servlet implementation class getNearby
 * will be called with the url /getNearby including parameters
 * The parameters will be checked before the DAO is triggered
 * also depending request the list will be passed to calNear for filtering
 * Then the list as a string in json form is sent
 */

public class getNearby extends HttpServlet {
	private static final Long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getNearby() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, 
    		HttpServletResponse response) throws IOException, ServletException {

    	response.setHeader("Cache-Control", "no-cache");
    	response.setHeader("Pragma", "no-cache");
    	String latParam = request.getParameter("lat");
    	String lngParam = request.getParameter("lng");
    	String radiusParam = "";
    	radiusParam = request.getParameter("radius");
    	String chainOrIndie = request.getParameter("chainOrIndie");
    	String takeAway = request.getParameter("takeAway");
    	String sitIn = request.getParameter("sitIn");
    	String rating = request.getParameter("rating");
    	CalNear calNear = new CalNear();
    	ShopDAO dao = ShopDAO.INSTANCE;

    	double lat=0;
    	double lng=0;
    	DecimalFormat decimalFormat = new DecimalFormat("#");
    	if(latParam != ""){

    		try {
    			lat = decimalFormat.parse(latParam).doubleValue();
    			lng = decimalFormat.parse(lngParam).doubleValue();
    		} catch (ParseException e) { }
    	}
    	else{		
    		lng = -2.2405208;
    		lat = 53.4828026;
    	}

    	
    	double radius=0;
    	if(radiusParam == "" || radiusParam == null){	
    		radius = 400;
    	}
    	else{
    		Double doubleObject = new Double(radiusParam);
    		radius = doubleObject.doubleValue();	
    	}

    	List<Shop> shops = dao.getNearby(lat,lng,radius);


    	if(chainOrIndie != null){
    		shops = calNear.filterChain(shops, chainOrIndie);
    	}

    	if(takeAway != null ){
    		shops = calNear.filterTake(shops);
    	}

    	if(sitIn != null){
    		shops = calNear.filterSitIn(shops);
    	}
    	
    	if(rating != null){
    		shops = calNear.filterRating(shops, rating);
    	}

    	request.setAttribute("shops", shops);
    	response.setContentType("application/json");
    	String outputPage = "/WEB-INF/viewers/shop-json.jsp";

    	RequestDispatcher dispatcher =
    			request.getRequestDispatcher(outputPage);

    	dispatcher.forward(request, response);


    }



}
