<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <link rel="stylesheet" href="resources/css/user.css">
    <script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
    <script>
        $(document).ready(function () {
            PopUpHide();
        });
        function PopUpShow() {
            $("#popup1").show();
        }

        function PopUpHide() {
            $("#popup1").hide();
        }
    </script>
    <title>User Page</title>
</head>
<body>
    <div class="top">
        <img class="logo" src="resources/img/logo.png">
        <a href="localhost:8080/VKMusicListener/exit" class="exit"/>Exit</a>
    </div>
    <div class="workspace">
        <div class="user_info">
            <div class="infoblock">
                <p>Username: ${username}</p>
                <p>VK id: ${vk_id}</p>
                <P>Registration: ${registration}</P>
            </div>
        </div>
        <div class="rooms">
            <a href="javascript:PopUpShow()" class="newRoom">Add new room..</a>
            <hr class="hr">
        </div>
    </div>
    <div class="popup" id="popup1">
        <div class="popup-content">
            <a href="javascript:PopUpHide()" class="hidePopUp">Close</a>
            <div class="roomsParams">
                <form action="roomadd.jsp">
                    <p><input type="text"/>Room name</p>
                    <p><input type="text"/>Room description</p>
                    <p><input type="submit" value="Create room"/></p>
                </form>
            </div>
        </div>
    </div>

</body>
</html>