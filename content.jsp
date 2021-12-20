  
<!-- 
<style>
  /* Set height of the grid so .sidenav can be 100% (adjust as needed) */
  .row.content {height: 450px}
  
  /* Set gray background color and 100% height */
  .sidenav {
    background-color: #f1f1f1;
    height: 100%;
  }
  
  
  /* On small screens, set height to 'auto' for sidenav and grid */
  @media screen and (max-width: 767px) {
    .sidenav {
      height: auto;
      padding: 15px;
    }
    .row.content {height:auto;} 
  }
</style>
<div class="container-fluid text-center">    
  <div class="row content">
    <div class="col-sm-2 sidenav">
      <p><a href="#">Link</a></p>
      <p><a href="#">Link</a></p>
      <p><a href="#">Link</a></p>
    </div>
    <div class="col-sm-10 text-left"> 
      <div class="container">    
        <div class="row">
          <div class="col-sm-4">
            <div class="panel panel-primary">
              <div class="panel-heading">Food</div>
              <div class="panel-body"><a href="${pageContext.request.contextPath}/Foodslist"><img src="images/food.jpg" class="img-responsive" style="width:100%" alt="Food Image"></div>
              <div class="panel-footer">Veg-Non Veg</div>
            </div>
          </div>
          <div class="col-sm-4"> 
            <div class="panel panel-primary">
              <div class="panel-heading">Beverages</div>
              <div class="panel-body"><a href="${pageContext.request.contextPath}/beverages.jsp"><img src="images/beverages.jpg" class="img-responsive" style="width:100%" alt="Beverages Image"></a></div>
              <div class="panel-footer">Soft Drinks, Alcohol</div>
            </div>
          </div>
          <div class="col-sm-4"> 
            <div class="panel panel-primary">
              <div class="panel-heading">Household</div>
              <div class="panel-body"><a href="${pageContext.request.contextPath}/household.jsp"><img src="images/household.jpg" class="img-responsive" style="width:100%" alt="Household Supplies Image"></a></div>
              <div class="panel-footer">Dish Washing Liquids, Clothes Surf etc</div>
            </div>
          </div>
        </div>
      </div><br>
      
      <div class="container">    
        <div class="row">
          <div class="col-sm-4">
            <div class="panel panel-primary">
              <div class="panel-heading">Personal Care, Health & Beauty</div>
              <div class="panel-body"><a href="${pageContext.request.contextPath}/pchb.jsp"><img src="images/personalcare.jpg" class="img-responsive" style="width:100%" alt="Personal Care and Beauty Image"></a></div>
              <div class="panel-footer">Soaps, BodyWash etc </div>
            </div>
          </div>
          <div class="col-sm-4"> 
            <div class="panel panel-primary">
              <div class="panel-heading">Body Care & Beauty</div>
              <div class="panel-body"><a href="${pageContext.request.contextPath}/bcb.jsp"><img src="images/bodycare.jpg" class="img-responsive" style="width:100%" alt="Body Care and Beauty Image"></a></div>
              <div class="panel-footer">Face Wash Etc</div>
            </div>
          </div>
          <div class="col-sm-4"> 
            <div class="panel panel-primary">
              <div class="panel-heading">Deals</div>
              <div class="panel-body"><a href="${pageContext.request.contextPath}/deals.jsp"><img src="images/deals.jpg" class="img-responsive" style="width:100%" alt="Deal Image"></a></div>
              <div class="panel-footer">Deals of the Day</div>
            </div>
          </div>
        </div>
      </div><br><br>
    </div>
  </div>
</div> -->

<!DOCTYPE html>

<html>
  <head>
    <title>Home Page</title>
    <meta charset="utf-8">

    <style>
      /* #maincontent {
        background-color: white;
      } */
      #leftnavbar {
        border-radius: 10%;
      }
      div {
        border-radius: 20%;
      }
      img {
        border-radius: 20%;
      }
      /* .col-lg-6 {
        max-width: 80vw;
        margin: auto;
        background: white;
        padding: 10px;
      }
       */
    </style>
  </head>

  <body>
    <div class = "col-lg-12">
      <br><br><br><br><br><br><br>
    </div>
    <div class="container-fluid" >

      <div class="col-lg-3" >
        <div class="col-sm">
          <div class="panel panel-primary" id="leftnavbar">
            <div class="panel-heading" style="width: 100%;">Food</div>
            <div class="panel-body" style="height: 50%;"><a href="${pageContext.request.contextPath}/Foodslist
              "><img src="./images/foo.jpg" class="rounded" style="height:50%;width:100%;" alt="Food Image"></a></div>
            <div class="panel-footer" style="width: 100%;">Veg-Non Veg</div>
          </div>
        </div>
        <div class="col-sm"> 
          <div class="panel panel-primary">
            <div class="panel-heading">Beverages</div>
            <div class="panel-body"><a href="${pageContext.request.contextPath}/Beverageslist"><img src="./images/beverages.jpg" class="img-responsive" style="width:100%" alt="Beverages Image"></a></div>
            <div class="panel-footer">Soft Drinks, Alcohol</div>
          </div>
        </div>
        <div class="col-sm"> 
          <div class="panel panel-primary">
            <div class="panel-heading">Household</div>
            <div class="panel-body"><a href="${pageContext.request.contextPath}/Householdlist"><img src="./images/household.jpg" class="img-responsive" style="width:100%" alt="Household Supplies Image"></a></div>
            <div class="panel-footer">Dish Washing Liquids, Clothes Surf etc</div>
          </div>
        </div>

      </div>


      <div class="col-lg-6" id="maincontent">
        <div class="col-lg-6" id="extracontent">        
          <jsp:include page="DealMatchesUtilities" />
          
        </div>
      </div>

 

        
      <div class="col-lg-3" >
        <div class="col-sm">
          <div class="panel panel-primary">
            <div class="panel-heading">Personal Care, Health & Beauty</div>
            <div class="panel-body"><a href="${pageContext.request.contextPath}/Pchblist"><img src="./images/personalcare.jpg" class="img-responsive" style="width:100%" alt="Personal Care and Beauty Image"></a></div>
            <div class="panel-footer">Soaps, BodyWash etc </div>
          </div>
        </div>
        <div class="col-sm"> 
          <div class="panel panel-primary">
            <div class="panel-heading">Body Care & Beauty</div>
            <div class="panel-body"><a href="${pageContext.request.contextPath}/Bcblist"><img src="./images/bodycare.jpg" class="img-responsive" style="width:100%" alt="Body Care and Beauty Image"></a></div>
            <div class="panel-footer">Face Wash Etc</div>
          </div>
        </div>
        <div class="col-sm"> 
          <div class="panel panel-primary">
            <div class="panel-heading">Deals</div>
            <div class="panel-body" id="leftnavbar"><a href="${pageContext.request.contextPath}/Dealslist"><img src="./images/deals.jpg" class="img-responsive" style="width:100%" alt="Deal Image"></a></div>
            <div class="panel-footer">Deals of the Day</div>
          </div>
        </div>
      </div>
        


 
        
    </div>
    
  </body> 
  
</html>