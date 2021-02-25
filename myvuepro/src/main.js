import Vue from 'vue'
import App from './App.vue'
import router from './router'
import iView from 'view-design'
import 'view-design/dist/styles/iview.css'
// import appComponents from '@/components/'

Vue.config.productionTip = false

Vue.use(router)
Vue.use(iView)
// Vue.use(appComponents)


new Vue({
  el: '#app',
  router,
  render: h => h(App)
})
