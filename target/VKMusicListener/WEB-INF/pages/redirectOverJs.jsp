<!DOCTYPE html>
<html>
<head>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
    <script type="application/javascript">
        /*var params = location.hash.split('#')[1].split('&');
        var url = 'http://localhost:8080/VKMusicListener/user';
        var http = new XMLHttpRequest();
        var params = params[0].concat('&').concat(params[3]);
        http.open ('POST', url, true)
        http.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        http.setRequestHeader("Content-length", params.length);
        http.setRequestHeader("Connection", "close");

        http.onreadystatechange = function() {//Call a function when the state changes.
            if(http.readyState == 4 && http.status == 200) {
                alert('hello'+http.responseText);
            }
        };
        http.send(params); */
        //location='http://localhost:8080/VKMusicListener/user?'.concat(params[0]).concat('&').concat(params[2]);
        location='http://localhost:8080/VKMusicListener/useradd?'.concat(location.hash.split('#')[1]);
    </script>
</head>
</html>