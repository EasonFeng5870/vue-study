import { defineStore } from "pinia";
import { useLocalStorage } from "@vueuse/core";

export const useCartStore = defineStore ('cart', {
    state: () => {
        const lis = useLocalStorage('lineitems', []);
        return {
            lineitems: lis,
            total: 0
        }
    },
    actions: {
        addLineItem(p, q) {
            // TODO: merge with existing line item
            // calculate subtotal = price * quantity
            let subtotal = Math.trunc(p.price * q * 100) / 100;
            // TODO: calculate sales tax using tax rate based on prodcut's taxcode and shipping address
            // TODO: estimate shipping cost (here or order?)
            this.lineitems.push({product:p, quantity:q, subtotal: subtotal});
        },
        reset() {
            this.lineitems.splice(0, this.lineitems.length);
        },
        removeLineItem(l) {
            this.lineitems.splice(this.lineitems.indexOf(l), 1);
        }
    }
})
