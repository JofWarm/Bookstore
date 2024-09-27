import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import Login from '../views/Login/Login.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'home',
    component: Home
  },
  {
    path: '/login',
    name: 'Login',
    component: function () {
      return import( '../views/Login/Login.vue')
    }
  },
  {
    path: '/index',
    name: 'index',
    component: function () {
      return import('../views/index/index.vue')
    }
  },
  {
    path:'/pay',
    name:'pay',
    component: function () {
      return import('../views/pay.vue')
    }
  },
  {
    path:'/register',
    name:'register',
    component: function () {
      return import('../views/Login/register.vue')
    }
  }
]

const router = new VueRouter({
  routes
})

export default router
