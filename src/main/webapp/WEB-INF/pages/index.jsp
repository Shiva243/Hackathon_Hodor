<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script type="text/javascript" src="${pageContext.request.contextPath}/dwr/engine.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/dwr/util.js"></script>
    </head>
    <body>
        <h1>Hello World!</h1>
        <div id="messages">
            
        </div>
    </body>
    <script type="text/javascript">
        //Call this on page load so that we tell the server side that we are expecting data
        dwr.engine.setActiveReverseAjax(true);
        //Function that will be called by the server
        function panicAlertSounded(patientName) {
            var existing = dwr.util.getValue("messages", { escapeHtml:false });
            var newValue = existing + "Call doctor: for patient: " + patientName + "<br/>";
            dwr.util.setValue("messages", newValue, { escapeHtml:false });
            console.log("!!!! Panic alert sounded for: " + patientName + ". Call doctor: ");
        }
    </script>
</html>
