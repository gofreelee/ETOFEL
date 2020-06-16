import Vue from 'vue'
import App from './App.vue'
import ElementUI from 'element-ui'
import 'element-theme-chalk'
import router from './router'
import 'font-awesome/css/font-awesome.css'
import axios from 'axios'

axios.defaults.withCredentials = true
Vue.config.productionTip = false
Vue.use(ElementUI)
Vue.prototype.$axios = axios;

new Vue({
    router,
    render: h => h(App),
}).$mount('#app')
