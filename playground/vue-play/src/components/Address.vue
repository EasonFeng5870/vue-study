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
    methods:{

    }
}
</script>

<template>
    <div>
        <label>Street 1 <input type="text" v-model="address.street_1" /></label><br />
        <label>Street 2 <input type="text" v-model="address.street_2" /></label><br />
        <label>City     <input type="text" v-model="address.city" size="10" /></label>
        <label>State    <input type="text" v-model="address.state" size="3" /></label>
        <label>Country  <input type="text" v-model="address.country" size="4"/></label>
        <label>Zip      <input type="text" v-model="address.zipcode" size="10" /></label>
    </div>
</template>