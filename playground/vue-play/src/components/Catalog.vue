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
    mounted() {
        console.log("Catalog.vue mounted");
        Axios.get(this.baseUrl + 'catalog')
            .then((res) => { this.catalog = res.data; })
            .catch((err) => { console.log(err); this.catalog = cata; })
            .then ( () => {
                console.log(this.catalog);
                this.catalog.productcategories.forEach( pc => {
                     this.displaylevel2[pc.id] = false;
                     pc.subcategories.forEach( subc => {
                        this.displayproducts[pc.id + '.' + subc.id] = false;
                     });
                } );
            });
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