<script>

export default {
    data() {
        return {
            address: {
                street_1: '',
                street_2: '',
                city: '',
                state: '',
                country: '',
                zipcode: ''
            }
        }
    },
    props: {
        doWhat: String,
        passInAddr: Object
    },
    methods: {

    },
    mounted() {
        console.log('Address component Mounted');
        if (localStorage.getItem('address')) { 
            this.address = JSON.parse(localStorage.getItem('address'));
        }
    },
    watch: {
        address: {
            handler() {
                console.log('Shipping Address changed!');
                localStorage.setItem('address', JSON.stringify(this.address));
            },
            deep: true
        }
    }
}
</script>

<template>
<div>
    <div v-if="this.doWhat==='input'">
        <label>Street 1 <input type="text" v-model="this.address.street_1" size="40" /></label><br />
        <label>Street 2 <input type="text" v-model="this.address.street_2" size="40" /></label><br />
        <label>City     <input type="text" v-model="this.address.city" size="10" /></label>
        <label>State    <input type="text" v-model="this.address.state" size="3" /></label>
        <label>Country  <input type="text" v-model="this.address.country" size="4"/></label>
        <label>Zip      <input type="text" v-model="this.address.zipcode" size="10" /></label>
    </div>

    <div v-if="this.doWhat==='display'">
        {{this.passInAddr}}
        <!--label>Street 1 {{passInAddr.street_1}} </label><br />
        <label>Street 2 {{passInAddr.street_2}} </label><br />
        <label>City     {{passInAddr.city    }} </label>
        <label>State    {{passInAddr.state   }} </label>
        <label>Country  {{passInAddr.country }} </label>
        <label>Zip      {{passInAddr.zipcode }} </label-->
    </div>
</div>
</template>
