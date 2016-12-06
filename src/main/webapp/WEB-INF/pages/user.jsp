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
        <div id="roomsblock">
            <ul id="listrooms">

            </ul>
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
                    gobutton.type = "button";
                    gobutton.value = "Go";
                    gobutton.id = rooms[i].room_link + "g";
                    gobutton.onclick = function() {
                        var str = "room/"+this.id.substring(0,this.id.length-1);
                        location.href = str;
                    }
                    var deletebutton = document.createElement("input");
                    deletebutton.type = "button";
                    deletebutton.value = "Delete";
                    deletebutton.id = rooms[i].room_link + "d";
                    deletebutton.onclick = function() {
                        //тут напишу запрос на сервер на удаление
                    }
                    var roomsblock = document.getElementById("roomsblock");
                    var listrooms = document.getElementById("listrooms");
                    var li = document.createElement("li");
                    var p = document.createElement("p");
                    p.innerHTML = rooms[i].name + "\t";
                    //p.value=rooms[i].name + "\t";
                    li.appendChild(p);
                    li.appendChild(gobutton);
                    li.appendChild(deletebutton);
                    roomsblock.appendChild(li);
                    //roomsblock.appendChild(document.createElement("p"));
                    //document.write(rooms[i].name + " ");
                    //roomsblock.appendChild(gobutton);
                    //roomsblock.appendChild(deletebutton);
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
                            console.log(rooms);
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
