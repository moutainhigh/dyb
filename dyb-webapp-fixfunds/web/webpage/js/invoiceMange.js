/**
 * Created by aaa on 2016/10/15.
 */
$(function(){
    $(".dropdown-toggle").eq(0).click(function(){
        $(".select1").toggleClass("open");
    })
    $(".sui-dropdown-menu1 li").click(function(){
        var i=$(".sui-dropdown-menu1 li").index(this);
        var x= $(".sui-dropdown-menu1 li a").eq(i).html();
        $(".sui-dropdown-menu1 li").removeClass("active");
        $(".sui-dropdown-menu1 li").eq(i).addClass("active");
        $(".select1 span span").html(x);
        $(".select1").removeClass("open");
    })
    $(".dropdown-toggle").eq(1).click(function(){
        $(".select2").toggleClass("open");
    })
    $(".sui-dropdown-menu2 li").click(function(){
        var i=$(".sui-dropdown-menu2 li").index(this);
        var x= $(".sui-dropdown-menu2 li a").eq(i).html();
        $(".sui-dropdown-menu2 li").removeClass("active");
        $(".sui-dropdown-menu2 li").eq(i).addClass("active");
        $(".select2 span span").html(x);
        $(".select2").removeClass("open");
    })
    $('.dropdown-inner').mouseleave(function(){
        $(".select1").removeClass("open");
        $(".select2").removeClass("open");
    });
    $(".sui-nav li").click(function(){
        var i=$(".sui-nav li").index(this)
        $(".sui-nav li").removeClass("active");
        $(".sui-nav li").eq(i).addClass("active");
        $(".tab-pane").removeClass("active");
        $(".tab-pane").eq(i).addClass("active");
    })
    $(".btn-fontBlue1").click(function(){
        $(".sui-modal").addClass("in");
        $(".sui-modal-backdrop").css("zIndex","1000").addClass("in");
    });
    $(".sui-close").click(function(){
        $(".sui-modal").removeClass("in");
        $(".sui-modal-backdrop").css("zIndex","-1").removeClass("in");
    })
    $(".btn-large").click(function(){
        $(".sui-modal").removeClass("in");
        $(".sui-modal-backdrop").css("zIndex","-1").removeClass("in");
    })
})
function getdonatelist(pageIndex){
    var param={
//        当前页
        pageIndex:pageIndex,
//        请求条数
        pageSize:1
    };
    var result=invokeService('/web/merchant/donationreceiptapply/getDonationReceiptApplyPageList',param);
    if(result.statusCode!=1000){
        alert(result.errorMessage);
        return;
    }
    var pageCount=result.result.pageCount;
    $("#table>table>tbody").html("");
    for(var i =0;i<result.result.list.length;i++){
        $("#table>table>tbody").html($("#table>table>tbody").html()+
                "<tr>"+
                "<td>"+
                result.result.list[i].donationReceiptApplyCode+
                "</td>"+
                "<td>"+
                result.result.list[i].receiptMoney+
                "</td>"+
                "<td>"+
                result.result.list[i].chargeWay+
                "</td>"+
                "<td>"+
                result.result.list[i].isCertificate+
                "</td>"+
                "<td>"+
                result.result.list[i].applyTime+
                "</td>"+
                "<td>"+
                result.result.list[i].applyStatus+
                "</td>"+
                "</tr>"
        )
    }
    return pageCount;
}

$(function() {
    var pageIndex = 0;
    var pageCount = getdonatelist(pageIndex);
    page("excit", pageCount, pageIndex);
    // 下一頁
    $("#excit").on("click", "#nextBtn", function () {
        if (pageIndex + 1 >= pageCount) {
            return;
        }
        pageIndex++;
        getdonatelist(pageIndex);
        page("excit", pageCount, pageIndex);
    })
    // 上一頁
    $("#excit").on("click", "#prevBtn", function () {
        if (pageIndex == 0) {
            return;
        }
        pageIndex--;
        getdonatelist(pageIndex);
        page("excit", pageCount, pageIndex);
    })
    // 點擊調頁
    $("#excit").on("click", "#selectPage", function () {
        var valIndex = $("#selectPageNum").val() - 1;
        if (valIndex >= 0 && valIndex + 1 <= pageCount) {
            pageIndex = valIndex;
            getdonatelist(pageIndex);
            page("excit", pageCount, pageIndex);
        } else {
            $("#selectPageNum").val("");
            return;
        }
    })
})