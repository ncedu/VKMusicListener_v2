<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Room</title>
    <link rel="stylesheet" href="resources/css/room.css">
    <script type="text/javascript" src="resources/script/lib/jquery/1.10.2/jquery-1.10.2.min.js" ></script>
    <!-- audio -->
    <script type="text/javascript" src="resources/script/lib/jPlayer.2.6.0/js/jquery.jplayer.min.js"></script>
    <script type="text/javascript" src="resources/script/lib/jPlayer.2.6.0/js/jplayer.playlist.min.js"></script>
    <script type="text/javascript" src="resources/script/player.js"></script>
    <link href="resources/script/lib/jPlayer.2.6.0/skin/vkontakte/vkontakte.css" rel="stylesheet" type="text/css" />
</head>
    <body>
        <div class="top">
            <img class="logo" src="resources/img/logo.png">
            <a href="localhost:8080/VKMusicListener/exit" class="exit">Exit</a>
        </div>
        <div class="workspace">
            <div class="room-info">

            </div>
            <div class="room-content">
                <div id="jquery_jplayer_1" class="jp-jplayer">

                </div>
                <div id="jp_container_1" class="jp-audio">

                    <div class="jp-type-playlist">
                        <div class="jp-gui jp-interface">
                            <ul class="jp-controls">
                                <li>
                                    <label id="name-of-the-song-that-plays"></label>
                                </li>
                                <li><a href="javascript:;" class="jp-play" tabindex="1">play</a></li>
                                <li><a href="javascript:;" class="jp-pause" tabindex="1">pause</a></li>
                                <li><a href="javascript:;" class="jp-previous" tabindex="1">previous</a></li>
                                <li><a href="javascript:;" class="jp-next" tabindex="1">next</a></li>
                                <div class="clear"></div>
                            </ul>
                            <!-- Прогресс бар -->
                            <div class="jp-progress">
                                <div class="jp-seek-bar">
                                    <div class="jp-play-bar"></div>
                                </div>
                            </div>
                            <!-- Регулятор громкости -->
                            <div class="jp-volume-bar">
                                <div class="jp-volume-bar-value"></div>
                            </div>
                            <!-- Остаток времени -->
                            <div class="jp-time-holder">
                                <div class="jp-current-time"></div>
                            </div>

                            <div class="clear"></div>

                            <!-- Кнопки повторения и перемешивания плейлиста -->
                            <ul class="jp-toggles">
                                <li>
                                    <a href="javascript:;" class="jp-shuffle" tabindex="1" title="shuffle">shuffle</a>
                                </li>
                                <li>
                                    <a href="javascript:;" class="jp-shuffle-off" tabindex="1" title="shuffle off">shuffle off</a>
                                </li>
                                <li>
                                    <a href="javascript:;" class="jp-repeat" tabindex="1" title="repeat">repeat</a>
                                </li>
                                <li>
                                    <a href="javascript:;" class="jp-repeat-off" tabindex="1" title="repeat off">repeat off</a>
                                </li>
                            </ul>
                            <div class="clear"></div>
                        </div>
                        <!-- Будущий плейлист -->
                        <div class="jp-playlist">
                            <ul class="jp-playlist-list">
                                <li></li>
                            </ul>
                        </div>
                        <!-- Сообщение об ошибке -->
                        <div class="jp-no-solution">
                            <span>Update Required</span>
                            To play the media you will need to either update your browser to a recent version or update your
                            <a href="http://get.adobe.com/flashplayer/" target="_blank">
                                Flash plugin
                            </a>.
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>