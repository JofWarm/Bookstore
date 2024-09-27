import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import axios from './axios'

import Element from "element-ui"
import "element-ui/lib/theme-chalk/index.css"




Vue.use(Element)
Vue.prototype.$axios = axios

require("./mock.js")

Vue.config.productionTip = false


new Vue({
  router,
  store,
  render: function (h) { return h(App) }
}).$mount('#app')
