<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


        <%@ include file="header.jsp"%>
        <%@ include file="navbar.jsp"%>
        <%@ include file="searchbar.jsp" %>

           
   <%
		System.out.println(request.getAttribute("data"));
		System.out.println(request.getAttribute("product_name"));
		System.out.println(request.getAttribute("product_id"));
		System.out.println(request.getAttribute("product_description"));
		System.out.println(request.getAttribute("product_currentprice"));
		System.out.println(request.getAttribute("product_discount"));
		System.out.println(request.getAttribute("product_actualprice"));
		System.out.println(request.getAttribute("product_category"));
		System.out.println(request.getAttribute("product_rating"));
		System.out.println(request.getAttribute("product_image"));
		System.out.println(request.getAttribute("product_manufacturer"));
		System.out.println(request.getAttribute("inventory"));
		System.out.println(request.getAttribute("store_zipcode"));
		System.out.println(request.getAttribute("rating"));
   %>

   <div class="container-fluid">
            <div class="row">
              <div class="col-sm-14">
                <div class="panel panel-primary">
                  
                  <div class="col-md-3">
                      <form id="myform" action=product.jsp method="POST">
                   <div>   	
                  				<input type="hidden" name = "product_id" value='<%=request.getAttribute("product_id")%>'>
                                <input type="hidden" name = "product_name" value='<%=request.getAttribute("product_name")%>'>
                                <input type="hidden" name = "product_description" value='<%=request.getAttribute("product_description")%>'>
                                <input type="hidden" name = "product_currentprice" value='<%=request.getAttribute("product_currentprice")%>'>
                                <input type="hidden" name = "product_discount" value='<%=request.getAttribute("product_discount")%>'>
                                <input type="hidden" name = "product_actualprice" value='<%=request.getAttribute("product_actualprice")%>'>
                                <input type="hidden" name = "product_category" value='<%=request.getAttribute("product_category")%>'>
                                <input type="hidden" name = "product_image" value='<%=request.getAttribute("product_image")%>'>
                                <input type="hidden" name = "product_manufacturer" value='<%=request.getAttribute("product_manufacturer")%>'>
                                <input type="hidden" name = "inventory" value='<%=request.getAttribute("inventory")%>'>
                                <input type="hidden" name = "store_zipcode" value='<%=request.getAttribute("store_zipcode")%>'>
                                <input type="hidden" name = "rating" value='<%=request.getAttribute("rating")%>'>

                </div>
                    

                    <a href="#" class="thumbnail">
                        <div class="panel-body"><img src='<%=request.getAttribute("product_image")%>' alt="Image" style="width:250px;height:250px;"></div></a>  
                        <div>
                           <div class="panel-footer"><%=request.getAttribute("product_name")%></div>
                           <div class="panel-footer" style="overflow: hidden;">
                                <p style="float: left;">current Price :<%=request.getAttribute("product_currentprice")%></p>
                                <p style="float: center;text-decoration: line-through;">($<%=request.getAttribute("product_actualprice")%>)</p>
                          </div>
                          
                          <div class="panel-footer">$<%=request.getAttribute("product_discount")%> Off</div>
                          
                          <div><button  type="submit" class="btn btn-lg btn-brand btn-full-width"> <a><i>Item Details</i></a></button></div>
                                            
                        </div>
                        <div>  &nbsp;  </div>
                        <div>   &nbsp;</div>
                    </form>
                    </div>

              </div>
              
              
            </div>
          </div>
        </div><br>

        

            <%@ include file="footer.jsp"%>