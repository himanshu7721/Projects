const mongoose = require('mongoose');
const Item =require('./models/Items');




const arr = [
    {
        title:'Cat Face Mask - Black Cat Mouth Cover - Cute Nose Mask Feline Kitten Nose Cover - Anti Pollution Dust Mask Kawaii Cosplay Harajuku Mask',
        img:'https://i.etsystatic.com/5116279/c/761/605/3/94/il/c3131c/2725791245/il_340x270.2725791245_jhxd.jpg',
        price:'29.52',
        text:"These handmade face masks / mouth masks are the perfect (fashion) accessory to protect yourself from the bad air, the haze, pollution, during the flu season, or whatever it may be!",
        rating:'5',
    },
    {
        title:'CUSTOM FACE MASK - (with your choice of 2,3,4 Layers) personalized, customized Face masks, embroidery face masks, with filter pocket',
        img:'https://i.etsystatic.com/6272083/d/il/0863d8/2975787633/il_340x270.2975787633_fu3x.jpg?version=0',
        price:'10.80',
        text:"Personalized Embroidery is for Black thread only and 10 letters max with space included. Case sensitive.",
        rating:'3',
    },
    {
        title:'Luxe Face Mask 2.0 - Madras Love',
        img:'https://i.etsystatic.com/18700789/d/il/d6b64a/2563921738/il_340x270.2563921738_e192.jpg?version=0',
        price:'23.00',
        text:"Take our awesome, artist-created patterns, luxury fabrics and meticulous workmanship. Add everything we’ve learned over many months of mask making and you’ve got our Luxe Face Mask 2.0 – truly the Cadillac of face masks.",
        rating:'4',
    },
    {
        title:'Luxe Face Mask 2.0 - Madras Love',
        img:'https://i.etsystatic.com/18700789/d/il/d6b64a/2563921738/il_340x270.2563921738_e192.jpg?version=0',
        price:'23.00',
        text:"Take our awesome, artist-created patterns, luxury fabrics and meticulous workmanship. Add everything we’ve learned over many months of mask making and you’ve got our Luxe Face Mask 2.0 – truly the Cadillac of face masks.",
        rating:'4',
    },
    {
        title:'Luxe Face Mask 2.0 - Madras Love',
        img:'https://i.etsystatic.com/18700789/d/il/d6b64a/2563921738/il_340x270.2563921738_e192.jpg?version=0',
        price:'23.00',
        text:"Take our awesome, artist-created patterns, luxury fabrics and meticulous workmanship. Add everything we’ve learned over many months of mask making and you’ve got our Luxe Face Mask 2.0 – truly the Cadillac of face masks.",
        rating:'4',
    },
    {
        title:'Luxe Face Mask 2.0 - Madras Love',
        img:'https://i.etsystatic.com/18700789/d/il/d6b64a/2563921738/il_340x270.2563921738_e192.jpg?version=0',
        price:'23.00',
        text:"Take our awesome, artist-created patterns, luxury fabrics and meticulous workmanship. Add everything we’ve learned over many months of mask making and you’ve got our Luxe Face Mask 2.0 – truly the Cadillac of face masks.",
        rating:'4',
    },
    {
        title:'Luxe Face Mask 2.0 - Madras Love',
        img:'https://i.etsystatic.com/18700789/d/il/d6b64a/2563921738/il_340x270.2563921738_e192.jpg?version=0',
        price:'23.00',
        text:"Take our awesome, artist-created patterns, luxury fabrics and meticulous workmanship. Add everything we’ve learned over many months of mask making and you’ve got our Luxe Face Mask 2.0 – truly the Cadillac of face masks.",
        rating:'4',
    },
    {
        title:'Luxe Face Mask 2.0 - Madras Love',
        img:'https://i.etsystatic.com/18700789/d/il/d6b64a/2563921738/il_340x270.2563921738_e192.jpg?version=0',
        price:'23.00',
        text:"Take our awesome, artist-created patterns, luxury fabrics and meticulous workmanship. Add everything we’ve learned over many months of mask making and you’ve got our Luxe Face Mask 2.0 – truly the Cadillac of face masks.",
        rating:'4',
    },
    {
        title:'Luxe Face Mask 2.0 - Madras Love',
        img:'https://i.etsystatic.com/18700789/d/il/d6b64a/2563921738/il_340x270.2563921738_e192.jpg?version=0',
        price:'23.00',
        text:"Take our awesome, artist-created patterns, luxury fabrics and meticulous workmanship. Add everything we’ve learned over many months of mask making and you’ve got our Luxe Face Mask 2.0 – truly the Cadillac of face masks.",
        rating:'4',
    },
    {
        title:'Luxe Face Mask 2.0 - Madras Love',
        img:'https://i.etsystatic.com/18700789/d/il/d6b64a/2563921738/il_340x270.2563921738_e192.jpg?version=0',
        price:'23.00',
        text:"Take our awesome, artist-created patterns, luxury fabrics and meticulous workmanship. Add everything we’ve learned over many months of mask making and you’ve got our Luxe Face Mask 2.0 – truly the Cadillac of face masks.",
        rating:'4',
    },
    {
        title:'Luxe Face Mask 2.0 - Madras Love',
        img:'https://i.etsystatic.com/18700789/d/il/d6b64a/2563921738/il_340x270.2563921738_e192.jpg?version=0',
        price:'23.00',
        text:"Take our awesome, artist-created patterns, luxury fabrics and meticulous workmanship. Add everything we’ve learned over many months of mask making and you’ve got our Luxe Face Mask 2.0 – truly the Cadillac of face masks.",
        rating:'4',
    },
    {
        title:'Luxe Face Mask 2.0 - Madras Love',
        img:'https://i.etsystatic.com/18700789/d/il/d6b64a/2563921738/il_340x270.2563921738_e192.jpg?version=0',
        price:'23.00',
        text:"Take our awesome, artist-created patterns, luxury fabrics and meticulous workmanship. Add everything we’ve learned over many months of mask making and you’ve got our Luxe Face Mask 2.0 – truly the Cadillac of face masks.",
        rating:'4',
    },
    {
        title:'Luxe Face Mask 2.0 - Madras Love',
        img:'https://i.etsystatic.com/18700789/d/il/d6b64a/2563921738/il_340x270.2563921738_e192.jpg?version=0',
        price:'23.00',
        text:"Take our awesome, artist-created patterns, luxury fabrics and meticulous workmanship. Add everything we’ve learned over many months of mask making and you’ve got our Luxe Face Mask 2.0 – truly the Cadillac of face masks.",
        rating:'4',        rating:'4',

    },
    {
        title:'Luxe Face Mask 2.0 - Madras Love',
        img:'https://i.etsystatic.com/18700789/d/il/d6b64a/2563921738/il_340x270.2563921738_e192.jpg?version=0',
        price:'23.00',
        text:"Take our awesome, artist-created patterns, luxury fabrics and meticulous workmanship. Add everything we’ve learned over many months of mask making and you’ve got our Luxe Face Mask 2.0 – truly the Cadillac of face masks.",
        rating:'4',        rating:'4',

    },
]

async function seedDB()
{
    await  Item.insertMany(arr);
    console.log("DB Seeded!!!");
         
}

module.exports= seedDB;