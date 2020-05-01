<template>
  <div id="app">
    <Background/>
    <router-view></router-view>
  </div>
</template>

<script>

import Background from './components/Background.vue'

export default {
  name: 'App',
  components: {
    Background
  }
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
