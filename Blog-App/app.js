const express = require("express");
const mongoose = require("mongoose");
const blogs = require("./routes/blogs");
const admin = require("./routes/admin");
const user = require("./routes/user");
require("dotenv").config();
const finduser = require('./middleware/finduser');
const app = express();
mongoose
    .connect("mongodb+srv://db:hsss@cluster0.tg07j.mongodb.net/myFirstDatabase?retryWrites=true&w=majority", {
        useNewUrlParser: true,
        useUnifiedTopology: true,
        useFindAndModify: false,
        useCreateIndex: true,
    })
    .then(() => console.log("mongo is connected"))
    .catch((e) => {
        console.log(e);
        return process.exit(1);
    });

app.set("view engine", "ejs");

require('./middleware/setup')(app);

app.use("/blogs", blogs);
app.use("/admin", admin, admin);
app.use("/user", user);

app.use((_req, res) => {
    res.redirect("/blogs");
});

const port = process.env.PORT || 8080;
app.listen(port, () => console.log(`currently on ${port} port`));