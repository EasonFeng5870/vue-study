import { createApp } from 'vue'
import { createPinia } from 'pinia'
import { useCartStore } from './stores/cartstore'
import App from './App.vue'

import './assets/main.css'

const pinia = createPinia()
const app = createApp(App)
app.config.globalProperties ={
    baseUrl: "http://localhost:8080/" 
}
app.use(pinia)
app.mount('#app')
