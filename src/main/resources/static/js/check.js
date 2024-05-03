function check(){
    if(document.getElementById("exam_no").value.trim().length == 0){
        alert("학번이 입력되지 않았습니다.")
        document.getElementById("exam_no").focus();
        return false
    }
    if(document.getElementById("kor").value.trim().length == 0){
            alert("국어점수가 입력되지 않았습니다.")
            document.getElementById("exam_no").focus();
            return false
    }
    if(document.getElementById("math").value.trim().length == 0){
            alert("수학점수가 입력되지 않았습니다.")
            document.getElementById("exam_no").focus();
            return false
    }
    if(document.getElementById("eng").value.trim().length == 0){
            alert("영어점수가 입력되지 않았습니다.")
            document.getElementById("exam_no").focus();
            return false
    }
    if(document.getElementById("his").value.trim().length == 0){
                alert("역사점수가 입력되지 않았습니다.")
                document.getElementById("exam_no").focus();
                return false
    }
    alert("입력이 완료되었습니다.")
    document.getElementById("frm").submit();
    return true
}