addEventListener('keyup', function() {
    const idcheck = document.getElementById("userid").value;
    const passcheck = document.getElementById("userpass").value;

    if (idcheck.length !== 0 && passcheck.length !== 0) {
        document.getElementsByClassName("loginbutton")[0].setAttribute("class", "afterbutton");           
    }
});