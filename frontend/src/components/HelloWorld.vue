<template>
    <div class="hello">

        <div id="login" style="display: none">

        </div>

        <div id="container" style="display: none">
            <video autoplay id="videoElement">

            </video>
        </div>
    </div>
</template>

<script>

    // import Vue from 'vue'
    // import VuePeerJS from 'vue-peerjs';
    // import Peer from 'peerjs';
    // import axios from "axios";

    window.onload = function() {



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




        // let video = document.getElementById("videoElement");
        //
        // if (navigator.mediaDevices.getUserMedia) {
        //     navigator.mediaDevices.getUserMedia({ video: true })
        //         .then(function (stream) {
        //             video.srcObject = stream;
        //         })
        //         .catch(function (e) {
        //             console.log("Something went wrong!" + e);
        //         });
        // }
    }

    // export default {
    //     data () {
    //         return {
    //             peerId: null,
    //             peers: null
    //         }
    //     },mounted() {
    //         axios.get('http://localhost:8080').then(response => {
    //             this.peers = response.data;
    //             if (this.peers.length > 0) {
    //                 console.log(this.peers);
    //             } else {
    //                 console.log('else ' + this.peers);
    //                 axios.post('http://localhost:8080', 'Andrey');
    //             }
    //         });
    //     }
    // }

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

    #container {
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


