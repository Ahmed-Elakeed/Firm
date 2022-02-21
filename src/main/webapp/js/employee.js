const val = document.getElementById("hide").getAttribute("value");
const val2 = document.getElementById("hide1").getAttribute("value");
if(val=="null"){
    document.getElementsByTagName("body")[0].style.visibility = "hidden";
}
if(val2=="employee"){
    document.getElementById("del").style.display="none";
}