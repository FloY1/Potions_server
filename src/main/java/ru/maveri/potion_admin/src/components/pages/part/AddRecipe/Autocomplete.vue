<template xmlns:v-slot="http://www.w3.org/1999/XSL/Transform">
    <v-autocomplete
            v-model="selectedPotion"
            :items="potions"
            filled
            chips
            color="blue-grey lighten-2"
            label="Зелье"
            item-value="name"
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
                <v-list-item-avatar @click="select(data.item), remove()">
                    <v-img :src="'http://localhost:8080/image/' + data.item.firstImg "></v-img>
                </v-list-item-avatar>
                <v-list-item-content @click="remove()  ,select(data.item)">
                    <v-list-item-title v-html="data.item.name"></v-list-item-title>
                </v-list-item-content>
            </template>
        </template>

    </v-autocomplete>
</template>

<script>
    import { mapState} from 'vuex'


    export default {
        name: "Autocomplete",
        computed: {...mapState(['potions'])},

        props: ['select'],
        data () {

            return {
                selectedPotion: ""
            }
        },
        methods: {
            remove () {
                this.selectedPotion= null;
                this.select("")
            },
        },

    }
</script>

<style scoped>

</style>