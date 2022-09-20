<script>
import Home from './components/Home.vue';
import Catalog from './components/Catalog.vue';
import Product from './components/Product.vue';
import Cart from './components/Cart.vue';
import Order from './components/Order.vue';
import OrderList from './components/OrderList.vue';
import Help from './components/Help.vue';
import Login from './components/Login.vue';
import NotFound from './components/NotFound.vue';

import { useCartStore } from './stores/cartstore';
import { useUsertore } from './stores/userstore';

const routes = {
    'home':     Home     ,
    'catalog':  Catalog  ,
    'product':  Product  ,
    'cart':     Cart     ,
    'orders':   OrderList,
    'order':    Order    ,
    'help':     Help     ,
    'login':    Login    ,
    'notfound': NotFound ,
};

export default {
    name: "App",
    setup() {
        const cart = useCartStore();
        const user = useUsertore();
        return { cart, user };
    },
    data() {
        return {
            currentPath: window.location.pathname,
            viewwhat: 'home',
            productunderview: '',
            tmporder: {}
        };
    },
    computed: {
        currentView() {
            return routes[this.viewwhat];
        },
        currentProps() {
            switch (this.viewwhat) {
                case 'order': return { order: this.tmporder };
                case 'product': return { product: this.productunderview };
            }
            return {};
        },
        currentEvent() {
            switch (this.viewwhat) {
                case 'catalog': return { productselected: this.productSelected };
                case 'product': return { addtocart: this.addToCart };
                case 'cart': return { productselected: this.productSelected, orderplaced: this.orderPlaced }
            }
            return {};
        }
    },
    mounted() {
        if (this.currentPath == '/') {
            this.viewwhat = 'home';
        } else {
            let s = this.currentPath.split('/');
            console.log(s);
            switch (s[1]) {
                case 'product': loadProduct(s[2]); break;
                case 'order': loadOrder(s[2]); break;
            }
            this.viewwhat = (routes[s[1]] ? s[1] : 'notfound');
        }
    },
    methods: {
        logout() {
            this.user.reset();
        },
        productSelected(p) {
            this.productunderview = p;
            this.viewwhat = "product";
        },
        orderPlaced(o) {
            console.log('Order placed ' + JSON.stringify(o));
            this.tmporder = o;
            this.viewwhat = "order";
        },
        addToCart(p, q) {
            this.cart.addLineItem(p, q);
            this.viewwhat = 'home';
        }
    }
}
</script>

<template>
    <header class = "w3-container w3-blue">
        <p>Dear {{ user.info.login }}, welcome back! You're visiting {{this.currentPath}} </p>
        <button @click="viewwhat = 'home'">Home</button>
        <button @click="viewwhat = 'catalog'">Products</button>
        <button @click="viewwhat = 'cart'">Cart({{ this.cart.lineitems.length }})</button>
        <button @click="viewwhat = 'orders'">Orders</button>
        <button @click="viewwhat = 'help'">Help</button>
        <button v-if="user.info.login == 'Guest'" @click="viewwhat = 'login'; user.info.login = 'QQ'">Log in</button>
        <button v-if="user.info.login != 'Guest'" @click="viewwhat = 'home'; logout()">Log out</button>
    </header>

    <main>
        <p> Debug: {{ this.cart }}</p>
        <component :is="currentView" v-bind="currentProps" v-on=currentEvent></component>
    </main>
</template>
