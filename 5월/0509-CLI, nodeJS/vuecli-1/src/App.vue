<template>
  <div id="app">
    <img alt="Vue logo" src="./assets/logo.png">
    <MyWorld :code="code"></MyWorld>
    <hr>
    <HelloWorld msg="Welcome to Your Vue.js App"/>
  </div>
</template>

<script>
import HelloWorld from './components/HelloWorld.vue'
import MyWorld from './components/MyWorld.vue'

export default {
  name: 'App',
  components: {
    HelloWorld,
    MyWorld
  },
  data(){
    return{
      code: 'blue123'
    }
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
