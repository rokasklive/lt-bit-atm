var url = "https://lt-bit-atm.herokuapp.com/state";
var interval = setInterval(request, 3000);
function request(){ $.ajax({
        url: url,
        data: "http",
        type: "POST",

        beforeSend: function(xhr) {
            xhr.setRequestHeader("Accept", "application/json");
            xhr.setRequestHeader("Content-Type", "application/json");
        },
        success: function(result) {},
        statusCode: {
            428: function(){
                console.log("428");
            },
            204: function(){
                console.log("204");
                stopInterval()
                $(".pin_form").css("display", "inline-block");

            }
        }
    });
}
function stopInterval(){
    clearInterval(interval);
}
