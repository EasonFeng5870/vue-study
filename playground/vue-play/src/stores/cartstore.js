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
        addLineItem(p, q) {
            this.lineitems.push({product:p, quantity:q});
        },
        reset() {
            this.lineitems.splice(0, this.lineitems.length);
        },
        removeLineItem(l) {
            this.lineitems.splice(this.lineitems.indexOf(l), 1);
        }
    }
})
