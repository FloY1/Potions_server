<template xmlns:v-slot="http://www.w3.org/1999/XSL/Transform">

    <!--            <template>-->

    <!--                <v-img-->
    <!--                        src="http://localhost:8080/image/1"-->
    <!--                        aspect-ratio="1"-->
    <!--                        class="grey lighten-2"-->
    <!--                        max-width="100"-->
    <!--                        max-height="100"-->
    <!--                ></v-img>-->
    <!--            </template>-->

    <v-card
            color="blue-grey darken-1"
            dark
            :loading="isUpdating"
    >
        <v-row align="center">
            <v-col cols="2">
                <v-select
                        v-model="friends"
                        :items="potions"
                        chips
                        label="Chips"
                        solo
                >
                    <template v-slot:selection="data">
                        <v-chip
                                v-bind="data.attrs"
                                :input-value="data.selected"
                                close
                                @click="data.select"
                                @click:close="remove"
                        >
                            <v-avatar left>
                                <v-img :src="'http://localhost:8080/image/' + data.item.firstImg "></v-img>
                            </v-avatar>
                            {{ data.item.name }}
                        </v-chip>
                    </template>

                    <template v-slot:item="data">
                        <template v-if="typeof data.item !== 'object'">
                            <v-list-item-content v-text="data.item"></v-list-item-content>
                        </template>
                        <template v-else>
                            <v-list-item-avatar>
                                <v-img :src="'http://localhost:8080/image/' + data.item.firstImg "></v-img>
                            </v-list-item-avatar>
                            <v-list-item-content>
                                <v-list-item-title v-html="data.item.name"></v-list-item-title>
                            </v-list-item-content>
                        </template>
                    </template>

                </v-select>
            </v-col>
        </v-row>




    </v-card>







</template>

<script>
    import { mapState} from 'vuex'

    export default {

        computed: {...mapState(['potions'])},
        name: "AddRecipe",
        data () {

            return {

                autoUpdate: true,
                friends: "",
                isUpdating: false,
                name: 'Midnight Crew',


                title: 'The summer breeze',
            }
        },

        // watch: {
        //     isUpdating (val) {
        //         if (val) {
        //             setTimeout(() => (this.isUpdating = false), 3000)
        //         }
        //     },
        // },

        methods: {
            remove () {

                this.friends= "";
            },
        },
    }
</script>

<style scoped>

</style>