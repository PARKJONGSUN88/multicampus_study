addEventListener('keyup', function() {
    let comment = document.getElementsByClassName("comment-write")[0].value;
    if (comment.length !== 0) {
        document.getElementsByClassName("submitButton")[0].classList.add("clickbutton");
    }
});

let superUser = "js_Park"
function commentWrite() {
    let result = document.getElementsByClassName("comment-view-div")[0];
    let btag = document.createElement("b");
    btag.innerHTML = superUser;
    let commentText = document.getElementsByClassName("comment-write")[0].value;
    let commentViewSpan = document.createElement('span');    
    commentViewSpan.innerHTML = commentText;
    let brtag = document.createElement("br");
    result.appendChild(btag);
    result.appendChild(commentViewSpan);
    result.appendChild(brtag);  
}

let enterPass = document.getElementsByClassName("comment-write")[0];
enterPass.addEventListener('keydown', function(e) {
    if (e.keyCode === 13 ) {
        commentWrite();
    }
})