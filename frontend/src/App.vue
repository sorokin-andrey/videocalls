<template>
  <div id="app">
    <Background/>

    <Login id="login"/>
    <Conference id="conference"/>
  </div>
</template>

<script>

import Background from './components/Background.vue'
import Conference from './components/Conference.vue'
import Login from './components/Login.vue'

import axios from "axios"

export default {
  name: 'App',
  components: {
    Background,
    Conference,
    Login
  },
  mounted() {
    axios.get('http://localhost:8080').then(response => show(response.data));
  }
}

function show(data) {
  if (data != null && data.length > 0) {
      document.getElementById("login").style.display = 'none';
      document.getElementById("conference").style.display = 'block';
  } else {
      document.getElementById("login").style.visibility = 'block';
      document.getElementById("conference").style.visibility = 'none';
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
