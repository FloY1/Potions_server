<template xmlns:v-slot="http://www.w3.org/1999/XSL/Transform">

    <v-card

            class="mx-auto my-3 pa-6"
            width="500px"
    >
        <template>
            <v-container fluid>
                <v-form class="text-center">

                    <span>Новое зелье</span>
                    <v-row class="py-0 ma-0">

                        <v-col class="py-0 ma-0"  cols="8">
                            <v-text-field label="Название"
                                          v-model="potion.name"/>
                        </v-col>
                        <v-col class="py-0 ma-0"  cols="4">
                            <v-file-input multiple label="File"
                                          @change="onFileSelected"
                            />
                        </v-col>



                        <v-row class="py-0 mx-3 my-0 ">

                            <v-col cols="3">
                                <v-text-field
                                        label="значение"
                                        v-model="potion.p1"
                                ></v-text-field>
                            </v-col>

                            <v-col cols="3">

                                <v-text-field
                                        label="значение"
                                        v-model="potion.p2"
                                ></v-text-field>
                            </v-col>

                            <v-col cols="3">

                                <v-text-field
                                        label="значение"
                                        v-model="potion.p3"
                                ></v-text-field>
                            </v-col>

                            <v-col cols="3">

                                <v-text-field
                                        label="значение"
                                        v-model="potion.p4"
                                ></v-text-field>
                            </v-col>



                        </v-row>
                        <v-col cols="12">
                            <v-progress-linear
                                    color="light-blue"
                                    :value ="(potion.p1 / 10)*100"/>
                        </v-col>

                        <v-col cols="12">
                            <v-progress-linear
                                    color="light-green darken-4"
                                    :value ="(potion.p2 / 10)*100"/>
                        </v-col>

                        <v-col cols="12">
                            <v-progress-linear
                                    color="lime"
                                    :value ="(potion.p3 / 10)*100"/>
                        </v-col>

                        <v-col cols="12">
                            <v-progress-linear
                                    color="deep-orange"
                                    striped
                                    :value ="(potion.p4 / 10)*100"/>

                        </v-col>


                        <v-col  cols="12">
                            <v-textarea
                                    solo
                                    name="input-7-4"
                                    label="Описание"
                                    v-model="potion.description"
                            ></v-textarea>
                        </v-col>

                        <v-col cols="6">
                            <v-btn text
                                   large
                                   color="primary"
                                    @click="saveButton"
                            >
                                Добавить
                            </v-btn>
                        </v-col>

                        <v-col cols="6">
                            <v-btn text large color="error">Отменить</v-btn>

                        </v-col>



                    </v-row>
                </v-form>
            </v-container>
        </template>
    </v-card>




</template>

<script>
    import { mapActions } from 'vuex'


    export default {
        data () {
            return {
                potion: {
                    name:"",
                    description:"",
                       p1: 1,
                       p2: 1,
                       p3: 1,
                       p4: 1,
                },
                selectedFiles: null
            }
        },
        methods:{
            ...mapActions(['addPotion']),
            saveButton(){
                const data = {
                    potion: this.potion,
                    file: this.selectedFile
                }
                this.addPotion(data)
            },
            onFileSelected(event){
                this.selectedFile = event
            },
        }

    }
</script>

<style scoped>

</style>