//카테고리 입력칸 숨기기
$(function () {
    $("#ctMajorForm").hide();
    $("#ctMinorForm").hide();
})

//create 선택시 카테고리명 입력 칸 생성
function selectFunction() {
    if ($("#selectCategory option:selected").val() == 0) {
        $("#ctMajorForm").show();
        $("#ctMinorForm").hide();
    } else {
        $("#ctMajorForm").hide();
        $("#ctMinorForm").show();
    }
}