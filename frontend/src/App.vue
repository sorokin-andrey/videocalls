<template>
  <div id="app">
    <Background/>
    <HelloWorld id="hello"/>
    <Intro id="intro"/>
  </div>
</template>

<script>

import HelloWorld from './components/HelloWorld.vue'
import Intro from './components/Intro.vue'
import Background from './components/Background.vue'
import axios from "axios"

export default {
  name: 'App',
  components: {
    HelloWorld,
    Intro,
    Background
  },
  data () {
      return {
          peerId: null,
          peers: null
      }
  },
  mounted() {
      axios.get('http://localhost:8080').then(response => {
          this.peers = response.data;
          if (response.data.length > 0) {
              console.log(this.peers);
          }
      });
  }
}

window.onload = function() {
  if (this.peers != null && this.peers.length > 0) {
      document.getElementById("intro").style.visibility = 'hidden';
      document.getElementById("hello").style.visibility = 'visible';
  } else {
      document.getElementById("intro").style.visibility = 'visible';
      document.getElementById("hello").style.visibility = 'hidden';
  }
}
</script>

<style>
body{
  font-weight: 300;
  margin: 0;
  font-family: "Source Sans Pro", sans-serif;
  /* color: white; */
}
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}
</style>
