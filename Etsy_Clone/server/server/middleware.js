module.exports.IsLoggedIn =(req,res,next)=>{
    if(!req.isAuthenticated()){
       console.log("You must login first"); 
       return res.redirect('/login');
    }
    next();
};
