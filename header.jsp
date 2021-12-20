<!DOCTYPE html>
<html lang="en">
<head>
  <title>Grocery Hub</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="script.js"></script>
  <style>
    /* Remove the navbar's default rounded borders and increase the bottom margin */ 
    .navbar {
      border-radius: 0;
    }
    
    /* Remove the jumbotron's default bottom margin */ 
     .jumbotron {
        background: url('images/header.jpg') no-repeat center center fixed;
        -moz-background-size: cover;
        -webkit-background-size: cover;
        -o-background-size: cover;
        background-size: cover;
        margin-bottom: 0;
        margin: none;
        background-color: #1ee671;
    }
   
    /* Add a gray background color and some padding to the footer */
    footer {
      background-color: #f2f2f2;
      padding: 25px;
    }

    body { 
    background: url('images/background.jpg') no-repeat center center fixed;
    -moz-background-size: cover;
    -webkit-background-size: cover;
    -o-background-size: cover;
    background-size: cover;
    }

  </style>
</head>
<body>

<div class="jumbotron" style="border: 200px;">
  <div class="text-center">
    <h1>Grocery Hub</h1>
    <h3 id = "getdata">
   <script>
      function func(){
        writeColor(sessionStorage.storeaddress);
      }

      function func1 (){
        init();
      }
      function start(){
          func();
          func1();
      }

      window.onload = start();

      function writeColor(color) {
        console.log(color);
        var value = '<%= session.getAttribute("zipCode") %>';

        var x = '';

        if(color == undefined){
          console.log("hello");
            if(value != "null"){
              console.log("hellonull"+value);
              document.getElementById("getdata").innerHTML = value;
            }
            else{
               document.getElementById("getdata").innerHTML =x ;
            }
        }
        else{
            if(value != "null"){
            document.getElementById("getdata").innerHTML = color;
          }
          else{
             document.getElementById("getdata").innerHTML =x ;
             sessionStorage.removeItem('storeaddress');
          }

        }
      }
      </script></h3>
  
    <p>WE CARE FOR YOU</p>
    
  </div>
</div>