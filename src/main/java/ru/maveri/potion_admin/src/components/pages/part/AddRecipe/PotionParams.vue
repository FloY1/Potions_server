<template>
    <v-card
            class="mx-auto my-2 pa-6"
            width="500px"

    >

        <v-card-actions>

            <v-row>
                <v-col cols="3">
                    <v-progress-circular
                            :size="size"
                            color="yellow"
                            :value="potion.p1*10"
                            :width="width"
                    >{{potion.p1}}</v-progress-circular>
                </v-col>
                <v-col cols="3">
                    <v-progress-circular
                            :size="size"
                            color="red"
                            :value="potion.p2*10"
                            :width="width"
                    >{{potion.p2}}</v-progress-circular>
                </v-col>
                <v-col cols="3">
                    <v-progress-circular
                            :size="size"
                            color="orange"
                            :value="potion.p3*10"
                            :width="width"
                    >{{potion.p3}}</v-progress-circular>
                </v-col>
                <v-col cols="3">
                    <v-progress-circular
                            :size="size"
                            color="pink"
                            :value="potion.p4*10"
                            :width="width"
                    >{{potion.p4}}</v-progress-circular>
                </v-col>
            </v-row>
        </v-card-actions>
        <v-card-text>
            {{ potion.description }}
        </v-card-text>


    </v-card>
</template>

<script>
    export default {
        name: "potion-params",
        props:['potion'],
        data: () => ({
            rotate: 20,
            size: 42,
            value: 20,
            width: 4,
        }),
    }
</script>

<style scoped>

</style>