<template>
<div id="app>
    <div>
        <p>{{ catalog.name }}</p>
        <ul>
            <li v-for="c in categories" :key="c.id">{{c.name}} | {{c.description}}
                <ul>
                    <li v-for="subc in c.subcategories" :key="subc.id">{{subc.name}} | {{subc.description}}
                        <ul>
                            <li v-for="p in subc.products" :key="p.id" @click="product = p; quantity = ''" @mouseenter="">
                                <span>{{p.name}}</span>
                            </li>
                        </ul>
                    </li>
                </ul>
            </li>
        </ul>
    </div>

    <div v-if="product !== ''">
        {{product.name}} {{product.price}} per {{product.unit}}
        <input type="number" min="0" v-model="quantity" />
        <button :disabled="quantity <= 0" @click="addToCart(product.id, quantity, product.unit, product.price)">Add {{quantity}} {{product.unit}} to cart</button>
    </div>

    <div v-if="cart.lineitems.length > 0">
        <ul>
            <li v-for="l in cart.lineitems" :key="l.id">
                Buy {{l.quantity}} {{l.unit}} of {{l.id}} priced at ${{l.price}} per {{l.unit}} in the amount of ${{l.amount}}
            </li>
        </ul>
        Total: ${{carttotal}}
        <button>Place Order</button>
    </div>
</div>
</template>

<script src="./catalog.js"></script>
<script>
    let cart = {
        lineitems: [],
        total: 0
    };
    let order = {
        lineitems: [],
        address: null,
        payment: null,
        tax: 0,
        total: 0
    };
</script>
<script>
    import Product from './Product.vue'

    let app = new Vue({
        el : '#app',
        data: {
            catalog: catalog,
            cart: cart,
            tmporder: order,
            categories: catalog.productcategories,
            quantity: '',
            product: ''
            //product: catalog.productcategories[0].subcategories[0].products[0]
        },
        computed: {
          carttotal() {
            let t = 0;
            cart.lineitems.forEach(function (l) { t += l.price * l.quantity} );
            cart.total = t;
            return t;
          }
        },
        methods: {
            addToCart(pid, quant, unit, price, amount) {
                let lineitem = {id: pid, quantity: quant, unit: unit, price: price, amount: quant * price};
                cart.lineitems.push(lineitem);
            }
        },
        components: {
            Product
        }
    });

</script>
