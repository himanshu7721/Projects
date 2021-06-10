const express= require('express');
const mongoose = require('mongoose');
const app=express();
const session=require('express-session');
const passport =require('passport');
const seedDB=require('./seed');
const LocalStrategy=require('passport-local');
const homeRoutes= require('./routes/Home/home');
const prodRoutes=require('./routes/Products/product');
const authRoutes=require('./routes/Auth/Auth');
const User =require('./models/User');
const reviewRoutes=require('./routes/Reviews/Reviews');
mongoose.connect('mongodb://localhost:27017/ETSY', {useNewUrlParser: true, useUnifiedTopology: true, useFindAndModify:false, useCreateIndex:true})
.then(()=>{
    console.log("Database Connected");
})
.catch(err =>{
    console.log(err);
    console.log("Connection failed");
});

//seedDB();
app.use(express.json());
app.use(session({
    secret:'this is a secret',
    resave:false,
    saveUninitialized:true
}));
app.use(passport.initialize());
app.use(passport.session()); 
app.use((req,res,next)=>{
    res.locals.currentUser=req.user;
    next();
});
passport.use(new LocalStrategy(User.authenticate()));
passport.serializeUser(User.serializeUser());
passport.deserializeUser(User.deserializeUser());
app.use(homeRoutes);
app.use(prodRoutes);
app.use(authRoutes);
app.use(reviewRoutes);
app.listen(8000 , ()=> {
    console.log("Server Running on Port 8000");
})