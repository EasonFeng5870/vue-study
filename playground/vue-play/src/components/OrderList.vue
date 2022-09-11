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
        let tempUserId = this.user.info.id;
        //temp value for validate user
        tempUserId = 1;
        Axios.get(this.baseUrl + "order/" + tempUserId)
            .then((res) => { 
                console.log("current user orders:");
                console.log(res.data);
                this.orders = res.data;
             })
            .catch((err) => { console.log(err); this.orders = ordrs; });
    }
}
</script>

<template>
    <h1>My Orders</h1>
    {{ this.orders }}
</template>