import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import Login from '../views/Login/Login.vue'
import OrderPage from '../views/index/orders.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    redirect:'/login'
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
      return import('../views/paypart/pay.vue')
    }
  },
  {
    path: '/order',
    name: 'OrderPage',
    component: OrderPage
  },
  {
    path:'/pay/alipay',
    name:'pay',
    component: function () {
      return import('../views/paypart/alipay.vue')
    }
  },
  {
    path:'/pay/wechat',
    name:'pay',
    component: function () {
      return import('../views/paypart/wechat.vue')
    }
  },


]

const router = new VueRouter({
  routes
})

export default router
