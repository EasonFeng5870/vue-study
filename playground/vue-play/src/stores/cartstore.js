import { defineStore } from "pinia";
import { useLocalStorage } from "@vueuse/core";

export const useCartStore = defineStore ('cart', {
    state: () => {
        return {
            user: useLocalStorage('user', {login: 'Guest'}),
            cart: useLocalStorage('cart', {lineitems: [], total: 0});
        }
    },
    actions: {
        addToCart(p, q) {
            this.cart.lineitems.push({product:p, quantity:q});
        },
        removeFromCart(l) {
            this.cart.lineitems.splice(this.cart.lineitems.indexOf(l), 1);
        }
    }
})
