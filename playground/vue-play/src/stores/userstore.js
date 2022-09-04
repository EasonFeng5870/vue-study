import { defineStore } from "pinia";
import { useLocalStorage } from "@vueuse/core";

export const useUsertore = defineStore ('user', {
    state: () => {
        return {
            info: useLocalStorage('user', {id: 0, login: "Guest", isAuthenticated: false, openid: ""})
        }
    },
    actions: {
        reset() {
            this.info = {id: 0, login: "Guest", isAuthenticated: false, openid: ""};
        }
    }
})
