<template>
  <v-app>
    <app-bar/>
    <v-content>
      <add-potion></add-potion>
      <add-recipe></add-recipe>
    </v-content>
  </v-app>
</template>

<script>
import AppBar from './components/AppBar';
import AddPotion from './components/pages/AddPotion';
import AddRecipe from './components/pages/AddRecipe';

import { mapActions } from 'vuex'


export default {
  name: 'App',
  components: {
    AppBar,
    AddPotion,
    AddRecipe
  },
  methods:{
    ...mapActions(['getAppPotionActions'])
  },
  data: () => ({
    //
  }),
  created() {
      this.getAppPotionActions()
  }
};
</script>
