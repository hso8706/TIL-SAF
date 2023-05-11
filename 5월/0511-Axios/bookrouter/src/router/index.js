import Vue from 'vue'
import VueRouter from 'vue-router'
import HomeView from '../views/HomeView.vue'
import BookListView from '../views/BookListView.vue'
import BookCreateView from '../views/BookCreateView.vue'
import BookViewView from '../views/BookViewView.vue'
import BookDeleteView from '../views/BookDeleteView.vue'

//전역 수준(모든 .vue files)에서 VueRouter를 사용하기 위해 선언
//.vue 파일 안에서 this.$router(VueRouter 객체)로 접근 가능
Vue.use(VueRouter)

const routes = [
  {
    //미리 component를 만들어놓고 제공하는 방식
    path: '/',
    name: 'home',
    component: HomeView
  },
  {
    path: '/booklist',
    name: 'booklist',
    component: BookListView

    //link를 누른 후 component를 생성하는 방식
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    // component: () => import(/* webpackChunkName: "about" */ '../views/AboutView.vue')
  },
  {
    path: '/bookcreate',
    name: 'bookcreate',
    component: BookCreateView
  },
  {
    path: '/bookview/:isbn',
    name: 'bookview',
    component: BookViewView
  },
  {
    path: '/bookdelete/:isbn',
    name: 'bookdelete',
    component: BookDeleteView
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
