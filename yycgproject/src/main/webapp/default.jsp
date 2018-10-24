<%@ page contentType="text/html;charset=GBK"%>

<%@ page import="org.jfree.chart.ChartFactory, 
org.jfree.chart.JFreeChart, 
org.jfree.chart.plot.PlotOrientation, 
org.jfree.chart.servlet.ServletUtilities, 
org.jfree.data.category.DefaultCategoryDataset"%>

<% 
DefaultCategoryDataset dataset = new DefaultCategoryDataset(); 
dataset.addValue(610, "Guangzhou", "Pig");
dataset.addValue(220, "Guangzhou", "Beef");
dataset.addValue(530, "Guangzhou", "Chicken");
dataset.addValue(340, "Guangzhou", "Fish");

JFreeChart chart = ChartFactory.createBarChart3D("肉类销量统计图","type","amount",dataset,PlotOrientation.VERTICAL, 
false,false,false); 
String filename = ServletUtilities.saveChartAsPNG(chart, 500, 300, null, session); 
String graphURL = request.getContextPath() + "/DisplayChart?filename=" + filename; 
%> 
<img src="http://blog.163.com/<%= graphURL %>" width=500 height=300 border=0 usemap="#<%= filename %>"> 