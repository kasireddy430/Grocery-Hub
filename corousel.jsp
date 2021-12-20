<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script type = "text/JavaScript">
  $(document).ready(function() {
    $('#Carousel').carousel({
        interval: 5000
    })
});
</script>
<!------ Include the above in your HEAD tag ---------->
<style>

.carousel {
    margin-bottom: 0;
    padding: 0 40px 30px 40px;
}
/* The controlsy */
.carousel-control {
	left: -12px;
    height: 40px;
	width: 40px;
    background: none repeat scroll 0 0 #222222;
    border: 4px solid #FFFFFF;
    border-radius: 23px 23px 23px 23px;
    margin-top: 90px;
}
.carousel-control.right {
	right: -12px;
}
/* The indicators */
.carousel-indicators {
	right: 50%;
	top: auto;
	bottom: -10px;
	margin-right: -19px;
}
/* The colour of the indicators */
.carousel-indicators li {
	background: #cecece;
}
.carousel-indicators .active {
background: #428bca;
}
.container {
  padding: 2px 16px;
  background-color: #FFFFFF;
  width: 80;
}
</style>
<body style='background-color: white;'>
    
<div class="content">
    <div class="container">
    <div class="row">
        <div class="col-md-12">
             <h3>Restaurants nearby:</h3>
                <div id="Carousel" class="carousel slide">
                 
                <ol class="carousel-indicators">
                    <li data-target="#Carousel" data-slide-to="0" class="active"></li>
                    <li data-target="#Carousel" data-slide-to="1"></li>
                    <li data-target="#Carousel" data-slide-to="2"></li>
                    <li data-target="#Carousel" data-slide-to="3"></li>
                    <li data-target="#Carousel" data-slide-to="4"></li>
                    <li data-target="#Carousel" data-slide-to="5"></li>
                    <li data-target="#Carousel" data-slide-to="6"></li>
                    <li data-target="#Carousel" data-slide-to="7"></li>
                    <li data-target="#Carousel" data-slide-to="8"></li>
                </ol>

    <div class="carousel-inner">
        <div class="item active">
                <div class="row">

                    <c:forEach items="${Restaurantslist}" var="restaurantslist" begin="0" end="3">
                    
                    <div class="col-md-3"><a href="${restaurantslist.url}" class="thumbnail"><img src="${restaurantslist.image}" alt="Image" style="width:250px;height:250px;"></a>  <div class="container"><h4><b>${restaurantslist.name}</b></h4> <p>${restaurantslist.rating}</p> </div></div>
                                    
                                
                                        
                                </c:forEach>
                </div>

                    </div>
                    <div class="item">
                    <div class="row">

                    <c:forEach items="${Restaurantslist}" var="restaurantslist" begin="4" end="7">
                    
                    <div class="col-md-3"><a href="${restaurantslist.url}" class="thumbnail"><img src="${restaurantslist.image}" alt="Image" style="width:250px;height:250px;"></a>  <div class="container"><h4><b>${restaurantslist.name}</b></h4> <p>${restaurantslist.rating}</p> </div></div>
                                    
                                
                                        
                    </c:forEach>
                    </div>

                    </div>

                    <div class="item">
                    <div class="row">

                    <c:forEach items="${Restaurantslist}" var="restaurantslist" begin="8" end="11">
                    
                    <div class="col-md-3"><a href="${restaurantslist.url}" class="thumbnail"><img src="${restaurantslist.image}" alt="Image" style="width:250px;height:250px;"></a>  <div class="container"><h4><b>${restaurantslist.name}</b></h4> <p>${restaurantslist.rating}</p> </div></div>
                                    
                                
                                        
                    </c:forEach>
                    </div>

                    </div>

                    <div class="item">
                    <div class="row">

                    <c:forEach items="${Restaurantslist}" var="restaurantslist" begin="12" end="15">
                    
                    <div class="col-md-3"><a href="${restaurantslist.url}" class="thumbnail"><img src="${restaurantslist.image}" alt="Image" style="width:250px;height:250px;"></a>  <div class="container"><h4><b>${restaurantslist.name}</b></h4> <p>${restaurantslist.rating}</p> </div></div>
                                    
                                
                                        
                    </c:forEach>
                    </div>

                    </div>

                    <div class="item">
                    <div class="row">

                    <c:forEach items="${Restaurantslist}" var="restaurantslist" begin="16" end="19">
                    
                    <div class="col-md-3"><a href="${restaurantslist.url}" class="thumbnail"><img src="${restaurantslist.image}" alt="Image" style="width:250px;height:250px;"></a>  <div class="container"><h4><b>${restaurantslist.name}</b></h4> <p>${restaurantslist.rating}</p> </div></div>
                                  
                                
                                        
                    </c:forEach>
                    </div>

                    </div>

                    <div class="item">
                    <div class="row">

                    <c:forEach items="${Restaurantslist}" var="restaurantslist" begin="20" end="23">
                    
                    <div class="col-md-3"><a href="${restaurantslist.url}" class="thumbnail"><img src="${restaurantslist.image}" alt="Image" style="width:250px;height:250px;"></a>  <div class="container"><h4><b>${restaurantslist.name}</b></h4> <p>${restaurantslist.rating}</p> </div></div>
                                    
                                
                                        
                    </c:forEach>
                    </div>

                    </div>

                    <div class="item">
                    <div class="row">

                    <c:forEach items="${Restaurantslist}" var="restaurantslist" begin="24" end="27">
                    
                    <div class="col-md-3"><a href="${restaurantslist.url}" class="thumbnail"><img src="${restaurantslist.image}" alt="Image" style="width:250px;height:250px;"></a>  <div class="container"><h4><b>${restaurantslist.name}</b></h4> <p>${restaurantslist.rating}</p> </div></div>
                                    
                                
                                        
                    </c:forEach>
                    </div>

                    </div>

                    <div class="item">
                    <div class="row">

                    <c:forEach items="${Restaurantslist}" var="restaurantslist" begin="28" end="31">
                    
                    <div class="col-md-3"><a href="#" class="thumbnail"><img src="${restaurantslist.image}" alt="Image" style="width:250px;height:250px;"></a>  <div class="container"><h4><b>${restaurantslist.name}</b></h4> <p>${restaurantslist.rating}</p> </div></div>
                                    
                                
                                        
                    </c:forEach>
                    </div>

                    </div>

                    <div class="item">
                    <div class="row">

                    <c:forEach items="${Restaurantslist}" var="restaurantslist" begin="32" end="34">
                    
                    <div class="col-md-3"><a href="#" class="thumbnail"><img src="${restaurantslist.image}" alt="Image" style="width:250px;height:250px;"></a>  <div class="container"><h4><b>${restaurantslist.name}</b></h4> <p>${restaurantslist.rating}</p> </div></div>
                                    
                                
                                        
                    </c:forEach>
                    </div>

                    </div>
                    
     </div><!--.carousel-inner-->
                  <a data-slide="prev" href="#Carousel" class="left carousel-control"><</a>
                  <a data-slide="next" href="#Carousel" class="right carousel-control">></a>
                </div>
                            </div>
                            </div>
                            </div>
                            </div>
                            </div>
                        </div>                    
        </body>

</html>