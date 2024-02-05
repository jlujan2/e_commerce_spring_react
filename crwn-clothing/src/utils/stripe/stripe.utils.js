import { loadStripe } from "@stripe/stripe-js";

export const stripePromise = loadStripe(
    "pk_test_51NqIGuC0hzb5a4HHvi0T1PRJOQVEEzYEVmUtwx2V79blgimA2XBu7Qi5VvMDdRTqrMK0GZBAPDXbvNxFsOoDEydv00fzFhcx9r"
)