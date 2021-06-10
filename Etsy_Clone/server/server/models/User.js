const mongoose =require('mongoose');
const passportLocalMongoose =require('passport-local-mongoose');
const Item=require('./Items');

const userSchema=new mongoose.Schema({
    email:{
        type:String,
        required:true,
        unique:true,
    },
    cart:[
        {
          type:mongoose.Schema.Types.ObjectId,
          ref:'Item',
        }
    ]
});
userSchema.plugin(passportLocalMongoose);
module.exports=mongoose.model('User',userSchema);