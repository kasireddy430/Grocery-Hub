<html>
    <head>
        <title>Stores</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

        <%@ include file="../header.jsp"%>
        <%@ include file="../navbar.jsp"%>
    </head>
    <style>
 
        /* Create four equal columns that floats next to each other */
        .column {
        float: left;
        width: 100%;
        padding: 10px;
        height: auto; /* Should be removed. Only for demonstration */
        }
        .form-control{
            padding-top: 10px;
            width:600px;
        }
        #map {
        height: 100vh;
        }
        html, body {
        max-width: 100%;
        overflow-x: hidden;
        }
        
    </style>
    <body>

        <div class="row">
            <div class="col-sm-1">
            </div>
            <div class="col-sm-2" >
                <div class="row">
                    <div class="column" style="background-color:white;">
                        <form>
                            <label for="fname">Grocery Hub</label><br>
                            <address id = "address0">
                                </address>
                            <button id = "store" type="button" class="btn btn-success" value = '0' onclick="change(0)">Select</button>
                        </form>
                    </div>
                </div>
                <br>
                <div class="row">
                    <div class="column" style="background-color:white;">
                        <form>
                            <label for="fname">Grocery Hub</label><br>
                            <address id = "address1">
                            </address>
                            <input type="hidden" id="fname" name="fname">
                            <button id = "store" type="button" class="btn btn-success" value = '1' onclick="change(1)">Select</button>
                        </form>
                    </div>
                </div>
                <br>
                <div class="row">
                    <div class="column" style="background-color:white;">
                        <form>
                            <label for="fname">Grocery Hub</label><br>
                            <address id = "address2">
                            </address>
                            <button id = "store" type="button" class="btn btn-success" value = '2' onclick="change(2)">Select</button>
                        </form>
                    </div>
                </div>
                <br>
                <div class="row">
                    <div class="column" style="background-color:white;">
                        <form action="login.jsp">
                            <label for="fname">Grocery Hub</label><br>
                            <address id = "address3">
                            </address>
                            <input type="hidden" id="fname" name="fname">
                            <button id = "store" name="store" type="button" class="btn btn-success" value = '3' onclick="change(3)">Select</button>
                        </form>
                    </div>
                </div>
                <br>
                <div class="row">
                    <div class="column" style="background-color:white;">
                        <form>
                            <label for="fname">Grocery Hub</label><br>
                            <address id = "address4">
                            </address>
                            <input type="hidden" id="fname" name="fname">
                            <button id = "store" type="button" class="btn btn-success" value = '4' onclick="change(4)">Select</button>
                        </form>
                    </div>
                </div>
                <br>
                <div class="row">
                    <div class="column" style="background-color:white;">
                        <form>
                            <label for="fname">Grocery Hub</label><br>
                            <address id = "address5">
                            </address>
                            <input type="hidden" id="fname" name="fname">
                            <button id = "store" type="button" class="btn btn-success" value = '5' onclick="change(5)">Select</button>
                        </form>
                    </div>
                </div>
                <br>
                <div class="row">
                    <div class="column" style="background-color:white;">
                        <form>
                            <label for="fname">Grocery Hub</label><br>
                            <address id = "address6">
                            </address>
                            <input type="hidden" id="fname" name="fname">
                            <button id = "store" type="button" class="btn btn-success" value = '6' onclick="change(6)">Select</button>
                        </form>
                    </div>
                </div>
            </div>


            <div class="col-sm-8">
                <div class = "row mb-2">
                    <div class = "col-sm-12">
                        <input class = "form-control" id = "ciudad" type="text" placeholder = "search ... "/>
                    </div>
                </div>
                <div id="map"></div>
                <input type="hidden" id="distance" size="1" value="1">
                <input type="hidden" id="lat" value="">
                <input type="hidden" id="lng" value="">
            </div>   
            <div class="col-sm-1">
            </div>
          </div>
        </div>

        <script src="script.js"></script>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js" ></script>
        <script src="https://maps.googleapis.com/maps/api/js?key=add_your_key_here&callback=initMap&libraries=places,geometry" async defer></script>        
    </body>
    <br><br>
</html>
