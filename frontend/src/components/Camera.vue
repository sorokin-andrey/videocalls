<template>
    <div class="wrapper">
        <div id="videoContainer1" class="videoContainer"></div>
        <div id="videoContainer2" class="videoContainer"></div>
    </div>
</template>

<script>
    import Peer from 'simple-peer';

    export default {
        data () {
            return {
                yourId: '',
                otherId: '',
                yourMessage: '',
                messages: '',
                peer: ''
            }
        },
        methods: {
            createVideo(videoId) {
                let video = document.createElement("video");
                video.classList.add('videoElement');
                video.style.width="100%";
                video.style.height="375px";
                video.setAttribute("id", videoId);
                video.setAttribute("autoplay", "true");

                return video;
            },
            createVideoContainer(containerId, videoId) {
                let videoContainer = document.getElementById(containerId);
                let video1 = this.createVideo(videoId);
                let video11 = this.createVideo(videoId + 1);

                videoContainer.appendChild(video1);
                videoContainer.appendChild(video11);
            },
            // mirror(videoId) {
            //     document.getElementById(videoId).style.setProperty('transform', 'rotateY(180deg)');
            //     document.getElementById(videoId).style.setProperty('-webkit-transform', 'rotateY(180deg)');
            //     document.getElementById(videoId).style.setProperty('-moz-transform', 'rotateY(180deg)');
            // },
            // createP2P(stream) {
            //     const peer = new Peer({
            //         initiator: location.hash === '#1',
            //         trickle: false,
            //         stream: stream
            //     });
            //     peer.on('error', err => console.log('error', err));
            //     peer.on('signal', data => {
            //         console.log('SIGNAL', JSON.stringify(data));
            //     });
            //     peer.on('connect', () => {
            //         console.log('CONNECT');
            //         peer.send('whatever' + Math.random());
            //     });
            //     peer.on('stream', stream => {
            //         // got remote video stream, now let's show it in a video tag
            //         let video;
            //         if (location.hash === '#1') {
            //             console.log("video1");
            //             video = document.getElementById('video1');
            //         } else {
            //             console.log("video2");
            //             video = document.getElementById('video2');
            //         }
            //
            //         if ('srcObject' in video) {
            //             video.srcObject = stream
            //         } else {
            //             video.src = window.URL.createObjectURL(stream) // for older browsers
            //         }
            //
            //         video.setAttribute("autoplay", "true");
            //         video.play()
            //     })
            // },
            createP2P () {
                navigator.mediaDevices.getUserMedia({ video: true, audio: true })
                    .then(stream => this.gotMedia(stream))
                    .catch(err => console.log('error', err));
            },
            gotMedia (stream) {
                this.peer = new Peer({
                    initiator: location.hash === "#1",
                    trickle: false,
                    stream: stream
                });
                this.peer.on('error', err => console.log('error', err));
                this.peer.on('signal', signal => this.yourId = JSON.stringify(signal));
                this.peer.on('data', data => this.messages += data + '\n');
                this.peer.on('stream', stream => {
                    console.log("i am here");
                    let videoContainer2 = document.getElementById("videoContainer2");
                    let video = this.createVideo("video2");
                    video.srcObject = stream;
                    video.setAttribute("autoplay", "true");
                    videoContainer2.appendChild(video);
                    video.play();
                });
            }
        },
        mounted(){
            this.createVideoContainer("videoContainer1", "video1");
            // this.createVideoContainer("videoContainer2", "video2");
            // document.getElementById("video1").setAttribute("autoplay", "true");
            // document.getElementById("video2").setAttribute("autoplay", "true");

            // this.createP2P();

            if (navigator.mediaDevices.getUserMedia) {
                navigator.mediaDevices.getUserMedia({ video: true, audio: true })
                    .then(stream => {
                        let video1 = document.getElementById("video1");
                        video1.srcObject = stream;
                        this.createP2P(stream);
                    })
                    .catch(err => console.log('error', err));
            }
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

    .wrapper {
        display: inline-flex;
    }
    .videoContainer {
        margin: 0 auto;
        width: 500px;
        height: 750px;
        border: 10px #333 solid;
        
    }
    .videoElement {
        width: 500px;
        height: 375px;
        background-color: #666;
    }

</style>


