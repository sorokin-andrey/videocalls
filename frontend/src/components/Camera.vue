<template>
    <div id="videoContainer">
        <video autoplay id="videoElement">

        </video>
    </div>
</template>

<script>

    // import Vue from 'vue'
    // import VuePeerJS from 'vue-peerjs';
    // import Peer from 'peerjs';
    // import axios from "axios";

    window.onload = function() {

        startVideo();


        // let peerAndrey = new Peer('Andrey');
        // let peerNadezhda = new Peer('Nadezhda');
        //
        // Vue.use(VuePeerJS, peerAndrey);
        //
        // let conn = peerAndrey.connect(peerNadezhda);
        // // on open will be launch when you successfully connect to PeerServer
        // conn.on('open', function(){
        //     // here you have conn.id
        //     conn.send('hi!');
        // });
        //
        // peerNadezhda.on('connection', function(conn) {
        //     conn.on('data', function(data){
        //         // Will print 'hi!'
        //         console.log(data);
        //     });
        // });
    }


    function startVideo() {
        let video = document.getElementById("videoElement");

        if (navigator.mediaDevices.getUserMedia) {
            navigator.mediaDevices.getUserMedia({ video: true })
                .then(function (stream) {
                    video.srcObject = stream;
                })
                .catch(function (e) {
                    console.log("Something went wrong!" + e);
                });
        }
    }
</script>

<style scoped lang="less">
    h3 {
        margin: 40px 0 0;
    }

    ul {
        list-style-type: none;
        padding: 0;
    }

    li {
        display: inline-block;
        margin: 0 10px;
    }

    a {
        color: #42b983;
    }

    #videoContainer {
        margin: 0 auto;
        width: 500px;
        height: 375px;
        border: 10px #333 solid;
        
    }
    #videoElement {
        width: 500px;
        height: 375px;
        background-color: #666;
    }

</style>


