<template>
  <v-app>
    <v-app-bar app color="primary" dark>
      <div class="d-flex align-center">
        <v-img
          alt="Vuetify Logo"
          class="shrink mr-2"
          contain
          src="https://cdn.vuetifyjs.com/images/logos/vuetify-logo-dark.png"
          transition="scale-transition"
          width="40"
        />
      </div>

      <h1 @click="home()">Client Manager</h1>
      <v-spacer></v-spacer>
    </v-app-bar>

    <v-content fluid>
      <v-container fluid>
        <router-view />
      </v-container>
    </v-content>
  </v-app>
</template>

<script>
export default {
  name: 'App',
  methods: {
    home() {
      //* Redirect to dashboard
      this.$router.push('/');
    }
  }
};
</script>

<style lang="scss" scoped>
h1 {
  cursor: pointer;
}
</style>
