/**
 * Created by L.H.S on 2017/6/11.
 */

function search() {

    var inputs = $("input");

    var movieName = inputs.eq(0).val();
    var theater = inputs.eq(1).val();
    var date = inputs.eq(2).val();

    if (movieName == "") {
        alert("请输入电影名");
        return;
    }

    if (theater == "") {
        alert("请输入影院名");
        return;
    }

    if (date == "") {
        alert("请选择观影日期");
        return;
    }

    location.href = ("/search?movieName=" + movieName + "&theater=" + theater + "date=" + date);

}