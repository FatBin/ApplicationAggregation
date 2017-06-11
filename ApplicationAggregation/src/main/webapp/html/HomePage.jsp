<!-- Created by L.H.S on 2017/6/11. -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>HomePage</title>

    <link rel="stylesheet" href="../css/bootstrap-datetimepicker.min.css">
    <link rel="stylesheet" href="../css/bootstrap.css">
    <link rel="stylesheet" href="../css/bootstrap-theme.css">
    <link rel="stylesheet" href="../css/homepage.css">
</head>
<body style="background: url('../img/bg.jpg') no-repeat; background-size: 100%">

<div class="top_div">
    <i class="glyphicon glyphicon-home"></i>京扒网站
</div>

<div class="main_body">

    <div class="input_div">

        <input type="text" class="form-control" placeholder="请输入电影名称">

        <input type="text" class="form-control" placeholder="请输入电影院名称">

        <input id="datetime" type="text" class="form-control" placeholder="请选择日期" readonly>
    </div>

    <div class="right_part">
        <img src="../img/logo.png">

        <div class="searchBtn_div">
            <button type="button" class="btn btn-primary" style="width: 270px;" onclick="search()">立即搜索</button>
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