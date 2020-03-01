import Vue from 'vue';
import Vuex from 'vuex';
//* Set Vuex data persistent into LocalStorage
import createPersistedState from 'vuex-persistedstate';

Vue.use(Vuex);

export default new Vuex.Store({
  plugins: [createPersistedState()],
  state: {
    clientID: null,
    clientFirstName: '',
    clientLastName: ''
  },
  mutations: {
    setClientID(state, clientID) {
      state.clientID = clientID;
    },
    setClientFirstName(state, clientFirstName) {
      state.clientFirstName = clientFirstName;
    },
    setClientLastName(state, clientLastName) {
      state.clientLastName = clientLastName;
    }
  },
  actions: {
    setClientID({ commit }, clientID) {
      commit('setClientID', clientID);
    },
    setClientFirstName({ commit }, clientFirstName) {
      commit('setClientFirstName', clientFirstName);
    },
    setClientLastName({ commit }, clientLastName) {
      commit('setClientLastName', clientLastName);
    }
  },
  modules: {}
});
