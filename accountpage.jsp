<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1" import="java.io.*, java.net.*"%>
<link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<style>
body {
    font-family: 'Roboto', sans-serif;
    font-weight: 400;
    background-color: #f0f3f5;
    margin-top:40px;
}
/*==============================*/
/*====== siderbar user profile =====*/
/*==============================*/
.nav>li>a.userdd {
    padding: 5px 15px
}
.userprofile {
    width: 100%;
	float: left;
	clear: both;
	margin: 40px auto
}
.userprofile .userpic {
	height: 100px;
	width: 100px;
	clear: both;
	margin: 0 auto;
	display: block;
	border-radius: 100%;
	box-shadow: 0px 3px 10px 0 rgba(0, 0, 0, 0.15);
	-moz-box-shadow: 0px 3px 10px 0 rgba(0, 0, 0, 0.15);
	-webkit-box-shadow: 0px 3px 10px 0 rgba(0, 0, 0, 0.15);
	-ms-box-shadow: 0px 3px 10px 0 rgba(0, 0, 0, 0.15);
	position: relative; 
}
.userprofile .userpic .userpicimg {
	height: auto;
	width: 100%;
	border-radius: 100%;
}
.username {
	font-weight: 400;
	font-size: 20px;
	line-height: 20px;
	color: #009e22;
	margin-top: 20px;
	white-space: nowrap;
	overflow: hidden;
	text-overflow: ellipsis;
}
.username+p {
	color: #607d8b;
	font-size: 13px;
	line-height: 15px;
	white-space: nowrap;
	text-overflow: ellipsis;
	overflow: hidden;
}
.settingbtn {
	height: 30px;
	width: 30px;
	border-radius: 30px;
	display: block;
	position: absolute;
	bottom: 0px;
	right: 0px;
	line-height: 30px;
	/* vertical-align: middle; */
	text-align: center;
	padding: 0;
	box-shadow: 0px 2px 5px 0 rgba(0, 0, 0, 0.15);
	-moz-box-shadow: 0px 2px 5px 0 rgba(0, 0, 0, 0.15);
	-webkit-box-shadow: 0px 2px 5px 0 rgba(0, 0, 0, 0.15);
	-ms-box-shadow: 0px 2px 5px 0 rgba(0, 0, 0, 0.15);
}
.userprofile.small {
	width: auto;
	clear: both;
	margin: 0px auto;
}
.userprofile.small .userpic {
	height: 40px;
	width: 40px;
	margin: 0 10px 0 0;
	display: block;
	border-radius: 100%;
	box-shadow: 0px 3px 10px 0 rgba(0, 0, 0, 0.15);
	-moz-box-shadow: 0px 3px 10px 0 rgba(0, 0, 0, 0.15);
	-webkit-box-shadow: 0px 3px 10px 0 rgba(0, 0, 0, 0.15);
	-ms-box-shadow: 0px 3px 10px 0 rgba(0, 0, 0, 0.15);
	position: relative;
	float: left;
}
.userprofile.small .textcontainer {
	float: left;
	max-width: 100px;
	padding: 0
}
.userprofile.small .userpic .userpicimg {
	min-height: 100%;
	width: 100%;
	border-radius: 100%;
}
.userprofile.small .username {
	font-weight: 400;
	font-size: 16px;
	line-height: 21px;
	color: #000000;
	margin: 0px;
	float: left;
	width: 100%;
}
.userprofile.small .username+p {
	color: #607d8b;
	font-size: 13px;
	float: left;
	width: 100%;
	margin: 0;
}
/*==============================*/
/*====== Social Profile css =====*/
/*==============================*/
.countlist h3 {
	margin: 0;
	font-weight: 400;
	line-height: 28px;
}
.countlist {
	text-transform: uppercase
}
.countlist li {
	padding: 15px 30px 15px 0;
	font-size: 14px;
	text-align: left;
}
.countlist li small {
	font-size: 12px;
	margin: 0
}
.followbtn {
	float: right;
	margin: 22px;
}
.userprofile.social {
	background: url('images/userbackground.jpg') no-repeat top center;
	background-size: 100%;
	padding: 50px 0;
	margin: 0
}
.userprofile.social .username {
	color: #ffffff
}
.userprofile.social .username+p {
	color: #ffffff;
	opacity: 0.8
}
.postbtn {
	position: absolute;
	right: 5px;
	top: 5px;
	z-index: 9
}
.status-upload {
	width: 100%;
	float: left;
	margin-bottom: 15px
}
.posttimeline .panel {
	margin-bottom: 15px
}
.commentsblock {
	background: #f8f9fb;
}
.nopaddingbtm {
	margin-bottom: 0
}
/*==============================*/
/*====== Recently connected  heading =====*/
/*==============================*/
.memberblock {
	width: 100%;
	float: left;
	clear: both;
	margin-bottom: 15px
}
.member {
	width: 24%;
	float: left;
	margin: 2px 1% 2px 0;
	background: #ffffff;
	border: 1px solid #d8d0c3;
	padding: 3px;
	position: relative;
	overflow: hidden
}
.memmbername {
	position: absolute;
	bottom: -30px;
	background: rgba(0, 0, 0, 0.8);
	color: #ffffff;
	line-height: 30px;
	padding: 0 5px;
	white-space: nowrap;
	text-overflow: ellipsis;
	overflow: hidden;
	width: 100%;
	font-size: 11px;
	transition: 0.5s ease all;
}
.member:hover .memmbername {
	bottom: 0
}
.member img {
	width: 100%;
	transition: 0.5s ease all;
}
.member:hover img {
	opacity: 0.8;
	transform: scale(1.2)
}

.panel-default>.panel-heading {
    color: #607D8B;
    background-color: #ffffff;
    font-weight: 400;
    font-size: 15px;
    border-radius: 0;
    border-color: #e1eaef;
}



.btn-circle {
    width: 30px;
    height: 30px;
    padding: 6px 0;
    border-radius: 15px;
    text-align: center;
    font-size: 12px;
    line-height: 1.428571429;
}

.page-header.small {
    position: relative;
    line-height: 22px;
    font-weight: 400;
    font-size: 20px;
}

.favorite i {
    color: #eb3147;
}

.btn i {
    font-size: 17px;
}

.panel {
    box-shadow: 0px 2px 10px 0 rgba(0, 0, 0, 0.05);
    -moz-box-shadow: 0px 2px 10px 0 rgba(0, 0, 0, 0.05);
    -webkit-box-shadow: 0px 2px 10px 0 rgba(0, 0, 0, 0.05);
    -ms-box-shadow: 0px 2px 10px 0 rgba(0, 0, 0, 0.05);
    transition: all ease 0.5s;
    -moz-transition: all ease 0.5s;
    -webkit-transition: all ease 0.5s;
    -ms-transition: all ease 0.5s;
    margin-bottom: 35px;
    border-radius: 0px;
    position: relative;
    border: 0;
    display: inline-block;
    width: 100%;
}

.panel-footer {
    padding: 10px 15px;
    background-color: #ffffff;
    border-top: 1px solid #eef2f4;
    border-bottom-right-radius: 0;
    border-bottom-left-radius: 0;
    color: #607d8b;
}

.panel-blue {
    color: #ffffff;
    background-color: #03A9F4;
}

.panel-red.userlist .username, .panel-green.userlist .username, .panel-yellow.userlist .username, .panel-blue.userlist .username {
    color: #ffffff;
}

.panel-red.userlist p, .panel-green.userlist p, .panel-yellow.userlist p, .panel-blue.userlist p {
    color: rgba(255, 255, 255, 0.8);
}

.panel-red.userlist p a, .panel-green.userlist p a, .panel-yellow.userlist p a, .panel-blue.userlist p a {
    color: rgba(255, 255, 255, 0.8);
}

.progress-bar-success, .status.active, .panel-green, .panel-green > .panel-heading, .btn-success, .fc-event, .badge.green, .event_green {
    color: white;
    background-color: #8BC34A;
}

.progress-bar-warning, .panel-yellow, .status.pending, .panel-yellow > .panel-heading, .btn-warning, .fc-unthemed .fc-today, .badge.yellow, .event_yellow {
    color: white;
    background-color: #FFC107;
}

.progress-bar-danger, .panel-red, .status.inactive, .panel-red > .panel-heading, .btn-danger, .badge.red, .event_red {
    color: white;
    background-color: #F44336;
}

.media-object {
    max-width: 50px;
    border-radius: 50px;
    box-shadow: 0px 3px 10px 0 rgba(0, 0, 0, 0.15);
    -moz-box-shadow: 0px 3px 10px 0 rgba(0, 0, 0, 0.15);
    -webkit-box-shadow: 0px 3px 10px 0 rgba(0, 0, 0, 0.15);
    -ms-box-shadow: 0px 3px 10px 0 rgba(0, 0, 0, 0.15);
}

.media:first-child {
    margin-top: 15px;
}

.media-object {
    display: block;
}

.dotbtn {
    height: 40px;
    width: 40px;
    background: none;
    border: 0;
    line-height: 40px;
    vertical-align: middle;
    padding: 0;
    margin-right: -15px;
}

.dots {
    height: 4px;
    width: 4px;
    position: relative;
    display: block;
    background: rgba(0,0,0,0.5);
    border-radius: 2px;
    margin: 0 auto;
}

.dots:after, .dots:before {
    content: " ";
    height: 4px;
    width: 4px;
    position: absolute;
    display: inline-block;
    background: rgba(0,0,0,0.5);
    border-radius: 2px;
    top: -7px;
    left: 0;
}

.dots:after {
    content: " ";
    top: auto;
    bottom: -7px;
    left: 0;
}

.photolist img {
    width: 100%;
}

.photolist {
    background: #e1eaef;
    padding-top: 15px;
    padding-bottom: 15px;
}

.profilegallery .grid-item a {
    height: 100%;
    display: block;
}

.grid a {
    width: 100%;
    display: block;
    float: left;
}

.media-body {
    color: #607D8B;
    overflow: visible;
}
</style>
<%@ include file="header.jsp"%>
<%@ include file="navbar.jsp"%>
<% System.out.println("accountpage"+session.getAttribute("username")); %>
<div class="container">
    <div class="row">
          <div class="col-md-12 text-center ">
            <div class="panel panel-default">
              <div class="userprofile social ">
                <div class="userpic"> <img src="https://bootdey.com/img/Content/avatar/avatar6.png" alt="" class="userpicimg"> </div>
                <h3 class="username">Full Name : <% out.print(session.getAttribute("username")); %></h3>
                <p style="color:white"><% out.print(session.getAttribute("usertype")); %></p>
                <p style="color:white">Email-Id : <% out.print(session.getAttribute("email")); %></p>
                <p style="color:white">Zip-Code : <% out.print(session.getAttribute("zipCode")); %></p>
                <div class="socials tex-center"> <a href="" class="btn btn-circle btn-primary ">
                <i class="fa fa-facebook"></i></a> <a href="" class="btn btn-circle btn-danger ">
                <i class="fa fa-google-plus"></i></a> <a href="" class="btn btn-circle btn-info ">
                <i class="fa fa-twitter"></i></a> <a href="" class="btn btn-circle btn-warning "><i class="fa fa-envelope"></i></a>
                </div>
              </div>
              <div class="col-md-12 border-top border-bottom">
                <ul class="nav nav-pills pull-left countlist" role="tablist">
                </ul>
              </div>
              <div class="clearfix"></div>
            </div>
          </div>
          <!-- /.col-md-12 -->
          <!-- <div class="col-md-12 col-sm-12 pull-left posttimeline">
            <div class="panel panel-default">
              <div class="panel-body">
                <div class="container">
                  <h2>ALL Orders</h2>
                  <p>The .table-bordered class adds borders to a table:</p>            
                  <table class="table table-bordered">
                    <thead>
                      <tr>
                        <th>Firstname</th>
                        <th>Lastname</th>
                        <th>Email</th>
                        <th>hdfhad</th>
                        <th>Firstname</th>
                        <th>Lastname</th>
                        <th>Email</th>
                        <th>hdfhad</th>
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
            </div>
          </div> -->
        </div>
    </div>
  </div>

