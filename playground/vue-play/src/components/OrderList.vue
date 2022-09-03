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
            orders:[]
        }
    },
    mounted() {
        console.log("OrderList mounted");
        // get user's order list from backend service
        Axios.get("http://localhost:8080/u/" + this.user.info.id + "/order")
            .then((res) => { this.orders = res.data; })
            .catch((err) => { console.log(err); this.orders = ordrs; });
    }
}
</script>

<template>
    <h1>My Orders</h1>
    {{ this.orders }}
</template>