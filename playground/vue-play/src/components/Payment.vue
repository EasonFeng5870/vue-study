<script>
export default {
    data() {
        return {
            payinfo: {
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
            return !(this.payinfo.method === ''
                    || this.payinfo.account === ''
                    || this.payinfo.holdername === ''
                    || this.payinfo.expirydate === ''
                    || this.payinfo.billingzipcode === '');
        }
    },
    watch: {
        payinfo() {
            
        }
    }
}
</script>

<template>
    {{ this.payinfo }}
    <div>
        <label>Method      <input type="text" v-model="this.payinfo.method" size="3" /></label><br />
        <label>Account #   <input type="text" v-model="this.payinfo.account" size="20" /></label><br />
        <label>Holder name <input type="text" v-model="this.payinfo.holdername" size="20" /></label><br />
        <label>Expiry date <input type="text" v-model="this.payinfo.expirydate" size="3" /></label><br />
        <label>Billing Zip <input type="text" v-model="this.payinfo.billingzipcode" size="10" /></label><br />
    </div>
</template>
