<script>
import cata from './catalog.js'

export default {
    data() {
        return {
            catalog: cata,
            displaylevel2: true,
            displayproducts: true
        }
    },
    emits: ['productSelected']
}
</script>

<template>
    <h1>Products</h1>
    <div>
        <ul>
            <li v-for="c in this.catalog.productcategories" :key="c.id" @click.stop="displaylevel2=!displaylevel2">{{c.name}} | {{c.description}}
                <ul v-if="displaylevel2">
                    <li v-for="subc in c.subcategories" :key="subc.id" @click.stop="displayproducts=!displayproducts">{{subc.name}} | {{subc.description}}
                        <ul v-if="displayproducts">
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