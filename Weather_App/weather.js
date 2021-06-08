const api={
key:"148de8b6ab22d1a83fb303c850231c49", base:"https://api.openweathermap.org/data/2.5/"
}
const searchbox=document.querySelector(".searchBox");
searchbox.addEventListener("keypress",setq);
function setq(evt)
{
if(evt.keyCode==13)
{
result(searchbox.value);
}
}

function result(valu)
{
fetch(`${api.base}weather?q=${valu}&units=metric&APPID=${api.key}`).then(weather=>{return weather.json();}).then(display);
}

function display(weather)
{
let city=document.querySelector(".demo1 .cityname");
city.innerText=`${weather.name},${weather.sys.country}`;

let newdat=new Date();
let date=document.querySelector(".demo1 .date");
date.innerText=datenew(newdat);



let temperat=document.querySelector(".demo1 .temp");
temperat.innerHTML = `${Math.round(weather.main.temp)}<span>&#xb0;c</span>`;

let whether=document.querySelector(".demo1 .weather");
whether.innerText=weather.weather[0].main;

let maxmin=document.querySelector(".max");
maxmin.innerText=`${Math.floor(weather.main.temp_min)} C / ${Math.ceil(weather.main.temp_max)} C`;
}

function datenew(newdat) {
  let month=["January","February","March","April","May","June","July","August","September","October","November","December"];
let day=["Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"];

  let days=day[newdat.getDay()];
  let date=newdat.getDate();
  let months=month[newdat.getMonth()];
  let year=newdat.getFullYear();

  return `${days} ${date} ${months} ${year}`;

}