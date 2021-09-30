<!DOCTYPE html>
<html>

<body>

<h2>
    Dear ${param.userName}, Your are Welcome!!!
</h2>

<br>
<br>
<br>

<form action="/showUserDetails" method="get">
    <input type="text" name="userName"
           placeholder="Write Your name please"/>

    <input type="submit">

</form>

</body>

</html>