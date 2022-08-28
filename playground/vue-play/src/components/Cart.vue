<script>
import Address from "./Address.vue";
import Payment from "./Payment.vue";

export default {
    data() {
        return {
            lineitems: this.cart.lineitems,
            orderingstep: 0 /* 0:reviewItems 1:enterAddress 2:enterPayInfo 3:submitOrder 4:done */
        }
    },
    props: {
        cart: Object
    },
    methods: {
        removeFromCart(l) {
            this.cart.lineitems.splice(this.cart.lineitems.indexOf(l), 1);
        },
        placeOrder() {

        }
    },
    components: {
        Address,
        Payment
    },
    emits: ['productSelected']
}
</script>

<template>
    <h1>Shopping Cart</h1>
    <ul>
        <li v-for="l in this.cart.lineitems" :key="l.product.id">
            {{l.quantity}} {{l.product.unit}} of 
            <span @click.stop="$emit('productSelected', l.product)">{{l.product.name}}</span>
            priced at ${{l.product.price}} per {{l.product.unit}} in the amount of ${{l.product.price * l.quantity}}
            <button v-if="orderingstep==0" @click.stop="removeFromCart(l)">X</button>
        </li>
    </ul>
    <button v-if="orderingstep==0" :disabled="lineitems.length <= 0" @click.stop="this.orderingstep=1">
        Check Out
    </button>

    <div v-if="orderingstep > 0">
        <h1>Shipping Address</h1>
        <Address ref="address"></Address>
        <button v-if="orderingstep==1" @click.stop="orderingstep=0">Cancel</button>
        <button v-if="orderingstep==1" @click.stop="orderingstep=2">Continue</button>
    </div>
    
    <div v-if="orderingstep > 1">
        <h1>Payment</h1>
        <Payment ref="payinfo"></Payment>
        <button v-if="orderingstep==2" @click.stop="orderingstep=1">Cancel</button>
        <button v-if="orderingstep==2" @click.stop="orderingstep=3">Continue</button>
    </div>

    <div v-if="orderingstep > 2">
        <button v-if="orderingstep==3" @click.stop="placeOrder">Place Order</button>
    </div>
</template>
