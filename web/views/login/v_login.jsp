<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="public/css/bootstrap.css">
        <link rel="stylesheet" href="public/css/login.css">
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-md-5 mx-auto">
                <div class="myform">
                    <div class="logo mb-3">
                            <div class="col md-12 text-center">
                                <h1>Login to Banana</h1>
                            </div>
                    </div>
                    <form action="user" method="post">
                        
                        <div class="form-group">
                            <label for="username">User-name:</label>
                            <input type="username" name ="username" placeholder="username" class="form-control" id="username">
                        </div>
                        <div class="form-group">
                            <label for="pwd">Password:</label>
                            <input type="password" name="password" placeholder="password" class="form-control" id="pwd">
                        </div>
                        <div class="container">
                            <p id="logVal"></p>
                        </div>
                        <div class="form-group form-check">
                            <label class="form-check-label">
                            <input class="form-check-input" type="checkbox"> Remember me
                            </label>
                        </div>
                        <div class="col-md-12 text-center ">
                            <button type="submit"  class="btn btn-block btn-primary" onclick="loginVal()">Login</button>
                             <input name="command" value="LOGIN" type="hidden">
                        </div>
                        <div class="col-md-12">
                                <div class="login-or">
                                   <hr class="hr-or">
                                   <span class="span-or">or</span>
                                </div>
                        </div>
                        <div class="form-group">
                            <p class="text-center">Don't have account? <a href="/SocialNetwork/Signup" id="signup">Sign up here</a></p>
                        </div>
                    </form>
                </div>    
                </div>
            </div>
        </div>
    </body>
</html>