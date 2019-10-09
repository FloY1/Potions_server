import Vue from 'vue'
import Vuex from 'vuex'
import PotionApi from "./api/potionApi"


Vue.use(Vuex)

Vue.http.options.root = 'http://localhost:8080'
Vue.http.interceptors.push(function(request) {
  request.headers.set('Access-Control-Allow-Origin', 'http://localhost:8081')
});

export default new Vuex.Store({
  state: {
      potions: null
  },
  mutations: {
      initPotions(state, newPotions){
        state.potions  = newPotions;
      }
  },
  actions: {
    async getAppPotionActions({commit}){
        const result = await PotionApi.getAllPotion()
        const potions = await result.json();
        commit('initPotions',potions);
    },

    async addPotion(data) {
      const result = await PotionApi.add(data.potion)
      const potion = await result.json()


      const fd = new FormData()

      data.file.forEach(el=>{
        fd.append("file",el,el.name)
      })


      await PotionApi.addImage(fd,potion.id)

    },

  }
})
