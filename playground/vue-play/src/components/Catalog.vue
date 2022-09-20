<script>
import Axios from 'axios';
import cata from './catalog.js';  //TODO: testing data, remove for production

import { useCatalogStore } from '../stores/catalogstore';

export default {
    setup() {
        const store = useCatalogStore();
        console.log(store.catalog);
        return { store };
    },
    data() {
        return {
            catalog: this.store.catalog,
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
    mounted() {
        console.log("Catalog.vue mounted");
        this.store.loadFromWeb();
        this.catalog = this.store.catalog;
        this.resetDisplayFlags();
    },
    emits: ['productselected']
}
</script>

<template>
    <h1>Products</h1>
    <div>
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
</template>