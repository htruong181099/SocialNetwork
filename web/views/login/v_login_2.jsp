<!DOCTYPE html>
<html>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <head>
        <meta charset="utf-8">
        <link rel="stylesheet" href="public/css/bootstrap.css">
        <link rel="stylesheet" type="text/css" href="public/css/login.css">
    </head>

    <body>

        <form class="box"  method="post" action="user">
            <img src="public/images/logo.png" class="avatar">
            <h1>
                LOGIN TO BANANA
            </h1>
            <input name="command" value="LOGIN" type="hidden">
            <input type="text" name="username" placeholder = "username">
            <input type="password" name="password" placeholder="password">
            <input type="submit" name="" value = "Login">
            <p class="signupbutton">
                or <a href ="/Signup"> Sign Up</a>
            </p>
            <a href ="banana/forgotpassword">
                Forgot your password
            </a>
        </form>
    </body>
</html>