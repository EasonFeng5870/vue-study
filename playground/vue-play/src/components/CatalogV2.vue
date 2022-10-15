<script>
import { useCatalogStore } from '../stores/catalogstore';
import Axios from "axios";

export default {
    setup() {
        /*const store = useCatalogStore();
        return { store };*/
    },
    data() {
        return {
            catalog: {},
            hasLoaded:  false,
            displaylevel2: {},
            displayproducts: {}
        }
    },
    methods: {
        resetDisplayFlags() {
            this.displaylevel2 = {};
            this.displayproducts = {};
            this.catalog.productcategories.forEach(pc => {
                this.displaylevel2[pc.id] = false;
                pc.subcategories.forEach(subc => {
                    this.displayproducts[pc.id + '.' + subc.id] = false;
                });
            });
        }
    },
    /*watch: {
        store: {
            handler() {
                this.catalog = {};
                this.resetDisplayFlags();
            },
            deep: true
        }
    },*/
    mounted() {
        console.log("Catalog.vue mounted");
        Axios.get(this.baseUrl + "catalog")
            .then((res) => {
                console.log("current user orders:");
                this.catalog = res.data;
                this.hasLoaded = true
            })
            .catch((err) => {
                console.log(err);
            });
        console.log("Catalog.vue mounted end.")
    },
    emits: ['productselected']
}
</script>

<template>
    <h1>Products of {{this.catalog.name}}</h1>
    <p v-if="!this.hasLoaded">Loading...</p>
    <div v-if="this.hasLoaded">
        <ul>
            <li v-for="c in this.catalog.productcategories" :key="c.id"
                     @click.stop="displaylevel2[c.id]=!displaylevel2[c.id]">
                {{c.name}} | {{c.description}}
                <ul v-if="displaylevel2[c.id]">
                    <li v-for="subc in c.subcategories" :key="subc.id" 
                            @click.stop="displayproducts[c.id + '.' + subc.id]=!displayproducts[c.id + '.' + subc.id]">
                        {{subc.name}} | {{subc.description}}
                        <ul v-if="displayproducts[c.id + '.' + subc.id]">
                            <li v-for="p in subc.products" :key="p.id" @click.stop="$emit('productselected', p)">
                                <span>{{p.name}}</span>
                            </li>
                        </ul>
                    </li>
                </ul>
            </li>
        </ul>
    </div>
  ---
    <p>Debug[this.catalog]: {{this.catalog}}</p>
</template>