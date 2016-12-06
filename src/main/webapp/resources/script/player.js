/**
 * Created by nick on 26.11.16.
 */

$(document).ready(function(){

    var cssSelector = {
        jPlayer: "#jquery_jplayer_1",
        cssSelectorAncestor: "#jp_container_1"
    };

    // var playlist = ($.ajax(){
    //     url:'/VKMusicListener/getRoom/';
    //     type: 'POST';
    //     data: 'null';
    //     async: 'false'
    // })
    // var playlist = [
    //     {
    //         author:"TSP",
    //         title:"Cro Magnon Man",
    //         discription: "Текст песни / описание",
    //         mp3:"http://localhost:8080/VKMusicListener/mp3/2",
    //         oga:"http://www.jplayer.org/audio/ogg/TSP-01-Cro_magnon_man.ogg"
    //     },
    //     {
    //         author:"TSP",
    //         title:"Your Face",
    //         discription: "Текст песни / описание",
    //         mp3:"http://www.jplayer.org/audio/mp3/TSP-05-Your_face.mp3",
    //         oga:"http://www.jplayer.org/audio/ogg/TSP-05-Your_face.ogg"
    //     },
    //     {
    //         author:"TSP",
    //         title:"Cyber Sonnet",
    //         discription: "Текст песни / описание",
    //         mp3:"http://www.jplayer.org/audio/mp3/TSP-07-Cybersonnet.mp3",
    //         oga:"http://www.jplayer.org/audio/ogg/TSP-07-Cybersonnet.ogg"
    //     },
    //     {
    //         author:"Miaow",
    //         title:"Tempered Song",
    //         discription: "Текст песни / описание",
    //         mp3:"http://www.jplayer.org/audio/mp3/Miaow-01-Tempered-song.mp3",
    //         oga:"http://www.jplayer.org/audio/ogg/Miaow-01-Tempered-song.ogg"
    //     },
    //     {
    //         author:"Miaow",
    //         title:"Hidden",
    //         discription: "Текст песни / описание",
    //         mp3:"http://www.jplayer.org/audio/mp3/Miaow-02-Hidden.mp3",
    //         oga:"http://www.jplayer.org/audio/ogg/Miaow-02-Hidden.ogg"
    //     },
    //     {
    //         author:"Miaow",
    //         title:"Lentement",
    //         free:true,
    //         discription: "Текст песни / описание",
    //         mp3:"http://www.jplayer.org/audio/mp3/Miaow-03-Lentement.mp3",
    //         oga:"http://www.jplayer.org/audio/ogg/Miaow-03-Lentement.ogg"
    //     },
    //     {
    //         author:"Miaow",
    //         title:"Lismore",
    //         discription: "Текст песни / описание",
    //         mp3:"http://www.jplayer.org/audio/mp3/Miaow-04-Lismore.mp3",
    //         oga:"http://www.jplayer.org/audio/ogg/Miaow-04-Lismore.ogg"
    //     },
    //     {
    //         author:"Miaow",
    //         title:"The Separation",
    //         discription: "Текст песни / описание",
    //         mp3:"http://www.jplayer.org/audio/mp3/Miaow-05-The-separation.mp3",
    //         oga:"http://www.jplayer.org/audio/ogg/Miaow-05-The-separation.ogg"
    //     },
    //     {
    //         author:"Miaow",
    //         title:"Beside Me",
    //         discription: "Текст песни / описание",
    //         mp3:"http://www.jplayer.org/audio/mp3/Miaow-06-Beside-me.mp3",
    //         oga:"http://www.jplayer.org/audio/ogg/Miaow-06-Beside-me.ogg"
    //     },
    //     {
    //         author:"Miaow",
    //         title:"Bubble",
    //         free:true,
    //         discription: "Текст песни / описание",
    //         mp3:"http://www.jplayer.org/audio/mp3/Miaow-07-Bubble.mp3",
    //         oga:"http://www.jplayer.org/audio/ogg/Miaow-07-Bubble.ogg"
    //     },
    //     {
    //         author:"Miaow",
    //         title:"Stirring of a Fool",
    //         discription: "Текст песни / описание",
    //         mp3:"http://www.jplayer.org/audio/mp3/Miaow-08-Stirring-of-a-fool.mp3",
    //         oga:"http://www.jplayer.org/audio/ogg/Miaow-08-Stirring-of-a-fool.ogg"
    //     },
    //     {
    //         author:"Miaow",
    //         title:"Partir",
    //         free: true,
    //         discription: "Текст песни / описание",
    //         mp3:"http://www.jplayer.org/audio/mp3/Miaow-09-Partir.mp3",
    //         oga:"http://www.jplayer.org/audio/ogg/Miaow-09-Partir.ogg"
    //     },
    //     {
    //         author:"Miaow",
    //         title:"Thin Ice",
    //         discription: "Текст песни / описание",
    //         mp3:"http://www.jplayer.org/audio/mp3/Miaow-10-Thin-ice.mp3",
    //         oga:"http://www.jplayer.org/audio/ogg/Miaow-10-Thin-ice.ogg"
    //     }
    // ];

    var options = {
        swfPath: "js",
        supplied: "oga, mp3",
        wmode: "window",
        smoothPlayBar: false,
        keyEnabled: true
    };

    window.jPP = new jPlayerPlaylist(cssSelector, playlist, options);
    var test = {
        value: "value"
    }
});