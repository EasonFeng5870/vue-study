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
    {{ payinfo }}
    <div>
        <label>Method      <input type="text" v-model="payinfo.method" size="3" /></label><br />
        <label>Account #   <input type="text" v-model="payinfo.account" size="20" /></label><br />
        <label>Holder name <input type="text" v-model="payinfo.holdername" size="20" /></label><br />
        <label>Expiry date <input type="text" v-model="payinfo.expirydate" size="3" /></label><br />
        <label>Billing Zip <input type="text" v-model="payinfo.billingzipcode" size="10" /></label><br />
    </div>
</template>
