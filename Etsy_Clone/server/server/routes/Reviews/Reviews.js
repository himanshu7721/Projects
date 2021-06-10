const Express=require('express');
const router=Express.Router();
const Product=require('../../models/Items');
const Reviews=require('../../models/Reviews');
const {IsLoggedIn} =require( '../../middleware');

router.get('/products/:id/review',IsLoggedIn,async (req,res)=>{
    const product=await Product.findById(req.params.id);
    console.log(product.reviews);
    res.send(product.reviews);
})
router.post('/products/:id/review',IsLoggedIn, async(req,res)=>{
     console.log(req.body);
     const product=await Product.findById(req.params.id);
     const{rating,review}=req.body;
     const {username}=req.user;   
     const rev=new Reviews({rating:rating,body:review,username:username});
     product.reviews.push(rev);
     const ans=[{rating},{review},{username}];
     res.send(ans);
     await rev.save();
     await product.save();
     
 });


 module.exports= router;
 