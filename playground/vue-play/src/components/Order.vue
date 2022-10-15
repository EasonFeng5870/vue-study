<script>
import Address from "./Address.vue";
import Payment from "./Payment.vue";

export default {
    props: {
        order: Object
        /*
            id: '',
            lineitems: [],
            shippingAddress: {},
            payInfo: {}
        */
    },
    components: {
        Address,
        Payment
    }
}
</script>

<template>
    <h1>Order #{{this.order.id}}</h1>
    <Address doWhat="display" :passInAddr="this.order.shippingAddress"></Address>
    <ul>
        <li v-for="l in this.order.lineitems">
            {{l.quantity}} {{l.product.unit}} of {{l.product.name}}
        </li>
    </ul>
</template>