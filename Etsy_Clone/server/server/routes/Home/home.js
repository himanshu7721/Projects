const express=require('express');
const router =express.Router();
const Item=require('../../models/Items');

router.get('/products',async(req,res)=>{
    //console.log("got request");
    const items=await Item.find({});
    res.send(items);
})
router.get('/products/page',async(req,res)=>{
    //console.log("got request");
    const items=await Item.find({});
    res.send(items);
})

module.exports=router;