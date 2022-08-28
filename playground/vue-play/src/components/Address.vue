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
    methods: {

    },
    mounted() {
        console.log('Address component Mounted');
        if (localStorage.getItem('address')) 
            this.address = JSON.parse(localStorage.getItem('address'));
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
        <label>Street 1 <input type="text" :value="address.street_1" /></label><br />
        <label>Street 2 <input type="text" :value="address.street_2" /></label><br />
        <label>City     <input type="text" :value="address.city" size="10" /></label>
        <label>State    <input type="text" :value="address.state" size="3" /></label>
        <label>Country  <input type="text" :value="address.country" size="4"/></label>
        <label>Zip      <input type="text" :value="address.zipcode" size="10" /></label>
    </div>
</template>
