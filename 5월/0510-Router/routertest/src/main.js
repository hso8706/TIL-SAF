import Vue from 'vue'
import App from './App.vue'
import router from './router'// file명이 index면 생략 가능

Vue.config.productionTip = false

new Vue({
  router, // 새로 추가된 부분
  render: h => h(App)
}).$mount('#app')
