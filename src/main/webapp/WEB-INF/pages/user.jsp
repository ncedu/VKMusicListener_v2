<?xml version="1.0" encoding="ISO-8859-1" ?>

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
    <a href="localhost:8080/VKMusicListener/exit" class="exit">Exit</a>
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
        <h3>Rooms:</h3>
        <div id="roomsblock" style="overflow: auto; height: 80%; margin-top: 5%;">
            <script type="text/javascript">
                var rooms = ($.ajax({
                    url:"/VKMusicListener/getRoom/"+${vk_id},
                    type:"POST",
                    data: null,
                    async: false
                })).responseJSON;

                //Потом сделаю так, чтобы кнопки и записи добавлялись в таблицу
                for(var i = 0; i < rooms.length; i++)
                {
                    var gobutton = document.createElement("input");
                    gobutton.style = "width:10%;height:5%";
                    gobutton.type = "button";
                    gobutton.value = "Go";
                    gobutton.id = rooms[i].room_link + "g";
                    gobutton.onclick = function() {
                        var str = "room/"+this.id.substring(0,this.id.length-1);
                        location.href = str;
                    }
                    var deletebutton = document.createElement("input");
                    deletebutton.style = "width:10%;height:5%";
                    deletebutton.type = "button";
                    deletebutton.value = "Delete";
                    deletebutton.id = rooms[i].room_link + "d";
                    deletebutton.onclick = function() {
                        $.ajax({
                            url:"/VKMusicListener/deleteRoom/"+this.id.substring(0,this.id.length-1),
                            type:"POST",
                            data: null
                        });
                    }
                    var roomname = document.createElement("div");
                    roomname.innerText = rooms[i].name + " ";
                    roomname.style = "box-sizing: border-box; margin-left: 3%; text-overflow: ellipsis;display:inline-block; width:10%;height:8%;";
                    var roomsblock = document.getElementById("roomsblock");
                    var line = document.createElement("div");
                    roomsblock.appendChild(line);
                    line.appendChild(roomname);
                    line.appendChild(gobutton);
                    //надо доделать удаление
                    //   line.appendChild(deletebutton);
                }
            </script>
        </div>
    </div>
</div>
<div class="popup" id="popup1">
    <div class="popup-content">
        <a href="javascript:PopUpHide()" class="hidePopUp">Close</a>
        <div class="roomsParams">
            <form>
                <p><input id="name" type="text"/>Room name</p>
                <p><input id="description" type="text"/>Room description</p>
                <button id="send" type="button"/>Create room</p>
                <script type="text/javascript">
                    document.getElementById("send").addEventListener("mousedown", function (event) {
                        if (event.which == 1) {
                            var room = { name : null, description : null };
                            room.name = document.getElementById("name").value;
                            room.description = document.getElementById("description").value;
                            room.creatorVkId = ${vk_id};
                            console.log("Отправляю "+JSON.stringify(room));
                            var rooms = $.ajax({
                                url:"/VKMusicListener/add_room",
                                type:"POST",
                                headers: {
                                    "Accept" : "application/json; charset=utf-8"
                                },
                                contentType:"application/json; charset=utf-8",
                                data: JSON.stringify(room),
                                dataType:"json"
                            })
                            document.getElementById("name").value ="";
                            document.getElementById("description").value="";
                            window.location.reload();
                            PopUpHide();
                        }
                    })
                </script>
            </form>
        </div>
    </div>
</div>

</body>
</html>
