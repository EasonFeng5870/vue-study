import { defineStore } from "pinia";
import { useLocalStorage } from "@vueuse/core";

export const useUsertore = defineStore ('user', {
    state: () => {
        const info = useLocalStorage('user', {login: "Guest", isAuthenticated: false, openid: ""});
        return {
            info
        }
    },
    actions: {
    }
})
