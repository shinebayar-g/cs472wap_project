(function () {
    "use strict";
    window.onload = function () {
        for (let i=0; i<document.getElementsByClassName("addBtn").length; i++) {
            document.getElementsByClassName("addBtn")[i].addEventListener("click", addBtnClickHandler);
        }

        for (let i=0; i<document.getElementsByClassName("deleteBtn").length; i++) {
            document.getElementsByClassName("deleteBtn")[i].addEventListener("click", delBtnClickHandler);
        }
    };

    function addBtnClickHandler() {
        let rowIndex = this.parentNode.parentNode.rowIndex;
        let courseCode = document.getElementById('available_courses').rows[rowIndex].cells[0].innerHTML;
       // alert(courseCode);
        console.log("adding course id to table: " + rowIndex);

        $.ajax("addcourse", {
            "type": "POST",
            "data": {
                "course": courseCode,
            },
            success: function(response) {
                console.log("added course ajax response: " + JSON.stringify(response));
                addToTable(response);
            }
        });
    }

    function addToTable(course) {
        let table = document.getElementById("myCourses").getElementsByTagName('tbody')[0];
        let row = document.createElement("tr");
        row.innerHTML = `
            <td>${table.rows.length+1}</td>
            <td>${course.code}</td>
            <td>${course.name}</td>
            <td>${course.credits}</td>
            <td>${course.instructor}</td>
            <td><button class="deleteBtn" type="submit">Delete this course</button></td>
        `;
        table.appendChild(row);
        row.getElementsByClassName("deleteBtn")[0].onclick = delBtnClickHandler;
    }

    function delBtnClickHandler() {
        let rowIndex = this.parentNode.parentNode.rowIndex;
     //   alert(rowIndex);
        let courseCode = document.getElementById('myCourses').rows[rowIndex].cells[1].innerHTML;
    //    alert(courseCode);
        $.ajax("deletecourse", {
            "type": "POST",
            "data": {
                "course": courseCode,
            },
            success: function() {
                document.getElementById("myCourses").deleteRow(rowIndex);
            }
        });
    }

})();
