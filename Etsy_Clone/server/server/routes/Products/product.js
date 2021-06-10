const express=require('express');
const router =express.Router();
const stripe= require("stripe")("sk_test_51IzSG5SECSps0aUr0n4cPA3aeatHo7yf2NlbyZyn3bEHuN9vXnfem6nodNkX6pRomV5DPSVZauM5EYs06zLD0h1K00Ccs9gubH");
const Item=require('../../models/Items');
const {IsLoggedIn} =require('../../middleware');
router.get('/products/:id',IsLoggedIn,async (req,res)=>{
    const product=await Item.findById(req.params.id);
    res.send(product);
});
router.post('/products/new',IsLoggedIn,async (req,res)=>{
    const product=await Item.create(req.body);
    res.send(product);
})



router.post('/checkout', IsLoggedIn,async (req,res)=>
{
    console.log("Request:",req.body);

    let error;
    let status;
    try{
        const {product,token}=req.body;

        const customer=await stripe.customer.create({
            email:token.email,
            source:token.id
        });
        const charge=await stripe.charges.create({
            amount:product.price,
            currency:"usd",
            customer:customer.id,
            receipt_email:token.email,
            description:'Purchased the ${product.name}',
            shipping:{
                name:token.card.name,
                address:{
                    line1:token.card.address_line1,
                    city:token.card.address_city,
                    postal_code:token.card.address_zip
                }
            }

        });
        console.log("Charge:",{charge});
        status="success";
    }
    catch(error){
        console.error("Error:" ,error);
        status="failure";
    }

    res.json({error,status});

});



router.delete('/products/:id', IsLoggedIn,async (req,res)=>{
    const product= await Item.findByIdAndDelete(req.params.id);
   res.send(product);
})
router.get('/products/:id/edit',IsLoggedIn,async (req,res)=>{
    const product=await Item.findById(req.params.id);
    res.send(product);
})
router.patch('/products/:id',IsLoggedIn,async (req,res)=>{
    const product= await Item.findByIdAndUpdate(req.params.id,req.body);
    res.send(product);
});

module.exports=router;