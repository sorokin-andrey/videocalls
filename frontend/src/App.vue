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
  data (){
    return {
      component: "Login"
    }
  },
  mounted() {
    axios.get('http://192.168.178.39:9000').then(response => blockVisibilityController(response.data));
  },
}
</script>

<style>
@import url(https://fonts.googleapis.com/css?family=Source+Sans+Pro:200,300);
body{
  font-weight: 300;
  margin: 0;
  font-family: "Source Sans Pro", sans-serif;
}
#app {
  display: flex;
  height: 100vh;
}

.fadeIn {
    -webkit-transition: opacity 4s ease-in-out;
    -moz-transition: opacity 4s ease-in-out;
    -ms-transition: opacity 4s ease-in-out;
    -o-transition: opacity 4s ease-in-out;
    opacity: 1!important;
}

.fadeOut {
    -webkit-transition: opacity 1s ease-in-out;
    -moz-transition: opacity 1s ease-in-out;
    -ms-transition: opacity 1s ease-in-out;
    -o-transition: opacity 1s ease-in-out;
    opacity: 0;
}
</style>
