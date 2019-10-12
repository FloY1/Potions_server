<template>
  <v-app>
    <app-bar/>
    <v-content>
      <add-recipe></add-recipe>
      <add-potion></add-potion>
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
