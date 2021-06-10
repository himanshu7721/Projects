const mongoose = require('mongoose');
const Review = require('./Reviews');

const ItemSchema =new mongoose.Schema({
    title:{
        type:String,
        required:true
    },
    img: {
        type:String
    },
    price:{
        type:Number,
        min:0
    },
    text:{
        type:String,
        minLength:10
    },
    rating:{
        type:Number,
    },
    reviews: [
        {
          type: mongoose.Schema.Types.ObjectId,  
          ref:'Review',
        },
      ],

})

module.exports=mongoose.model('Item',ItemSchema);