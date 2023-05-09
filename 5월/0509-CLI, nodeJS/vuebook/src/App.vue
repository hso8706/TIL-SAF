<template>
  <div id="app">
    <book-header></book-header>
    <book-index></book-index>
    <!-- <book-list></book-list> -->
    <!-- <book-view></book-view> -->
    <!-- <book-create></book-create> -->
    <book-footer></book-footer>
  </div>
</template>

<script>
import BookFooter from "./components/BookFooter.vue"
import BookHeader from "./components/BookHeader.vue"
import BookIndex from './components/BookIndex.vue'
// import BookList from './components/BookList.vue'
// import BookView from './components/BookView.vue'
// import BookCreate from './components/BookCreate.vue'

export default {
  name: 'App',
  components: {
    // HelloWorld
    BookHeader,
    BookIndex,
    BookFooter,
    // BookList,
    // BookView,
    // BookCreate
  }
}
</script>

<style>
/* #app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
} */
a {
  text-decoration: none;
  color: #787878;
}
input,
textarea,
.view {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
  color: #787878;
  font-size: medium;
}
label {
  display: inline-block;
  width: 80px;
}
button,
.btn {
  width: 8%;
  background-color: #d0d3d0;
  color: rgb(80, 82, 79);
  padding: 14px 20px;
  margin: 8px 0;
  border: 1px solid #787878;
  border-radius: 4px;
  font-size: large;
  cursor: pointer;
}
.regist {
  padding: 10px;
}
.regist_form {
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 20px;
}
.ssafy_logo {
  width: 150px;
}
.header {
  text-align: center;
  box-shadow: 0px 1px 10px rgba(0, 0, 0, 0.3);
}
.header img {
  vertical-align: middle;
}
.logo {
  display: inline-block;
  font-size: 30pt;
  font-weight: bold;
}
.underline {
  display: inline-block;
  background: linear-gradient(180deg, rgba(255, 255, 255, 0) 70%, cyan 30%);
}
#book-list {
  border-collapse: collapse;
  width: 100%;
}

#book-list thead {
  background-color: #ccc;
  font-weight: bold;
}

#book-list td,
#book-list th {
  text-align: center;
  border-bottom: 1px solid #ddd;
  height: 50px;
}

tr:nth-child(even) {
  background-color: #f2f2f2;
}

</style>
