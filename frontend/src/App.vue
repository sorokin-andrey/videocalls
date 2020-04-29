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
import {blockVisibilityController} from "./functions/blockVisibilityController"

export default {
  name: 'App',
  components: {
    Background,
    Conference,
    Login
  },
  mounted() {
    axios.get('http://localhost:8080').then(response => blockVisibilityController(response.data));
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
