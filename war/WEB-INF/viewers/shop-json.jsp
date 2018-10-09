<%@ page import="java.util.List"%>
<%@ page import="com.google.gson.Gson"%>
<%@ page import="com.tmd.caf2.model.Shop"%>


<%
List<Shop> shops = (List<Shop>) request.getAttribute("shops");

Gson gson = new Gson();

String jsonInString = gson.toJson(shops);
String results = "  { \"html_attributions\" : [],\"results\" : ";
String end = ",\"status\" : \"OK\"}";
response.getWriter().println(results + jsonInString + end);
%>