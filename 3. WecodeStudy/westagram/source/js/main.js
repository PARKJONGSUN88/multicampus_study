/* 댓글 게시 버튼 요소겟 */
const submitButtonClick = document.getElementsByClassName("submitButton")[0];
const commentDone = document.getElementsByClassName("comment-write")[0];

/* 댓글쓰는 곳에 내용이 null이 아니면 css가 변경됨 */
commentDone.addEventListener("keydown", function(e) {
    if (commentDone.value.length !== null) {
        submitButtonClick.classList.add("clickbutton") //clickbutton이 변경될 css 클래스
    }
})

/* 댓글쓴사람명 임시값 */
const superUser = "js_Park"

/* 댓글달기 기능 함수 */
function commentWrite() { 
    let btag = document.createElement("b");
    btag.innerHTML = superUser;    
    let commentViewSpan = document.createElement('span'); 
    let commentText = commentDone.value;       
    commentViewSpan.innerHTML = commentText;
    let result = document.getElementsByClassName("comment-view-div")[0];
    result.appendChild(btag);    
    result.appendChild(commentViewSpan);
    let brtag = document.createElement("br");
    result.appendChild(brtag);  
}

/* 게시 버튼 클릭 시 댓글함수 실행 */
submitButtonClick.addEventListener("click", function() {
    commentWrite();
});

/* 엔터키 눌렸을 때 댓글함수 실행 */
commentDone.addEventListener('keydown', function(e) {    
    if (e.keyCode === 13 ) {
        commentWrite();
    }
})