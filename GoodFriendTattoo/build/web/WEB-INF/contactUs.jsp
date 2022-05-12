<%-- 
    Document   : contactUs
    Created on : Jun 9, 2021, 9:53:28 AM
    Author     : 834171
--%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <link rel="stylesheet" type="text/css" href="assets/css/style.css">
        <link rel="stylesheet" href="assets/css/bootstrap.min.css">
        <title>Contact us</title>
    </head>
    <body>
        <header class="jumbotron bg-dark jumbotron-fluid">
            <div class="container">
                <div class="display-1">Good Friend Tattoo Logo</div>
            </div>
        </header>

        <nav class="navbar navbar-dark bg-dark navbar-expand-sm sticky-top">
            <div class="container">
                <button class="navbar-toggler" type="button"
                        data-toggle="collapse" data-target="#myTogglerNav"
                        aria-controls="myTogglerNav"
                        aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="myTogglerNav">
                    <div class="navbar-nav">
                        <a class="nav-item nav-link" href="#">Home</a>
                        <a class="nav-item nav-link" href="#">Artist</a>
                        <a class="nav-item nav-link" href="#">Book an Appointment</a>
                        <a class="nav-item nav-link active" href="#">Contact us</a>
                        <a class="nav-item nav-link" href="#">Testimonials</a>
                    </div>
                </div>
            </div>
        </nav>
      
        <div class="container">
             <h1 id="sent-notification"></h1>
             <form action="contactUs" method="POST">
                
                <h1 class="form-group">Contact us</h1>
                <div  class="form-group">
                    <label class="form-control-lable" for="artistname">Select Artist:</label>
                    <select class="form-control" id="artistname" name="artist">
                        <option>Choose</option>
                        <option value="a">a</option>
                        <option value="b">b</option>
                        <option value="c">c</option>
                    </select>
                </div>
                <div class="form-group">
                    <label class="form-control-lable" for="name">Your Name:</label>
                    <input class="form-control" type="text" name="name" id="name" value="${name}">
                </div>
                <div class="form-group">
                    <label class="form-control-lable" for="number">Your Mobile number:</label>
                    <input class="form-control" type="tel" name="mobile" id="subject" value="${number}">
                </div>
                <div class="form-group">    
                    <label class="form-control-lable" for="email">Your Email:</label>
                    <input class="form-control" type="email" name="mail" id="mail" value="${email}">
                </div>
                <div class="form-group">
                    <label class="form-control-lable" for="message">Your Message:</label>
                    <input class="form-control" type="textbox" name="mess" id="body" value="${mess}">
                </div>
                <input type="submit" value="submit">
            </form>
        </div>
    </div>

    <script src="assets/js/jquery.slim.min.js"></script>
    <script src="assets/js/popper.min.js"></script>
    <script src="assets/js/bootstrap.min.js"></script>
    <script src="http://code.jquery.com/jquery-3.3.1.min.js"></script>
</body>
</html>

