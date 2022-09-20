import Axios from 'axios';
import { defineStore } from "pinia";
import { useSessionStorage } from "@vueuse/core";

import cata from '../components/catalog.js';  //TODO: testing data, remove for production

export const useCatalogStore = defineStore('catalog', {
    state: () => {
        const catalog = useSessionStorage('catalog', {});
        return { catalog, hasLoaded: false };
    },
    getters: {
        getProductById(pid) {
            products = [];
            this.catalog.productcategories.forEach((pc) => {
                pc.subcategories.forEach((subc) => {
                    products += subc.products.filter((p) => { p.id == pid });
                })
            })
            return products[0];
        }
    },
    actions: {
        loadFromWeb() {
            if (this.hasLoaded) return;

            Axios.get(this.baseUrl + 'catalog')
                .then((res) => {
                    console.log(res.data);
                    this.catalog = res.data;
                    this.hasLoaded = true;
                })
                .catch((err) => {
                    console.log(err);
                    this.loadFromFile(); //TODO: refactor for production
                });
        },
        loadFromFile() {
            this.catalog = cata;
            this.hasLoaded = true;
        }
    }
})
