import { defineStore } from "pinia";
import { useLocalStorage } from "@vueuse/core";

export const useCartStore = defineStore ('cart', {
    state: () => {
        const lis = useLocalStorage('lineitems', []);
        return {
            //user: useLocalStorage('user', {login: 'Guest'}),
            lineitems: lis,
            total: 0
        }
    },
    actions: {
        addToCart(p, q) {
            this.lineitems.push({product:p, quantity:q});
        },
        removeFromCart(l) {
            this.lineitems.splice(this.lineitems.indexOf(l), 1);
        }
    }
})
