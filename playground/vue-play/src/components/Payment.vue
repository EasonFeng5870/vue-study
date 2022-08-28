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
    methods: {

    }
}
</script>

<template>
    <div>
        <label>Method      <input type="text" :value="payinfo.method" size="3" /></label><br />
        <label>Account #   <input type="text" :value="payinfo.account" size="20" /></label><br />
        <label>Holder name <input type="text" :value="payinfo.holdername" size="20" /></label><br />
        <label>Expiry date <input type="text" :value="payinfo.expirydate" size="3" /></label><br />
        <label>Billing Zip <input type="text" :value="payinfo.billingzipcode" size="10" /></label><br />
    </div>
</template>
