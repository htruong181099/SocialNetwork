<%
    String title = "Social Network";
    if (request.getAttribute("title") != null) {
        title = (String) request.getAttribute("title");
    }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Banana</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="" />
        <meta name="keywords" content="" />
        <link rel="stylesheet" type="text/css" href="public/css/animate.css">
        <link rel="stylesheet" type="text/css" href="public/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="public/css/line-awesome.css">
        <link rel="stylesheet" type="text/css" href="public/css/line-awesome-font-awesome.min.css">
        <link rel="stylesheet" type="text/css" href="public/css/font-awesome.min.css">
        <link rel="stylesheet" type="text/css" href="public/css/jquery.mCustomScrollbar.min.css">
        <link rel="stylesheet" type="text/css" href="public/lib/slick/slick.css">
        <link rel="stylesheet" type="text/css" href="public/lib/slick/slick-theme.css">
        <link rel="stylesheet" type="text/css" href="public/css/style.css">
        <link rel="stylesheet" type="text/css" href="public/css/responsive.css">
        <link rel="stylesheet" type="text/css" href="public/css/login.css">

    </head>
    <body>
