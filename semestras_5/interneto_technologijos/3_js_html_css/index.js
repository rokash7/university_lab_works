const vardas = document.getElementById('input_name');
// const pavarde = document.getElementById('input_surname');
const amzius = document.getElementById('input_age');
// const email = document.getElementById('input_email');
const date = document.getElementById('input_date');
// const lytis = document.getElementById('select_gender');
const form = document.getElementById('form1');
//const name_error = document.getElementById('name_error');
const age_error = document.getElementById('age_error');
const date_error = document.getElementById('date_error');
var received = []
let source = "";

form.addEventListener('submit', (e) => {
    let errorExists = false;

    if (vardas.value === '' || vardas.value == null) {
        errorExists = true;
        $("#name_error").css("display", "block");
    }
    else {
        $("#name_error").css({
            display: "none"
        });
    }

    if (!isPositiveInteger(amzius.value)) {
        errorExists = true;
        age_error.setAttribute('style', 'display: visible');
    }
    else {
        age_error.setAttribute('style', 'display: none');
    }

    if (!isCorrectDate(date.value)) {
        errorExists = true;
        date_error.setAttribute('style', 'display: visible');
    }
    else {
        date_error.setAttribute('style', 'display: none');
    }
    
    if (errorExists) {
        e.preventDefault();
    }
    else{
        e.preventDefault();
        jsonblobPOST();
    }
})

function isPositiveInteger(str) {
    if (typeof str !== 'string') {
        return false;
    }

    const num = Number(str);

    if (Number.isInteger(num) && num > 0) {
        return true;
    }

    return false;
}

function isCorrectDate(val) {
    if (new Date(val) !== "Invalid Date" && !isNaN(new Date(val))) {
        return true;
    } else {
        return false;
    }
}

$("#b3_1").click(function() {
    $("#para_3_1").text("Pavyko!");
});

$("#b3_2").click(function() {
    $("#para_3_2").attr("style", "color: #C0BABC; font-size: 150%");
});

$("#b3_3").click(function() {
    $("#para_3_3").remove();
});

$("#b3_4").click(function() {
    $("#para_3_4").append(vardas.value);
});

$("#b4").click(function() {
    jsonblobGET();
    setTimeout(() => { updateTable() }, 300);
});

function jsonblobPOST() {
    let obj = {
        name: vardas.value,
        age: amzius.value,
        date: date.value
    }

        $.ajax({
            type: 'POST',
            url: 'https://jsonblob.com/api/jsonBlob',
            data: JSON.stringify(obj),
            contentType: 'application/json',
            Accept: ' application/json',
            headers: { 'Access-Control-Allow-Origin': '*' },
            success: function (data, status, xhr) {
                source = xhr.getResponseHeader('location').replace("http", "https")
                console.log(source);
            },
            error: function (data) {
                console.log("e");
                console.log(data);
            }
        })
    
}

function jsonblobGET() {
    
    $.ajax({
        type: 'GET',
        url: source,
        headers: { 'Access-Control-Allow-Origin': '*' },
        success: function (data) {
            received = data;
            console.log(data);
        },
        error: function (data) {
            console.log("e");
            console.log(data);
        }
    })
}

function updateTable(){
    let row = $(`<tr><td>${received.name}</td><td>${received.age}</td><td>${received.date}</td></tr>`);
    row.appendTo("#table1 > table");
}

// function isValidDate(val) {
//     let n = Date.parse(val)
//     let reg = /^\d{4}-\d{2}-\d{2}$/

//     if (isNaN(n) || !val.match(reg)) {
//         return false
//     }
//     else {
//         return true
//     }
// }

//const errorElement = document.getElementById('error');

// form1.addEventListener('submit', (e) => {
//     let messages = [];
//     if (vardas.value === '' || vardas.value == null) {
//         messages.push('Prašome įvesti vardą!');
//     }

//     if (!isPositiveInteger(amzius.value)) {
//         messages.push('Amžius turi būti teigiamas skaičius didesnis už 0!');
//     }

//     if (!isCorrectDate(date.value)) {
//         messages.push('Neteisinga data!');
//     }

//     if (messages.length > 0) {
//         e.preventDefault();
//         errorElement.innerText = messages.join('\n');
//     }
// })