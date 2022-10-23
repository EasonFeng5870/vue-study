<script>
import Axios from 'axios';
import ordrs from "./orders.js";

import { useUsertore } from '../stores/userstore';

export default {
    setup() {
        const user = useUsertore();
        return { user };
    },
    data() {
        return {
            orders:     [],
            hasLoaded:  false,
            neworder: { id: 0, lineitems: [], shippingAddress: {}, payInfo: {} }
        }
    },
    mounted() {
        console.log("OrderList mounted");
        // get user's order list from backend service
        let tempUserId = this.user.info.id;
        //temp value for validate user
        tempUserId = 1;
        Axios.get(this.baseUrl + "order/" + tempUserId)
            .then((res) => { 
                console.log("current user orders:");
                console.log(res.data);
                this.orders = res.data;
                this.hasLoaded = true;
             })
            .catch((err) => { 
                console.log(err); 
                this.orders = ordrs;
                this.hasLoaded = true; //TODO: change for production
            });
    },
    methods: {
        transOrder(o) {
            this.neworder.id = o.id;
            this.neworder.lineitems = o.lineItemVos;
            this.neworder.shippingAddress = o.shippingAddress;
            this.neworder.payInfo = o.payInfo;
            console.log(this.neworder.lineitems);
            this.$emit('orderselected', this.neworder);
            console.log(2);
        }
    },
    emits: ['orderselected']
}
</script>

<template>
    <h1>My Orders</h1>
    <p v-if="!this.hasLoaded">Loading...</p>
    <div v-if="this.hasLoaded">
      <table border="1">
        <tr>
          <th>id</th>
          <th>name</th>
          <th>quantity</th>
          <th>create time</th>
        </tr>
        <tr v-for="c in this.orders" @click.stop="transOrder(c);this.$emit('orderselected', this.neworder)">
          <td>{{c.id}}</td>
          <td>{{c.lineItemVos[0].product.name}}</td>
          <td>{{c.lineItemVos[0].quantity}}</td>
          <td>{{c.createTime}}</td>
        </tr>
      </table>
    </div>
</template>