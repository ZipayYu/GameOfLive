<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="lifegame.CellMap"%>
<%@page import="lifegame.Cell"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%!CellMap aMap = new CellMap(3, 3);%>
<%
	int row, col;
	String method;
	method = request.getParameter("method");
	//初始化
	if (method.equals("init")) {
		//获取行列数目
		row = Integer.parseInt(request.getParameter("row"));
		col = Integer.parseInt(request.getParameter("col"));
		//生成随机细胞阵列
		aMap = new CellMap(row, col);
		aMap.setLivingCells(aMap.getCells1());
		response.getWriter().println(aMap.showGraph(aMap.getCells1()));

	}

	//继续演化
	if (method.equals("cont")) {
		aMap.judgeStatu(aMap.getCells1(), aMap.getCells2());
		response.getWriter().println(aMap.showGraph(aMap.getCells2()));
		aMap.exchangeData(aMap.getCells1(), aMap.getCells2());
	}
%>
