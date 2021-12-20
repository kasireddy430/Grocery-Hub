
<!------ Include the above in your HEAD tag ---------->
<style>
	* {
  -webkit-border-radius: 1px !important;
     -moz-border-radius: 1px !important;
          border-radius: 1px !important;
}


#form-buscar >.form-group >.input-group > .form-control {
    height: 40px;
}
#form-buscar >.form-group >.input-group > .input-group-btn > .btn{
        height: 40px; 
        font-size: 16px;
        font-weight: 300; 
         
       
}
#form-buscar >.form-group >.input-group > .input-group-btn > .btn .glyphicon{
 margin-right:12px;   
}    


#form-buscar >.form-group >.input-group > .form-control {
    font-size: 16px;
    font-weight: 300;
   
}

#form-buscar >.form-group >.input-group > .form-control:focus {
  border-color: #000000;
  outline: 0;
  -webkit-box-shadow: inset 0 1px 1px rgba(0,0,0,.075), 0 0 1px rgba(0, 109, 0, 0.8);
          box-shadow: inset 0 1px 1px rgba(0,0,0,.075), 0 0 1px rgba(0, 109, 0, 0.8);
}
td,th {
    padding: 0;
    background-color: aliceblue;
    width: 90px;
    position:relative;

  }

</style>
<script src="javascript.js"></script>
<div class="container">
<div class="col-md-6 col-md-offset-3">     
<div class="row">
<form role="form" action="Searcher" id="form-buscar">
<div class="form-group">
<div class="input-group">
<input type="text" name="searchId" value = "" class="form-control" id="searchId" onkeyup="doCompletion()" placeholder="Search..." required/>
<div id="auto-row">
  <table id="complete-table" class="gridtable"
    style="position: absolute; width: 315px;"></table>
</div>
<span class="input-group-btn">
<button class="btn btn-success" type="submit">
<i class="glyphicon glyphicon-search" aria-hidden="true"></i> Search
</button>
</span>
</div>
</div>
</form>
</div>            
</div>
</div>