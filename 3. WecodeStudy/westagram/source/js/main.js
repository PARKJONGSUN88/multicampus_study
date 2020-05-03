addEventListener('keyup', function() {    
    let comment = document.getElementsByClassName("comment-write")[0].value;
    if (comment.length !== 0) {
        document.getElementsByClassName("submitButton")[0].setAttribute("class", "clickbutton");           
    }
});


let commentText = document.getElementsByClassName("comment-write")[0];
addEventListener('keyup', function(input) {    
    if(input.keyCode === 13) {
        console.log("Hi");
    }
});