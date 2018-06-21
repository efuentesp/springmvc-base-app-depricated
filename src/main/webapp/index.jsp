<!DOCTYPE html>
<html lang="en">
<head>
   <meta charset="UTF-8">
   <title>Softtek Application Development Framework</title>

   <!-- Latest compiled and minified CSS -->
   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
         integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">

   <!-- Optional theme -->
   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css"
         integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">

</head>
<body>
<div class="container">
   <h1>Softtek Application Development Framework UP</h1>

   <div class="alert alert-danger" id="notLoggedIn">Not logged in!</div>

   <div class="row">
      <div class="col-md-6">
         <div class="panel panel-default" id="login">
            <div class="panel-heading">
               <h3 class="panel-title">Login</h3>
            </div>
            <div class="panel-body">
               <form id="loginForm">
                  <div class="form-group">
                     <input type="text" class="form-control" id="exampleInputEmail1" placeholder="username"
                            required name="username">
                  </div>
                  <div class="form-group">
                     <input type="password" class="form-control" id="exampleInputPassword1"
                            placeholder="password" required name="password">
                  </div>
                  <div class="well">
                     Try one of the following logins
                     <ul>
                        <li>admin & admin</li>
                        <li>user & password</li>
                        <li>disabled & password</li>
                     </ul>
                  </div>
                  <button type="submit" class="btn btn-default">login</button>
               </form>
            </div>
         </div>

         <div id="userInfo">
            <div class="panel panel-default">
               <div class="panel-heading">
                  <h3 class="panel-title">Authenticated user</h3>
               </div>
               <div class="panel-body">
                  <div id="userInfoBody"></div>
                  <button type="button" class="btn btn-default" id="logoutButton">logout</button>
               </div>
            </div>
         </div>
      </div>

      <div class="col-md-6">
         <div class="btn-group" role="group" aria-label="..." style="margin-bottom: 16px;">
            <button type="button" class="btn btn-default" id="exampleServiceBtn">call example service</button>
            <button type="button" class="btn btn-default" id="adminServiceBtn">call admin protected service</button>
         </div>
         <div class="panel panel-default">
            <div class="panel-heading">
               <h3 class="panel-title">Response:</h3>
            </div>
            <div class="panel-body">
               <pre id="response"></pre>
            </div>
         </div>
      </div>
   </div>

   <div class="row">
      <div id="loggedIn" class="col-md-6">
         <div class="panel panel-default">
            <div class="panel-heading">
               <h3 class="panel-title">Token information</h3>
            </div>
            <div class="panel-body" id="loggedInBody"></div>
         </div>
      </div>
   </div>
</div>

<div class="modal fade" tabindex="-1" role="dialog" id="loginErrorModal">
   <div class="modal-dialog">
      <div class="modal-content">
         <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
            <h4 class="modal-title">Login unsuccessful</h4>
         </div>
         <div class="modal-body"></div>
         <div class="modal-footer">
            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
         </div>
      </div><!-- /.modal-content -->
   </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

<script src="https://code.jquery.com/jquery-2.2.2.js" integrity="sha256-4/zUCqiq0kqxhZIyp4G0Gk+AOtCJsY1TA00k5ClsZYE="
        crossorigin="anonymous"></script>
<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"
        integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS"
        crossorigin="anonymous"></script>
<script src="<%=request.getContextPath()%>/resources/js/libs/jwt-decode.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/client.js"></script>
</body>
</html>