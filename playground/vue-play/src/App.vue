<script>
import Catalog from './components/Catalog.vue';
import Product from './components/Product.vue';
import Cart from './components/Cart.vue';
import Order from './components/Order.vue';
import OrderList from './components/OrderList.vue';

let tmporder = {
    orderid: 0,
    lineitems: [],
    address: {},
    payment: {},
    tax: 0,
    total: 0
};

export default {
  name: "App",
  data() {
    return {
      user: 'Guest',
      viewwhat: "home",
      productunderview: '',
      cart: { lineitems: [], total: 0 },
      tmporder: tmporder,
      quant: 0
    };
  },
  components: {
    Catalog,
    Product,
    Cart,
    Order,
    OrderList
  },
  methods: {
    productSelected(p) {
      this.viewwhat = "product";
      this.productunderview = p;
    },
    addToCart(p, q) {
      let lineitem = {product: p, quantity: q};
      this.cart.lineitems.push(lineitem);
      this.viewwhat = 'home';
    }
  },
  watch: {
      cart: {
          handler() {
              console.log('Cart Line Items changed!');
              localStorage.setItem('cart', JSON.stringify(this.cart));
          },
          deep: true
      }
  },
  mounted() {
    console.log('App Mounted');
    if (localStorage.getItem('cart')) 
        this.cart = JSON.parse(localStorage.getItem('cart'));
/*    if (localStorage.getItem('address')) 
        this.cart = JSON.parse(localStorage.getItem('address'));
    if (localStorage.getItem('user')) 
        this.cart = JSON.parse(localStorage.getItem('user'));*/
  }
}

</script>

<template>
  <header>
    <button @click="viewwhat='home'">Home</button>
    <button @click="viewwhat='catalog'">Products</button>
    <button @click="viewwhat='cart'">Cart({{cart.lineitems.length}})</button>
    <button @click="viewwhat='orders'">Orders</button>
    <button @click="viewwhat='help'">Help</button>
    <button @click="viewwhat='login'">Login</button>
  </header>

  <main>
    <div v-if="viewwhat=='catalog'">
      <Catalog @product-selected="productSelected"></Catalog>
    </div>

    <div v-if="viewwhat=='product'">
      <Product :product="this.productunderview" @add-to-cart="addToCart"></Product>
    </div>

    <div v-if="viewwhat=='cart'">
      <Cart :cart="this.cart" @product-selected="productSelected"></Cart>
    </div>

    <div v-if="viewwhat=='orders'">
      <OrderList></OrderList>
    </div>

    <div v-if="viewwhat=='order'">
      <Order></Order>
    </div>
  </main>
</template>
