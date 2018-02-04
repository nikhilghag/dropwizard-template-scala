<#-- @ftlvariable name="" type="com.nikhilghag.views.UserView" -->
<html>
    <body>
        <!-- calls getUser().getName() and sanitizes it -->
        <h1>Hello, ${user.name?html}!</h1>
    </body>
</html>