// Get the modal


 modal = document.getElementById("loginform");
// Get the button that opens the modal
 btn = document.getElementById("login");

 cancelBtn = document.getElementById("cnclbtn");

// When the user clicks on the button, open the modal
btn.onclick = function() {
    modal.style.display = "block";
}

// When the user clicks on <span> (x), close the modal
cancelBtn.onclick = function() {
    modal.style.display = "none";
}

window.onClick = function(){
		modal.style.display= "none";
}