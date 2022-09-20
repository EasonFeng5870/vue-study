<script>
import { useCatalogStore } from '../stores/catalogstore';

export default {
    setup() {
        const store = useCatalogStore();
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
    watch: {
        store: {
            handler() {
                this.catalog = this.store.catalog;
                this.resetDisplayFlags();
            },
            deep: true
        }
    },
    mounted() {
        console.log("Catalog.vue mounted");
        this.store.loadFromWeb(this.baseUrl + 'catalog');
    },
    emits: ['productselected']
}
</script>

<template>
    <h1>Products</h1>
    <p>{{this.store}}</p>
    <p v-if="!this.store.hasLoaded">Loading...</p>
    <div v-if="this.store.hasLoaded">
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