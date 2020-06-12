import Vue from 'vue'
import App from './App.vue'
import ElementUI from 'element-ui'
import 'element-theme-chalk'
import router from './router'
import 'font-awesome/css/font-awesome.css'

Vue.config.productionTip = false
Vue.use(ElementUI)

new Vue({
  router,
  render: h => h(App),
}).$mount('#app')
