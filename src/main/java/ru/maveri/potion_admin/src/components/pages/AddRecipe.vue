<template xmlns:v-slot="http://www.w3.org/1999/XSL/Transform">

    <!--            <templates>-->

    <!--                <v-img-->
    <!--                        src="http://localhost:8080/image/1"-->
    <!--                        aspect-ratio="1"-->
    <!--                        class="grey lighten-2"-->
    <!--                        max-width="100"-->
    <!--                        max-height="100"-->
    <!--                ></v-img>-->
    <!--            </templates>-->

    <v-card
            class="mx-auto my-3 pa-6"
            width="700px"
            color="blue-grey darken-1"
            dark
            :loading="isUpdating"
            justify="center"
    >
        <v-container>

            <v-row >
                <v-col   md="6" >
                    <autocomplete :select="firstSelect"></autocomplete>
                    <template v-if="typeof firstPotion == 'object'">
                        <potion-params :potion="firstPotion"/>
                    </template>
                </v-col>
                <v-col   md="6" >
                    <autocomplete :select="secondSelect"></autocomplete>
                    <template v-if="typeof secondPotion == 'object'">
                        <potion-params   :potion="secondPotion"/>
                    </template>
                </v-col>
            </v-row>
        </v-container>
<!--            <v-row >-->
<!--                <v-col cols="6">-->
<!--                    <templates v-if="typeof firstPotion == 'object'">-->
<!--                        <potion-params :potion="firstPotion"/>-->
<!--                    </templates>-->
<!--                </v-col>-->
<!--                <v-col cols="6">-->
<!--                    <templates v-if="typeof secondPotion == 'object'">-->
<!--                        <potion-params   :potion="secondPotion"/>-->
<!--                    </templates>-->
<!--                </v-col>-->
<!--            </v-row>-->





    </v-card>







</template>

<script>
    import { mapState} from 'vuex'
    import Autocomplete from "./part/AddRecipe/Autocomplete.vue";
    import PotionParams from "./part/AddRecipe/PotionParams";


    export default {
        components: {PotionParams, Autocomplete},
        computed: {...mapState(['potions'])},
        name: "AddRecipe",
        data() {
            return {

                autoUpdate: true,
                firstPotion: "",
                secondPotion: "",
                isUpdating: false,
                name: 'Midnight Crew',


                title: 'The summer breeze',
            }
        },
        methods: {
            firstSelect(potion) {
                this.firstPotion = potion
            },
            secondSelect(potion) {
                this.secondPotion = potion
            },


        },
        watch: {
            // isUpdating (firstPotion) {
            //        console.log(firstPotion)
            //
            // },
        },

    }

</script>

<style scoped>

</style>