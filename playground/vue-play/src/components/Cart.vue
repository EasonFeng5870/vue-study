<script>
export default {
    data() {
        return {
            lineitems: this.cart.lineitems
        }
    },
    props: {
        cart: Object
    },
    methods: {
        removeFromCart(l) {
            this.cart.lineitems.splice(this.cart.lineitems.indexOf(l), 1);
        }
    },
    emits: ['productSelected']
}
</script>

<template>
        <h1>Shopping Cart</h1>
        <p>{{cart}}</p>
        <ul>
            <li v-for="l in this.cart.lineitems" :key="l.product.id">
                {{l.quantity}} {{l.product.unit}} of 
                <span @click.stop="$emits('productSelected', l.product)">{{l.product.name}}</span>
                 priced at ${{l.product.price}} per {{l.product.unit}} in the amount of ${{l.product.price * l.quantity}}
                <button @click.stop="removeFromCart(l)">X</button>
            </li>
        </ul>
        <button :disabled="lineitems.length <= 0">Check Out</button>

</template>