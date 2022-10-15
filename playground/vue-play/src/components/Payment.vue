<script>
export default {
    data() {
        return {
            payInfo: {
                method: '',
                account: '',
                holdername: '',
                expirydate: '',
                billingzipcode: ''
            }
        }
    },
    computed: {
        isValid() {
            return !(this.payInfo.method === ''
                    || this.payInfo.account === ''
                    || this.payInfo.holdername === ''
                    || this.payInfo.expirydate === ''
                    || this.payInfo.billingzipcode === '');
        }
    },
    watch: {
        payInfo() {
            
        }
    }
}
</script>

<template>
    {{ this.payInfo }}
    <div>
        <label>Method      <input type="text" v-model="this.payInfo.method" size="3" /></label><br />
        <label>Account #   <input type="text" v-model="this.payInfo.account" size="20" /></label><br />
        <label>Holder name <input type="text" v-model="this.payInfo.holdername" size="20" /></label><br />
        <label>Expiry date <input type="text" v-model="this.payInfo.expirydate" size="3" /></label><br />
        <label>Billing Zip <input type="text" v-model="this.payInfo.billingzipcode" size="10" /></label><br />
    </div>
</template>
