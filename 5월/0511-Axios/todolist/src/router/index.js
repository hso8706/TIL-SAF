import Vue from 'vue'
import VueRouter from 'vue-router'
import TodoHomeView from '../views/TodoHomeView.vue'
import TodoListView from '../views/TodoListView.vue'
import TodoCreateView from '../views/TodoCreateView.vue'
import TodoViewView from '../views/TodoViewView.vue'
import TodoDeleteView from '../views/TodoDeleteView.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'todohome',
    component: TodoHomeView
  },
  {
    path: '/todolist',
    name: 'todolist',
    component: TodoListView
  },
  {
    path: '/todocreate',
    name: 'todocreate',
    component: TodoCreateView
  },
  {
    path: '/todoview/:num',
    name: 'todoview',
    component: TodoViewView
  },
  {
    path: '/tododelete/:num',
    name: 'tododelete',
    component: TodoDeleteView
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
