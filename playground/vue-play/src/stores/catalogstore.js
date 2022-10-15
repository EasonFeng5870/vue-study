import Axios from 'axios';
import { defineStore } from "pinia";

import cata from '../components/catalog.js';  //TODO: testing data, remove for production

export const useCatalogStore = defineStore('catalog', {
    state: () => {
        return { catalog: cata, hasLoaded: false };
    },
    getters: {
        getProductById(pid) {
            let products = [];
            this.catalog.productcategories.forEach((pc) => {
                pc.subcategories.forEach((subc) => {
                    products += subc.products.filter((p) => { p.id == pid });
                })
            })
            return products[0];
        }
    },
    actions: {
        loadFromWeb(url) {
            console.log("this.hasLoaded = " + this.hasLoaded)
            if (this.hasLoaded) return;

            Axios.get(url)
                .then((res) => {
                    console.log(res.data);
                    this.catalog = {...res.data};
                    this.hasLoaded = true;
                })
                .catch((err) => {
                    console.log(err);
                    console.log("web get failed, load from file.")
                    this.loadFromFile(); //TODO: refactor for production
                });
        },
        loadFromFile() {
            this.catalog = cata;
            this.hasLoaded = true;
        }
    }
})
