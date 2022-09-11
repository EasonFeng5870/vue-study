<script>
import Axios from 'axios';
import cata from './catalog.js';

export default {
    data() {
        return {
            catalog: {},
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
        },
        async getCatalog() {
            await Axios.get(this.baseUrl + 'catalog')
                .then((res) => {
                    console.log(res.data);
                    this.catalog = res.data; 
                    this.resetDisplayFlags(); 
                })
                .catch((err) => { 
                    console.log(err);
                    this.catalog = cata;  //TODO: for testing purpose, replace for production
                    this.resetDisplayFlags();
                });
        }
    },
    mounted() {
        console.log("Catalog.vue mounted");
        this.getCatalog();
    },
    emits: ['productSelected']
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
                            <li v-for="p in subc.products" :key="p.id" @click.stop="$emit('productSelected', p)">
                                <span>{{p.name}}</span>
                            </li>
                        </ul>
                    </li>
                </ul>
            </li>
        </ul>
    </div>
</template>