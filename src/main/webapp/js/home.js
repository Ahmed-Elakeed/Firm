const val = document.getElementById("hide").getAttribute("value");
if(val=="null"){
    document.getElementsByTagName("body")[0].style.visibility = "hidden";
}