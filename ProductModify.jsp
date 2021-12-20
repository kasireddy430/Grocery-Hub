<style>
.content {
  max-width: 80vw;
  margin: auto;
  background: white;
  padding: 10px;
}
input[type=text] {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  box-sizing: border-box;
  border: none;
  background-color: #dde2e1;
  color: rgb(0, 0, 0);
}
</style>
        <%@ include file="header.jsp"%>
        <%@ include file="navbar.jsp"%>
        <div class="content">
            <div class = "content">
                <h3>Add Product</h3>
                <hr>
                <form id="addproduct" action="sqlconnections/addproduct.jsp">

                    <label for="productID">Product ID</label>
                    <input type="text" id="productID" name="productID" value="" placeholder="ID">
                    <label for="productName">Product Name</label>
                    <input type="text" id="productName" name="productName" value="" placeholder="Name of the product">
                    <label for="productDes">Product Description</label>
                    <input type="text" id="productDes" name="productDes" value="" placeholder="Description">
                    <label for="productCPrice">Product Current Price</label>
                    <input type="text" id="productCPrice" name="productCPrice" value="" placeholder="Current Price">
                    <label for="productDis">Product Discount</label>
                    <input type="text" id="productDis" name="productDis" value="" placeholder="Discount">
                    <label for="productAPrice">Product Actual Price</label>
                    <input type="text" id="productAPrice" name="productAPrice" value="" placeholder="Actual Price">
                    <label for="productCat">Product Category</label>
                    <input type="text" id="productCat" name="productCat" value="" placeholder="Product Category">
                    <label for="productImg">Product Image</label>
                    <input type="text" id="productImg" name="productImg" value="" placeholder="Product Image">
                    <label for="productMan">Product Manufacturer</label>
                    <input type="text" id="productMan" name="productMan" value="" placeholder="Procuct Manufacturer">
                    <label for="productInv">Inventory</label>
                    <input type="text" id="productInv" name="productInv" value="" placeholder="Inventory">
                    <label for="productZip">Store Zip</label>
                    <input type="text" id="productZip" name="productZip" value="" placeholder="Product Zipcode">
                    <label for="productRating">Rating</label>
                    <input type="text" id="productRating" name="productRating" value="" placeholder="Product Rating">
                    <br>
                    <br>
                    <button type="submit" class="btn btn-primary">Submit</button>
                  </form>
            </div>
          </div>
          <br><br>
          <div class="content">
            <div class = "content">
                <h3>Delete Product</h3>
                <hr>
                <form id="deleteproduct" action="sqlconnections/deleteproduct.jsp">
                    <label for="productID">Product ID</label>
                    <input type="text" id="productID" name="productID" value="" placeholder="ID">
                    <br>
                    <br>
                    <button type="submit" class="btn btn-primary">Submit</button>
                </form>

            </div>
          </div>         
                <br>
        </form>