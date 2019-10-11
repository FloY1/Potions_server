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
        },
        addPotionMutation(state,newPotion){
            state.potions = [
                ...state.potions
                ,newPotion
                ]
            console.log("add"+newPotion)
        }

    },
    actions: {
        async getAppPotionActions({commit}){
            const result = await PotionApi.getAllPotion()
            const potions = await result.json();
            commit('initPotions',potions);
        },

        async addPotion({commit}, data) {
            const result = await PotionApi.add(data.potion)
            const potion = await result.json()

            const fd = new FormData()


            if(data.file.length >0) {
                data.file.forEach(el => {
                    fd.append("file", el, el.name)
                })

                const resultPotion = await PotionApi.addImage(fd, potion.id)
                const newPot = await resultPotion.json()
                console.log(newPot)
                commit('addPotionMutation',newPot);
            }
        },

    }
})
