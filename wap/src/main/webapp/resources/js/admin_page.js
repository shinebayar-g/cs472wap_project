$(function () {

    function load() {
        $.ajax({
            type: 'GET',
            url: 'admin?type=json',
            success: function (result) {
                reload(result);
            }
        });
    }

    load();
    function reload(result) {
        let JSONObjectArray = result;
        let table = document.getElementById("tbl");
        let rowCount = table.rows.length;
        for (let i = 0; i < JSONObjectArray.length ; i++) {
            let JSONObject = JSONObjectArray[i];
            let row = table.insertRow(i + 1);

            let cell0 = row.insertCell(0);
            let cell1 = row.insertCell(1);
            let cell2 = row.insertCell(2);
            let cell3 = row.insertCell(3);
            let cell4 = row.insertCell(4);
            let cell5 = row.insertCell(5);
            let cell6 = row.insertCell(6);

            cell0.innerHTML = (i + 1);
            cell1.innerHTML = JSONObject.code;
            cell2.innerHTML = JSONObject.name;
            cell3.innerHTML = JSONObject.credit;
            cell4.innerHTML = JSONObject.instructor;

            /**************************** Edit Button *****************************/
            var editButton = document.createElement('input');
            editButton.setAttribute('type', 'button');
            editButton.setAttribute('value', 'Edit');
            editButton.setAttribute('onclick', 'fetchRowData(' + (i + 1) + ')');
            cell5.appendChild(editButton);
            /**************************** Delete Button *****************************/
            var deleteButton = document.createElement('input');
            deleteButton.setAttribute('type', 'button');
            deleteButton.setAttribute('value', 'Delete');
            deleteButton.setAttribute('onclick', 'deleteRow(' + (i + 1) + ')');
            cell6.appendChild(deleteButton);
        }
    }
});



    /*
   * Clear Form Content
   * */
    $('#btnClear').click(function () {
        document.getElementById('course_code').value = "";
        document.getElementById("course_code").readOnly = false;
        document.getElementById('course_name').value = "";
        document.getElementById('course_credits').value = "";
        document.getElementById('course_instructor').value = "";
    })

/* Add Button Handler
* */
    $('#btnAdd').click(function () {
        //alert("Adding new...")
        let code = $('#course_code').val();
        let name = $('#course_name').val();
        let credit = $('#course_credits').val();
        let instructor = $('#course_instructor').val();

        $.ajax({
            type: 'POST',
            data: {
                course_code: code,
                course_name: name,
                course_credits: credit,
                course_instructor: instructor,
                action: 'add'
            },
            url: 'admin',
            success: function (result) {
                reload(result);
            }
        });

        //re build the UI elements=> Buttons
        window.location.reload();
    });

    /*
    * Save Edit Handler
    * */
    $('#btnSaveEdit').click(function () {
        //course_code course_name course_credits course_instructor

        let id = $('#course_code').val();
        let name = $('#course_name').val();
        let credit = $('#course_credits').val();
        let instructor = $('#course_instructor').val();

        $.ajax({
            type: 'POST',
            data: {
                course_code: id,
                course_name: name,
                course_credits: credit,
                course_instructor: instructor,

                action: 'saveupdate'
            },
            url: 'admin',
            success: function (result) {
                reload(result);
            }
        });
        window.location.reload();
        //re build the UI elements=> Buttons
        //location.reload();
    });

    function deleteRow(rowIndex) {
        let rowData = document.getElementById("tbl").rows[rowIndex];
        //Create Ajax Call to Delete from the Backend
        let courseId = rowData.cells[1].innerHTML;
        deleteAjax(courseId);
        //Delete From the UI
        document.getElementById("tbl").deleteRow(rowIndex);
    }

    function fetchRowData(rowIndex) {
        let rowData = document.getElementById("tbl").rows[rowIndex];

        document.getElementById('course_code').value = rowData.cells[1].innerHTML;
        document.getElementById("course_code").readOnly = true;
        document.getElementById('course_name').value = rowData.cells[2].innerHTML;
        document.getElementById('course_credits').value = rowData.cells[3].innerHTML;
        document.getElementById('course_instructor').value = rowData.cells[4].innerHTML;
    }

    function deleteAjax(courseId) {
        $.ajax({
            type: 'POST',
            url: 'admin',
            data: {
                course_code: courseId,
                action: 'delete'
            },
            success: function (result) {
                //    alert("Return Result from Delete :" + result);
                reload();
            }
        });
    }






