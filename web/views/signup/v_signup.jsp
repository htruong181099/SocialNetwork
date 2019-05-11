<%-- 
    Document   : signup
    Created on : May 3, 2019, 10:46:03 PM
    Author     : KHANG
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="public/css/bootstrap.css">
        <link rel="stylesheet" href="public/signup.css">
    </head>
    <body>
        <%
        String username_err="",password_err="",email_err="";
    if(request.getAttribute("username_err")!=null){
    username_err=(String) request.getAttribute("username_err");}
    if(request.getAttribute("password_err")!=null){
    username_err=(String) request.getAttribute("password_err");}
    if(request.getAttribute("email_err")!=null){
    username_err=(String) request.getAttribute("email_err");
}
%>
        
        <div class="container" >
            <div class="row"  >
                <div class="col-md-5 mx-auto">
                    <div class="myform" >
                        <div class="logo mb-3">
                            <div class="col-md-12 text-center">
                                <h1>Sign up for Banana</h1>
                            </div>
                        </div>
                        <form method="post" action="user">
                            <div class="form-group">
                                <p style="color: red"><%=username_err%></p>
                                <lable for="username">User name:</lable>
                                <input type="username" name="username" placeholder="username" class="form-control" id="username">
                            </div>
                            <div class="form-group">
                                 <p style="color: red"><%=password_err%></p>
                                <label for="pwd">Password:</label>
                                <input type="password" name="password" placeholder="password" class="form-control" id="pwd">
                            </div>
                            <div class="form-group">
                                <label for="confirmpwd">Confirm password:</label>
                                <input type="password" name="confirmpwd" placeholder="confirmpwd"class="form-control" id="confirmpwd">
                            </div>
                            <div class="container">
                                <p id="fail-feedback"></p>
                            </div>
                            <div class="form-group">
                                 <p style="color: red"><%=email_err%></p>
                                <label for="email">Email:</label>
                                <input type="email" name="email" placeholder="email" class="form-control" id="email">
                            </div>
                            <div class="col-md-12 text-center ">
                                <button type="submit" class="btn btn-block btn-primary"  onclick="pass(document.getElementById('pwd').value, document.getElementById('confirmpwd'))">Submit</button>
                                <input type="hidden" name="command" value="REGISTER">
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <script>
            function pass(pwd, confirmpwd){
                var xhttp = new XMLHttpRequest();
                xhttp.onreadystatechange = function() {
                    if (this.readyState == 4 && this.status == 200){
                        document.getElementById('fail-feedback').innerHTML = this.responseText;
                    }
                }
            }
        </script>
    </body>
</html>
