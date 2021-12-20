<html>
    <head>
        <title>Update Product</title>
        <meta charset="utf-8">
    </head>
    <style>
        #updateproductform {
            background-color: white;
            padding: 20px;
            padding-left: 50px;
        }
    </style>
    <body>
        <%@ include file="../parts/header.jsp"%>
        <%@ include file="../parts/navbar.jsp"%>
        <form id="updateproductform">
            <div class="form-group row">
                <label for="productID" class="col-sm-2 col-form-label">Product ID</label>
                <div class="col-sm-4">
                    <input type="text" class="form-control" id="productID" placeholder="Id of the product">
                </div>
            </div>
            <div class="form-group row">
                <div class="col-sm-10">
                  <button type="submit" class="btn btn-primary">Update Product</button>
                </div>
              </div>
        </form>
    </body>
</html>