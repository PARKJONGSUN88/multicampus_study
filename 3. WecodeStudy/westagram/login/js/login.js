addEventListener('keydown', function() {
    let idcheck = document.getElementById("userid").value;
    let passcheck = document.getElementById("userpass").value;
    let logbutton = document.getElementById("loginbutton");


s
    if (idcheck.length !== 0 && passcheck.length !== 0) {

        console.log("펑션오케이");


        
        logbutton.setAttribute("color", "blue");
        

    }
});
