const express = require("express");
const passport = require("passport");
const { findOne } = require("../../models/User");
const router = express.Router();
const User = require("../../models/User");

router.post('/signup', async (req,res)=>{
    const user = {
        username: req.body.username,     
        email: req.body.email,
      };
      console.log(req.body);
      const newuser = await User.register(user, req.body.password);
      res.send(newuser);
})

router.post('/login', passport.authenticate('local', { successRedirect: '/',
failureRedirect: '/login' }),
    (req, res) => {
     console.log(req.user);
      console.log("Login Successfully");
      res.send("OK");
    }
  );


module.exports = router;
