import Vue from 'vue'
import App from './App.vue'

Vue.config.productionTip = false

new Vue({
  render: h => h(App),
}).$mount('#app')

// render: 화면 만드는 부분
// .$mount 와 el의 역할을 똑같다.
