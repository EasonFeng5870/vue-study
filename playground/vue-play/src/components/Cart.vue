<script>
import Axios from 'axios';  // !import { Axios } won't work!
import Address from "./Address.vue";
import Payment from "./Payment.vue";

import { useCartStore } from '../stores/cartstore';

export default {
    setup() {
        const cart = useCartStore();
        return { cart };
    },
    data() {
        return {
            orderingstep: 0, /* 0:reviewItems 1:enterAddress 2:enterPayInfo 3:done */
            neworder: { id: 0, lineitems: [], shippingAddress: {}, payInfo: {} }
        }
    },
    methods: {
        removeFromCart(l) {
            this.cart.removeLineItem(l);
        },
        async placeOrder() {
            this.neworder.id = Math.trunc(Math.random()*1000000000000); /// TODO: remove for backend integration
            this.neworder.lineitems = [...this.cart.lineitems];
            this.neworder.shippingAddress = {...this.$refs.address.address};
            let pay = JSON.stringify({...this.$refs.payInfo.payInfo});
            console.log(pay)
            this.neworder.payInfo = pay;
            this.neworder.userId = 1;
        
            // call backend service to create order and get payment
            // TODO: replace hardcoded URL with configuration
            // TODO: add error handling logic
            await Axios.post(this.baseUrl + 'order/', this.neworder)
                .then( (res) => {
                  this.neworder.id = res.data.id
                })
                .catch( (err) => { console.log(err) });
            
            this.cart.reset();
        }
    },
    components: {
        Address,
        Payment
    },
    emits: ['productselected', 'orderplaced']
}
</script>

<template>
    <h1>Shopping Cart</h1>
    <ul>
        <li v-for="l in this.cart.lineitems" :key="l.product.id">
            {{l.quantity}} {{l.product.unit}} of 
            <span @click.stop="$emit('productselected', l.product)">{{l.product.name}}</span>
            priced at ${{l.product.price}} per {{l.product.unit}} in the amount of ${{l.product.price * l.quantity}}
            <button v-if="orderingstep==0" @click.stop="removeFromCart(l)">X</button>
        </li>
    </ul>
    <button v-if="orderingstep==0" :disabled="this.cart.lineitems.length <= 0" @click.stop="this.orderingstep=1">
        Check Out
    </button>

    <div v-show="orderingstep > 0">
        <h1>Ship to: </h1>
        <Address do-what="input" ref="address"></Address>
        <button v-if="orderingstep==1" @click.stop="orderingstep=0">Cancel</button>
        <button v-if="orderingstep==1" @click.stop="orderingstep=2">Continue</button>
    </div>
    
    <div v-show="orderingstep > 1">
        <h1>Pay with: </h1>
        <Payment ref="payInfo"></Payment>
        <button v-if="orderingstep==2" @click.stop="orderingstep=1">Cancel</button>
        <button v-if="orderingstep==2" :disabled="!this.$refs.payInfo.isValid" @click.stop="placeOrder();orderingstep=3;$emit('orderplaced', this.neworder)">
            Place Order
        </button>
    </div>
</template>
