
<%@ page import ="java.sql.*" %>
<%@ page import ="java.io.*" %>
<%@ page import ="java.io.IOException" %>
<%@ page import ="java.util.ArrayList" %>

    <%

    Class.forName("com.mysql.jdbc.Driver");
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","root");
    Statement st = con.createStatement();
    ResultSet rs;
    rs = st.executeQuery("select * from orders ");
    System.out.println(rs);
    %>

<style>
    .content {
      max-width: 100vw;
      margin: auto;
      background: white;
      padding: 10px;
    }
    input[type=text] {
      width: 10%;
      padding: 12px 15px;
      box-sizing: border-box;
      border: none;
      background-color: #dde2e1;
      color: rgb(0, 0, 0);
    }
</style>

<div class="content">
    <div class="container">
        <h2>ALL Orders</h2>
        <p>The .table-bordered class adds borders to a table:</p>            
        <table class="table table-bordered">
          <thead>
            <tr>
              <th>Firstname</th>
              <th>Lastname</th>
              <th>Email</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td>John</td>
              <td>Doe</td>
              <td>john@example.com</td>
            </tr>
            <tr>
              <td>Mary</td>
              <td>Moe</td>
              <td>mary@example.com</td>
            </tr>
            <tr>
              <td>July</td>
              <td>Dooley</td>
              <td>july@example.com</td>
            </tr>
          </tbody>
        </table>
      </div>
      
</div>


