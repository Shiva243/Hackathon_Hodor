<!DOCTYPE html>
<html>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script type="text/javascript" src="${pageContext.request.contextPath}/dwr/engine.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/dwr/util.js"></script>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://www.w3schools.com/lib/w3-theme-black.css">

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">


<script type="text/javascript">
        //Call this on page load so that we tell the server side that we are expecting data
        dwr.engine.setActiveReverseAjax(true);
        //Function that will be called by the server
        function panicAlertSounded(patientName) {

            //var existing = dwr.util.getValue("messages", { escapeHtml:false });
            //var newValue = existing + "Call doctor: for patient: " + patientName + "<br/>";
            dwr.util.setValue(patientName.substring(0,patientName.indexOf("_")), patientName.substring(patientName.indexOf("_")+1), { escapeHtml:false });
            //console.log("!!!! Panic alert sounded for: " + patientName + ". Call doctor: ");
        }
    </script>
<style>
.footer {
   position: fixed;
   left: 0;
   bottom: 0;
   width: 100%;
   background-color: black;
   color: white;
   text-align: center;
}
</style>
<body id="myPage">

<div class="w3-display-container w3-animate-opacity">
  <img src="http://oi68.tinypic.com/2s8lqwn.jpg" alt="banner" style="width:100%;min-height:100px;max-height:300px;">
  <div class="w3-container w3-display-bottomleft w3-margin-bottom">  
  </div>
</div>


<!-- Pricing Row -->
<div class="w3-row-padding w3-center w3-padding-64" id="pricing" style="max-height:100px">
    <div class="w3-third w3-margin-bottom" style="width: 342px;margin-left:50px;">
      <ul class="w3-ul w3-border w3-hover-shadow">
        <li><div class="header">    
  <img src="https://cdn.macrumors.com/article-new/2017/09/iphonexdesign.jpg" alt="" style="width: 307px; height: 318px;"/>

</div></li>
        <li class="w3-theme" style="width: 326px; height: 23px;">
          <p class="w3-xlarge" style="margin: -15px -4px 0px -5px;">Iphone X</p>
        </li>
        
      </ul>
      </li>
       <table align="center">
         <tr>
         <td>5.8-inch diagonal Display</td>
         </tr>
         <tr> 
         <td>3D Touch</td>
        </tr>   

        <tr> 
        <td>Memory:128 GB</td>
        </tr>
        <tr> 
        <td>price:<b>Rs.<div id="price1" style=" margin:-22px -100px 0px 0px;">1 </div></b></td>
        </tr>

       </table> 
         
    <div class="w3-third w3-margin-bottom" style="width:342px;margin: -465px 50px 30px 438px;">
      <ul class="w3-ul w3-border w3-hover-shadow">
        <li><div class="header">    
  <img src="http://oi65.tinypic.com/2w38fhv.jpg" alt="" style="width: 289px; height: 318px;"/>

</div></li>
        <li class="w3-theme" style="width: 340px; height: 23px;">
          <p class="w3-xlarge" style="margin: -15px -4px 0px -5px;">OnePlus 5T</p>
        </li>
        
      </ul>
      </li>
       <table align="center">
         <tr>
         <td>4.7-inch diagonal Display</td>
         </tr>
         <tr> 
         <td>3D Touch</td>
        </tr>   

        <tr> 
        <td>Memory:32 GB</td>
        </tr>
        <tr> 
        <td>price:<b>Rs.<div id="price2" style=" margin: -22px -100px 0px 0px;">1 </div></b></td>
        </tr>

       </table> 
         
    

     
    </div>



 <div class="w3-third w3-margin-bottom"  style="width: 342px;margin: -485px 50px 0px 862px;">
      <ul class="w3-ul w3-border w3-hover-shadow">
        <li><div class="header">    
  <img src="https://lh3.googleusercontent.com/RnKeDEyzJssi9hh1vUvfJgcPktO18_DuFD5W84pGyFEwlHTIgOxXhF7hOj8ky39w8HmvbAIYC-AHKhH6TyGd=w1280-h726-rw" alt="" style="width: 150px; height: 318px;"/>

</div></li>
        <li class="w3-theme" style="width: 340px; height: 23px;">
          <p class="w3-xlarge" style="margin: -15px -4px 0px -5px;">MI Mix</p>
        </li>
        
      </ul>
      </li>
       <table align="center">
         <tr>
         <td>4 inch diagonal Display</td>
         </tr>
         <tr> 
         <td>1.3GHz dual-core</td>
        </tr>   

        <tr> 
        <td>Memory:16 GB</td>
        </tr>
        <tr> 
        <td>price:<b>Rs.<div id="price3" style=" margin: -22px -100px 0px 0px;">1 </div></b></td>
        </tr>

       </table> 
         
    </div>

      </ul>
    </div>


<div class="footer">
    <font color=" sky blue"> HODOR </font>
  &copy; 2017 Online shopping  </div>


</body>
</html>
