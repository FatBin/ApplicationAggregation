<%@ page import="java.util.ArrayList" %>
<%@ page import="XMLBean.All" %>
<!-- Created by L.H.S on 2017/6/11. -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Detail</title>

    <link rel="stylesheet" href="../css/bootstrap-datetimepicker.min.css">
    <link rel="stylesheet" href="../css/bootstrap.css">
    <link rel="stylesheet" href="../css/bootstrap-theme.css">
    <link rel="stylesheet" href="../css/homepage.css">
</head>
<body>

<%
    ArrayList<All> alls = (ArrayList<All>) request.getSession().getAttribute("all");
%>

<div class="top_div">
    <span onclick="location.href='/html/HomePage.jsp'"><i class="glyphicon glyphicon-home"></i>京扒网站</span>
</div>

<div class="top_search_div">

    <div class="inlineBlock">
        <img src="../img/logo.png" style="width: 150px;">
    </div>

    <div class="inlineBlock">
        <input type="text" class="form-control" placeholder="请输入电影名称">
    </div>

    <div class="inlineBlock">
        <input type="text" class="form-control" placeholder="请输入电影院名称">
    </div>

    <div class="inlineBlock">
        <input id="datetime" type="text" class="form-control" placeholder="请选择日期" readonly>
    </div>

    <div class="inlineBlock">
        <button type="button" class="btn btn-primary" style="width: 150px;" onclick="search()">立即搜索</button>
    </div>
</div>

<div class="splice_div">
    <div class="top_search_div"><i class="glyphicon glyphicon-triangle-right"></i> 电影详情</div>
</div>

<div class="movie_info">
    <div class="top_search_div">

        <div class="movie_name">
            <span><%=alls.get(0).getMoviename() %></span>
            <span class="grade"><%=alls.get(0).getScore() %></span>

            <span class="country_div"><%=alls.get(0).getCountry() %></span>
        </div>

        <hr style="border-color: #3b4967;">

        <div>

            <div class="movie_photo">
                <img src="../img/movie_photo.jpg">
            </div>

            <div class="detail_div">

                <div>导演：<span><%=alls.get(0).getDirector() %></span></div>

                <div>主演：
                    <span>
                    <%
                        for (int i = 0; i < alls.get(0).getActor().getNames().size(); i++) {
                    %>

                        <%=alls.get(0).getActor().getNames().get(i) %>

                    <%
                        if (i != alls.get(0).getActor().getNames().size() - 1) {
                    %>
                        、
                    <%
                            }
                        }
                    %>

                    </span>
                </div>

                <div><%=alls.get(0).getTag() %>
                </div>

                <div>剧情介绍：
                    <span>
                        <%=alls.get(0).getIntroduction() %>
                    </span>
                </div>
            </div>

        </div>

    </div>
</div>

<div class="content_div">

    <div class="top_search_div">

        <div class="top_search_div title_bar">搜索结果</div>

        <div class="result_div">
            <table class="table table-hover">
                <thead>
                <!-- 影院名称和地址 -->
                <td>电影院</td>
                <td>日期</td>
                <!-- 开始时间和结束时间 -->
                <td>放映时间</td>
                <td>语言版本</td>
                <td>放映厅</td>
                <td>票价</td>
                <td>供应商</td>
                </thead>

                <tbody>
                <%
                    for (All a : alls) {
                %>
                <tr>
                    <td style="padding-top: 25px;">
                        <span style="font-size: 16px;"><%=a.getTheater() %></span>
                        <div class="tip_div" style="font-size: 12px;"><span><%=a.getAddress() %></span></div>
                    </td>
                    <td style="line-height: 65px;"><%=a.getDate() %>
                    </td>
                    <td style="padding-top: 10px;">
                        <span style="font-size: 24px;"><%=a.getBegin() %></span>
                        <div class="tip_div">约<span><%=a.getEnd() %></span>散场</div>
                    </td>
                    <td style="line-height: 65px;"><%=a.getLanguage() %>
                    </td>
                    <td style="line-height: 65px;"><%=a.getHall() %>
                    </td>
                    <td class="price_td" style="line-height: 65px;"><%=a.getPrice() %>
                    </td>
                    <td style="line-height: 65px;"><%=a.getSponser() %>
                    </td>
                </tr>
                <%
                    }
                %>
                </tbody>
            </table>
        </div>

    </div>

</div>

<script src="../js/jquery-3.2.1.min.js"></script>
<script src="../js/bootstrap.js"></script>
<script src="../js/bootstrap-datetimepicker.min.js"></script>
<script src="../js/search.js"></script>
<script>
    $('#datetime').datetimepicker({
        format: 'yyyy-mm-dd',
        todayBtn: true,
        todayHighlight: true,
        autoclose: true,
        minView: "month"
    });
</script>
</body>
</html>