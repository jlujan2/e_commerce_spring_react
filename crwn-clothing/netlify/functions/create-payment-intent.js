require('dotenv').config();
const stripe = require('stripe')("sk_test_51NqIGuC0hzb5a4HHXShCgZaPh24GHYqjUzOSsAu8usg2X5hdVsF5T1XWr8U7cDfcnlRH3vj9E2quNbOSYsEca1Z400FOyYLiSw");

exports.handler = async (event) => {
    try {
        
        const {amount} = JSON.parse(event.body);

        const paymentIntent = await stripe.paymentIntents.create({
            amount,
            currency: "usd",
            payment_method_types: ["card"],
        });

        return {
            statusCode: 200,
            body: JSON.stringify({paymentIntent}),
        }

    } catch (error) {
        console.log({error});

        return {
            statusCode:400,
            body: JSON.stringify({error})
        }
    }
}