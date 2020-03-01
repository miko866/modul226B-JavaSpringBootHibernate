import Vue from 'vue';
import App from './App.vue';
import router from './router';
import store from './store';
import vuetify from './plugins/vuetify';
import 'material-design-icons-iconfont/dist/material-design-icons.css';

/*
 * START Sweetalert 2
 */
import VueSweetalert2 from 'vue-sweetalert2';

// CSS
import 'sweetalert2/dist/sweetalert2.min.css';
// Set custom buttons color
const options = {
  confirmButtonColor: '#911142',
  cancelButtonColor: '#ff7674'
};

Vue.use(VueSweetalert2, options);
//* END Sweetalert 2

Vue.config.productionTip = false;

new Vue({
  router,
  store,
  vuetify,
  render: h => h(App)
}).$mount('#app');
