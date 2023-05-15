import Vue from 'vue'
import VueRouter from 'vue-router'
import TodoHomeView from '../views/TodoHomeView.vue'
import TodoCreateView from '../views/TodoCreateView.vue'
import TodoModifyView from '../views/TodoModifyView.vue'
import TodoDeleteView from '../views/TodoDeleteView.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'todoIndex',
    component: TodoHomeView
  },
  {
    path: '/todocreate',
    name: 'todocreate',
    component: TodoCreateView
  },
  {
    path: '/tododelete',
    name: 'todoDeleteAll',
    component: TodoDeleteView
  },
  {
    path: '/todomodify/:num',
    name: 'todoModify',
    component: TodoModifyView
  },
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
